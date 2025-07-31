package BoundedBlockingQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class BoundedBlockingQueue {
    volatile int count=0;
    Queue<Integer> queue=new LinkedList<>();

    public void enque(Integer data) throws InterruptedException {
        synchronized (BoundedBlockingQueue.this) {
            while (count == 10) {
                System.out.println("Its Full");
                wait();
            }
            System.out.println("enque "+data);
            queue.offer(data);
            count++;
            notify();

        }
    }
    public Integer deque() throws InterruptedException {    int data=-1;
        synchronized (BoundedBlockingQueue.this) {
            while (count==0) {
                System.out.println("Its Empty");
                wait();
                System.out.println("Not Empty");
            }

            data= queue.poll();
            count--;
            notify();
        }
        return  data;
    }
    public Integer size()
    {
        synchronized (BoundedBlockingQueue.this)
        {
            return  count;
        }

    }
}
