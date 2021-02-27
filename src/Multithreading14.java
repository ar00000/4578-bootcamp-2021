import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Multithreading14 {
    static boolean flag=true;
    static int i=0;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        Multithreading14 ob=new Multithreading14();
        executorService.execute(() -> {
            try {
                ob.send();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {
                ob.receiver1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {
                ob.receiver2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {
                ob.receiver3();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
    public synchronized void send() throws InterruptedException {
        i=5;
        flag=false;
        notifyAll();
    }
    public synchronized void receiver1() throws InterruptedException {
        while (flag){
            wait();
        }
        notify();
        System.out.println("Receiver1: "+i);
    }
    public synchronized void receiver2() throws InterruptedException {
        while (flag){
            wait();
        }
        notify();
        System.out.println("Receiver2: "+i);
    }
    public synchronized void receiver3() throws InterruptedException {
        while (flag){
            wait();
        }
        notify();
        System.out.println("Receiver3: "+i);
    }
}
