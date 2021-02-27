import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Multithreading3 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        executorService.submit(new SingleThread());
        executorService.shutdown();
        System.out.println("All Task Submitted");
        executorService.awaitTermination(1, TimeUnit.DAYS);
        System.out.println("All Task completed");
    }
}
class SingleThread implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println(i);
        }
    }
}
