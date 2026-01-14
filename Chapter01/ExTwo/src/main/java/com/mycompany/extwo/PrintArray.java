package com.mycompany.extwo;

public class PrintArray {

    public static <E> void printArray(E[] array) {
        for (E element : array) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {

        Integer[] intArray = {1, 2, 3, 4, 5};
        printArray(intArray);


        String[] stringArray = {"Java", "Generic", "Method"};
        printArray(stringArray);
    }
}
