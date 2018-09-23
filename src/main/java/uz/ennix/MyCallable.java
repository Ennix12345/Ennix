package uz.ennix;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer>callable = new Calls();
        FutureTask<Integer> future = new FutureTask<>(callable);
        new Thread(future).start();
        System.out.println(future.get());

    }
    static class Calls implements Callable<Integer>{
        @Override
        public Integer call() throws Exception {

            int j = 0;
            int k = 0;
            for (int i = 0; i < 10; i++, j++, k++) {
                Thread.sleep(100);
            }
            return j;
        }
    }
}
