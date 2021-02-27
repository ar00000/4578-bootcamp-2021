import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Multithreading16 {
    static ReentrantLock reentrantLock=new ReentrantLock();
    static int i=0,j=0;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        Multithreading16 ob=new Multithreading16();
        executorService.execute(() -> {
            try {
                send(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {
                receive(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
    public static synchronized void send(int caller) throws InterruptedException {
        try {
            if(!reentrantLock.tryLock())
                return;
            receive(caller);
            System.out.println("Send by: "+caller);
        }
        finally {
            reentrantLock.unlock();
        }
    }
    public synchronized static void receive(int caller) throws InterruptedException {
        try {
            if(reentrantLock.tryLock())
                return;
            send(caller);
            System.out.println("Received by: "+caller);
        }
        finally {
            reentrantLock.unlock();
        }
    }
}
