package ua.burkavtsov.hw25.hw25_2;

import java.util.concurrent.atomic.AtomicInteger;

public class Task3 {
    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Runnable incrementTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter.incrementAndGet();
                }
            }
        };

        Thread thread1 = new Thread(incrementTask);
        Thread thread2 = new Thread(incrementTask);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final (Atomic Variable): " + counter.get());
    }
}