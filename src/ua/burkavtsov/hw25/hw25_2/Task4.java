package ua.burkavtsov.hw25.hw25_2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Task4 {
    private static BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);

    public static void main(String[] args) throws InterruptedException {
        Runnable producer = new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 1; i <= 10; i++) {
                        queue.put(i);
                        System.out.println("Produced: " + i);
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        int value = queue.take();
                        System.out.println("Consumed: " + value);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        producerThread.start();
        consumerThread.start();
        producerThread.join();
        consumerThread.join();
    }
}