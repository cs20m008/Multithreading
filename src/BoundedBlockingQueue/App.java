package BoundedBlockingQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void boundedBlockingQueueMain() throws InterruptedException {   BoundedBlockingQueue instance=new BoundedBlockingQueue();
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        executorService.submit(()->{
            for(int i=0;i<20;i++)
            {
                try {
                    System.out.println(instance.deque());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executorService.submit(()->{
            for(int i=0;i<20;i++)
            {
                try {
                    instance.enque(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread.sleep(10000);
        executorService.shutdown();
    }
}
