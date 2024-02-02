package ua.burkavtsov.hw25.task2;

public class var2 implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("Hello, A-Level");
            try {
                Thread.sleep(1000/*так же как в первлм варианте*/);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new var2());
        thread.start();
    }
}
