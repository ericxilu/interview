package com.lucrortek.concurrency;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerWithBlockingQueueApp {
    private static BlockingQueue<Integer> blockingQ = new ArrayBlockingQueue<Integer>(10);

    private  void produce() throws InterruptedException {
        Random random = new Random(10);

        while (true) {
            int i = random.nextInt(10);
            System.out.println("putiing item " + i + " queue size "+blockingQ.size());
            blockingQ.put(random.nextInt(10));
        }
    }

    private static void consume() throws InterruptedException{
        Thread.sleep(100);
        while (true) {
            Integer i = blockingQ.take();
            System.out.println("taking item " + i + " queue size "+blockingQ.size());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    produce();
                }catch(InterruptedException ignore){

                }
            }
        });

        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consume();
                }catch(InterruptedException ignore){

                }
            }
        });

        producerThread.start();
        consumerThread.start();


        Thread.sleep(10000);
        System.exit(1);

    }

}
