
package com.mycompany.bai3;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Bai3 {
    public static void main(String[] args) {

        CompletableFuture
            .supplyAsync(() -> Arrays.asList(1, 2, 5, 3, 100))

            .thenApply(list -> list.stream()
                    .filter(x -> x % 2 != 0) 
                    .sorted()
                    .collect(Collectors.toList())) 

            .thenApply(result -> "Kết quả là: " + result) 

            .thenAccept(System.out::println); 

        try { Thread.sleep(1000); } catch (InterruptedException e) {} 
    }
}
