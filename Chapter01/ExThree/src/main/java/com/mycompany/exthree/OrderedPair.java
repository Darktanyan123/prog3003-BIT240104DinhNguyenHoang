// ===== BÀI 3 =====
package com.mycompany.exthree;

interface Pair<K, V> {
    K getKey();
    V getValue();
}

class OrderedPair<K, V> implements Pair<K, V> {
    private K key;
    private V value;

    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public static void main(String[] args) {
        Pair<String, Integer> p1 = new OrderedPair<>("MSSV", 10170);
        Pair<String, String> p2 = new OrderedPair<>("HoTen", "Nguyen Thi Hoa");

        System.out.println(p1.getKey() + ": " + p1.getValue());
        System.out.println(p2.getKey() + ": " + p2.getValue());
    }
}
