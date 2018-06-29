package com.lucrortek.concurrency;


import java.util.LinkedList;

public class ProducerConsumerApp {
    static class ProducerConsumer {
        private LinkedList<Integer> list = new LinkedList<Integer>();
        private static final int LIMIT = 10;
        private Object lock = new Object();

        public void produce() throws InterruptedException {
            int value = 1;
            while (true) {
                synchronized (lock) {
                    while (list.size() == LIMIT) {
                        wait();
                    }
                    list.add(value);
                    System.out.println("produced " + value);
                    value++;
                    lock.notify();

                }
            }

        }

        public void consume() throws InterruptedException {
            while (true) {
                synchronized (lock) {
                    while (list.size() == 0) {
                        wait();
                    }
                    int value = list.removeFirst();
                    System.out.println("consumed " + value);
                    lock.notify();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final ProducerConsumer pc = new ProducerConsumer();

        Thread producer = new Thread(new Runnable() {
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {

                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();

                } catch (InterruptedException e) {

                }
            }
        });

        producer.start();
        consumer.start();

        Thread.sleep(30000);
        System.exit(0);

    }
}

