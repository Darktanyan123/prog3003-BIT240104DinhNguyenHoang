
package com.mycompany.exfive;

import java.util.LinkedList;

public class QueueExample {
    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.addFirst(5);
        queue.addLast(40);

        queue.removeFirst();
        queue.removeLast();

        System.out.println(queue);
    }
}
