package FizzBuzz;

import java.util.concurrent.Semaphore;

public class FizzBuzz {
    int temp=-1;
    Semaphore semaphoreNumber=new Semaphore(1);
    Semaphore semaphoreFizz=new Semaphore(0);
    Semaphore semaphoreBuzz=new Semaphore(0);
    Semaphore semaphoreFizzBuzz=new Semaphore(0);

    public void fizz() throws InterruptedException {
        for(int i=3;i<20;i=i+3) {
            semaphoreFizz.acquire();
            System.out.println("fizz");
            semaphoreNumber.release();
        }

    }
    public void buzz() throws InterruptedException {
        for(int i=5;i<20;i=i+5) {
            semaphoreBuzz.acquire();
            System.out.println("buzz");
            semaphoreNumber.release();
        }
    }
    public void fizzbuzz() throws InterruptedException {
       for(int i=15;i<20;i=i+15) {
           semaphoreFizzBuzz.acquire();
           System.out.println("fizzbuzz");
           semaphoreNumber.release();
       }
    }
    public void number() throws InterruptedException {
        for(int i=1;i<20;i++) {
            semaphoreNumber.acquire();

            if(i%3==0 && i%5==0)

               semaphoreFizzBuzz.release();
             else if (i%3==0)
                semaphoreFizz.release();

             else if (i%5==0)
                semaphoreBuzz.release();

            else {
                System.out.println(i);
                semaphoreNumber.release();
            }


        }
    }

}
