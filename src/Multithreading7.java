import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Multithreading7 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        List<Task> taskList=new ArrayList<>();
        for(int i=0;i<5;i++){
            Task task=new Task("Task"+i);
            taskList.add(task);
        }
        List taskResult=null;
        try {
            taskResult = executorService.invokeAll(taskList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
        taskResult.stream().forEach(System.out::println);
    }
}
class Task implements Callable<Object>{
    String name;
    Task(String name){
        this.name=name;
    }
    public Object call(){
        System.out.println(name);
        return "returning: "+name;
    }
}
