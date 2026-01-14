package com.mycompany.exfour;

import java.util.ArrayList;

public class FruitList {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        fruits.add(1, "Mango");
        fruits.set(fruits.indexOf("Banana"), "Grapes");

        System.out.println(fruits.contains("Apple"));
    }
}
