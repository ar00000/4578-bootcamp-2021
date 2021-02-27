import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


class ThreadClass implements Runnable
{
    private int id;
    public ThreadClass(int id)
    {
        this.id=id;
    }
    public void run()
    {
        System.out.println("\nRunning Thread: "+id);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed Thread: "+id);
    }
}
public class Multithreading9 {
    public static void main(String[] args) {
        //Increase concurrency with Thread pools using newCachedThreadPool() and newFixedThreadPool().
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        for(int i=0;i<3;i++)
        {
            fixedThreadPool.submit(new ThreadClass(i));
        }
        for(int i=4;i<8;i++)
        {
            cachedThreadPool.submit(new ThreadClass(i));
        }
        fixedThreadPool.shutdown();
        cachedThreadPool.shutdown();

        try {
            fixedThreadPool.awaitTermination(1, TimeUnit.MINUTES);
            cachedThreadPool.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}