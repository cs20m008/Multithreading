package ZeroEvenOdd;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void zeroEvenOddMain() throws InterruptedException {
        ZeroEvenOdd instance=new ZeroEvenOdd();
        ExecutorService executor= Executors.newFixedThreadPool(3);
        executor.submit(()->{

                try {
                    instance.zero();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

        });
        executor.submit(()->{

                try {
                    instance.odd();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

        });
        executor.submit(()->{

                try {
                    instance.even();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

        });
        Thread.sleep(10000);
        executor.shutdownNow();



    }
}
