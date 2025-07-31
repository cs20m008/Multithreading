package ZeroEvenOdd;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

public class ZeroEvenOdd {
    int number=1;
    Boolean zero=true;
    Semaphore mutex0=new Semaphore(1);
    Semaphore mutexOdd=new Semaphore(0);
    Semaphore mutexEven=new Semaphore(0);
  //  Semaphore mutexn=new Semaphore(1);
    public void zero() throws InterruptedException {
        for(int i=1;i<20;i++)
        {
            mutex0.acquire();
            System.out.println("zero "+0);
            if(i%2==0)
            {
                mutexEven.release();
            }
            else
                mutexOdd.release();

        }

    }
    public void even() throws InterruptedException {
        for(int i=2;i<20;i=i+2)
        {
            mutexEven.acquire();
            System.out.println("even "+i);
            mutex0.release();
        }

    }
    public void odd() throws InterruptedException {
        for(int i=1;i<20;i=i+2)
        {
            mutexOdd.acquire();
            System.out.println("odd "+i);
            mutex0.release();
        }
    }

}
