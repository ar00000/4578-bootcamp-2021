class Multithreading2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1=new Thread(new ImplementedThread(),"Implemented thread");
        ExtendedThread2 thread2=new ExtendedThread2("Extended Thread");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Main Exiting");
    }
}
class ImplementedThread implements Runnable{

    @Override
    public void run() {
        System.out.println("Inside Implemented Thread: before sleeping");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Inside Implemented Thread: after sleep");
    }
}
class ExtendedThread2 extends Thread{

    ExtendedThread2(String threadName){
        super(threadName);
    }
    public void run(){
        System.out.println("Inside Extended Thread: before sleep");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Inside Extended Thread: after sleep");
    }
}