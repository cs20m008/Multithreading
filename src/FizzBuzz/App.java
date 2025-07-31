package FizzBuzz;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void fizzBuzzMain()
    {
        FizzBuzz instance=new FizzBuzz();
        ExecutorService executor= Executors.newFixedThreadPool(4);
        executor.submit(()->{
            try {
                instance.fizz();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });
        executor.submit(()->{
            try {
                instance.buzz();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });
        executor.submit(()->{
            try {
                instance.fizzbuzz();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });
        executor.submit(()->{
            try {
                instance.number();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executor.shutdownNow();


    }
}
