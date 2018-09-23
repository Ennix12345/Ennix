package uz.ennix;

import java.util.concurrent.*;

public class MyFuture {
    public static void main(String[] args){
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.schedule(new Running1(), 1, TimeUnit.SECONDS);
        executor.schedule(new Running2(), 2, TimeUnit.SECONDS);
        executor.shutdown();
    }
    static class Running1 implements Runnable{
        @Override
        public void run() {
            System.out.println(1);
        }
    }
    static class Running2 implements Runnable{
        @Override
        public void run() {
            System.out.println(2);
        }
    }

}