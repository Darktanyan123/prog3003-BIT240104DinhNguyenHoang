package com.mycompany.exsix;

import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 9, 2, 5, 8, 1};

        HashSet<Integer> set = new HashSet<>();

        for (int n : numbers) {
            set.add(n);
        }

        // HashSet không duy trì thứ tự chèn phần tử, nên thứ tự in ra có thể khác với mảng ban đầu

        System.out.println(set);
    }
}
