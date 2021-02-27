/*New Thread is created using Runnable Interface*/
class RunnableThread implements Runnable{
    Thread t;
    RunnableThread(){
        t=new Thread(this,"Implemented Thread");
        System.out.println(this);
        t.start();
    }
    @Override
    public void run() {
        System.out.println("Inside Implemented Thread");
    }
}

/*New Thread is created using Thread Class*/
class ExtendedThread extends Thread{
    ExtendedThread(){
        super("Extended Thread");
        System.out.println(this);
        start();
    }
    @Override
    public void run() {
        System.out.println("Inside Extended Thread");
    }
}

/*Main thread*/
public class Multithreading1 {
    public static void main(String[] args){
        new RunnableThread();
        new ExtendedThread();
        System.out.println("Inside Parent Class");
    }
}