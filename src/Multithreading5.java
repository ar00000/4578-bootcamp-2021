import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Multithreading5 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        for(int i=0;i<5;i++) {
            executorService.submit(new NewThread(Integer.toString(i)));
        }
        System.out.println("IsShutdown: "+executorService.isShutdown());
        System.out.println("IsTerminated: "+executorService.isTerminated());
        executorService.shutdown();
        System.out.println("IsShutdown: "+executorService.isShutdown());
        System.out.println("IsTerminated: "+executorService.isTerminated());
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}
class NewThread implements Runnable{
    String name;
    NewThread(String name){
        this.name=name;
    }
    @Override
    public void run() {
        System.out.println("Inside Run: "+name);
    }
}
