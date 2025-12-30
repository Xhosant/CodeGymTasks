package com.codegym.task.task30.task3003;

import java.util.Set;
import java.util.concurrent.TransferQueue;

public class Producer implements Runnable {
    private final TransferQueue<SharedItem> queue;

    public Producer(TransferQueue<SharedItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            queue.offer(new SharedItem("SharedItem-"+i, i));
            System.out.format("'SharedItem-%d' added\n", i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {}

            if(queue.hasWaitingConsumer()){
                System.out.format("Consumer is waiting!\n");
            }
        }
    }
}
