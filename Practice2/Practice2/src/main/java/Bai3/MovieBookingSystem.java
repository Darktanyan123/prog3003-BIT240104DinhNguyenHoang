package Bai3;

import java.util.concurrent.CompletableFuture;

public class MovieBookingSystem {

    public static void main(String[] args) {

        CompletableFuture<String> verifyCustomer = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Xac thuc khach hang hoan tat");
            return "Khach hang hop le";
        });

        CompletableFuture<String> issueTicket = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Xuat ve xem phim thanh cong");
            return "Da xuat ve";
        });

        CompletableFuture<String> result = verifyCustomer.thenCombine(issueTicket,
                (customer, ticket) -> customer + " - " + ticket);

        System.out.println(result.join());
    }
}