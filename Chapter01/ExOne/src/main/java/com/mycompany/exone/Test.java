package com.mycompany.exone;

public class Test<T> {

    private T value;

    public void set(T t) {
        this.value = t;
    }

    public T get() {
        return value;
    }

    public static void main(String[] args) {
        Test<Integer> testInt = new Test<>();
        testInt.set(10);
        System.out.println(testInt.get());

        Test<String> testString = new Test<>();
        testString.set("Hello");
        System.out.println(testString.get());
    }
}
