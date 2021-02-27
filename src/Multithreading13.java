import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Multithreading13 {
    static boolean flag=true;
    static int i=0;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        Multithreading13 ob=new Multithreading13();
        executorService.execute(() -> {
            try {
                ob.send();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {
                ob.receive();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
    public synchronized void send() throws InterruptedException {
        while (!flag){
            wait();
        }
        i=5;
        flag=false;
        notify();
    }
    public synchronized void receive() throws InterruptedException {
        while (flag){
            wait();
        }
        notify();
        System.out.println(i);
    }
}
