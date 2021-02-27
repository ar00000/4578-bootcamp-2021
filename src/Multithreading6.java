import java.util.concurrent.*;

public class Multithreading6 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        Future future1=executorService.submit(new FutureThread("A"));
        Future future2=executorService.submit(new FutureThread("B"));
        Future future3=executorService.submit(new FutureThread("C"));
        //executorService.shutdownNow();
        System.out.println("Future2 isDone: "+future2.isDone());
        System.out.println("Future2 returns: "+future2.get());
        System.out.println("Future2 isDone: "+future2.isDone());
        System.out.println("Future3 isCancelled: "+future3.isCancelled());
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);

    }
}
class FutureThread implements Callable{
    String name;
    FutureThread(String name){
        this.name=name;
    }

    @Override
    public Object call() throws Exception {
        for(int i=0;i<5;i++)
            System.out.println(name+" : "+i);
        return "returned from "+name;
    }
}