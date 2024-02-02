package ua.burkavtsov.hw25.task1;

public class var1 tends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("Hello, A-Level");
                try {
                    Thread.sleep(1000/*мб 100, чтобы дать 1 секунду*/);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void main(String[] args) {
            var1 helloThread = new var1();
            helloThread.start();
        }
    }
}
