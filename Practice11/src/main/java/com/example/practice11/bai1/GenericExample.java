package com.example.practice11.bai1;

public class GenericExample {

    // Generic Method
    public static <E> void printArray(E[] array) {
        for (E element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"Java", "Python", "C++"};

        System.out.print("Integer Array: ");
        printArray(intArray);

        System.out.print("String Array: ");
        printArray(strArray);
    }
}