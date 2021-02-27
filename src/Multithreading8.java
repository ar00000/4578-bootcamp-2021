import java.util.Timer;
import java.util.concurrent.*;

public class Multithreading8 {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executorService= Executors.newScheduledThreadPool(2);
        long startTime=System.currentTimeMillis();
        ScheduledFuture scheduledFuture=executorService.schedule(new Callable() {
            @Override
            public Object call() throws Exception {
                long executionTime=(System.currentTimeMillis()-startTime)/1000;
                System.out.println("Returning in scheduler: "+executionTime+"sec");
                return null;
            }
        },5,TimeUnit.SECONDS);
        ScheduledFuture scheduledFuture1=executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                long executionTime=(System.currentTimeMillis()-startTime)/1000;
                System.out.println("Inside scheduleAtFixedRate: "+executionTime+"sec");
            }
        },1,2,TimeUnit.SECONDS);
        ScheduledFuture scheduledFuture2= executorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                long executionTime=(System.currentTimeMillis()-startTime)/1000;
                System.out.println("Inside scheduleWithFixedDelay: "+executionTime+"sec");
            }
        },1,3,TimeUnit.SECONDS);
        Thread.sleep(10000);
        executorService.shutdown();
        executorService.awaitTermination(1,TimeUnit.DAYS);
    }
}
