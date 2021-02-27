import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Multithreading15 {
    ReentrantLock lock=new ReentrantLock();
    Condition flag=lock.newCondition();
    Condition flag1=lock.newCondition();
    static int i=0;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(4);
        Multithreading15 ob=new Multithreading15();
        executorService.execute(() -> {
            try {
                ob.send();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {
                ob.receiver1(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {
                ob.receiver(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {
                ob.receiver(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
    public void send() throws InterruptedException {
        try {
            Thread.sleep(5000);
            lock.lock();
            i = 5;
            flag.signalAll();
        }
        finally{
            lock.unlock();
        }
    }
    public void receiver(int j) throws InterruptedException {
        try {
            lock.lock();
            flag.await();
            System.out.println("Concurrent Receivers"+j+": "+i);
            flag1.signal();
        }
        finally {
            lock.unlock();
        }
    }

    public void receiver1(int j) throws InterruptedException {
        try {
            lock.lock();
            flag1.await();
            System.out.println("Last Receiver"+j+": "+i);
        }
        finally {
            lock.unlock();
        }
    }
}
