package org.example.concurrency;

public class ConcurrencyExample1 {

    public static void main(String[] args) {
        (new ReadInventoryThread()).start();
        new Thread(new PrintData()).start();
        (new ReadInventoryThread()).start();
    }

    // creating Class which could be executed as separate task in new thread
    public static class PrintData implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("printing record: " + i);
            }
        }
    }

    // creating custom thread
    public static class ReadInventoryThread extends Thread {
        public void run() {
            System.out.println("Printing zoo inventory");
        }
    }

}
