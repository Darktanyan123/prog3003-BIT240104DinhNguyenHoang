package Bai3;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

    //(trễ 2 giây)
    public static CompletableFuture<Boolean> authenticate(String customer) {
        return CompletableFuture.supplyAsync(() -> {
            sleep(2000);
            System.out.println("Đang xác thực khách hàng: " + customer);

            if (customer.equals("admin")) {
                return true;
            } else {
                throw new RuntimeException("Xác thực thất bại!");
            }
        });
    }

    // 2. Kiểm tra số dư (giả lập 3 giây)
    public static CompletableFuture<Boolean> checkBalance(double balance, double amount) {
        return CompletableFuture.supplyAsync(() -> {
            sleep(3000);
            System.out.println("Đang kiểm tra số dư...");

            if (balance >= amount) {
                return true;
            } else {
                throw new RuntimeException("Không đủ số dư!");
            }
        });
    }

    // 3. Thực hiện giao dịch (giả lập 1 giây)
    public static CompletableFuture<String> transfer(double amount) {
        return CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            return "Chuyển tiền thành công: " + amount;
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        String customer = "admin";
        double balance = 1000;
        double amount = 500;

        CompletableFuture<String> transaction = authenticate(customer)
                .thenCompose(auth -> checkBalance(balance, amount))
                .thenCompose(balanceOk -> transfer(amount))
                .exceptionally(ex -> {
                    return "Giao dịch bị hủy: " + ex.getMessage();
                });

        System.out.println("Đang xử lý giao dịch...");
        System.out.println(transaction.get());
    }

    // Hàm sleep giả lập độ trễ
    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}