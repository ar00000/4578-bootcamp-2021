import java.util.List;
import java.util.concurrent.*;

/*Use of shutdownNow*/
public class Multithreading4 {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        executorService.submit(new MyThread("A"));
        executorService.submit(new MyThread("B"));
        executorService.submit(new MyThread("C"));
        executorService.submit(new MyThread("D"));
        System.out.println("All Task Submitted");
        List<Runnable> list=executorService.shutdownNow();
        executorService.awaitTermination(1, TimeUnit.DAYS);
        System.out.println("These Task completed");
        list.stream().forEach(Helper::print);
        System.out.println("These task not completed");
    }
}
class MyThread implements Runnable{
    String name;
    MyThread(String name){
        this.name=name;
    }
    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println(name+": "+i);
        }
    }
}
class Helper{
    public static void print(Runnable runnable) {
        try {
            runnable.run();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}