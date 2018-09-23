package uz.ennix;
import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class MyBlocking {
    static long l = 10_000_000_000L;
    static int nums = Runtime.getRuntime().availableProcessors();
    public static void main(String[] args) throws InterruptedException {
        System.out.println(TimeUnit.DAYS.toHours(20));
        System.out.println(new Date());
        ForkJoinPool pool = new ForkJoinPool(nums);
        System.out.println(pool.invoke(new MyFork(0, l)));
        System.out.println(new Date());
    }
    static class MyFork extends RecursiveTask<Long>{
        long from, to;

        public MyFork(long from, long to) {
            this.from = from;
            this.to = to;
        }
        @Override
        protected Long compute() {
            if((to-from)<=l/nums){
                long j = 0;
                for (long i = from; i < to; i++) {
                    j+=i;
                }
                return j;
            }else{
                long middle = (to+from)/2;
                MyFork forkFirst = new MyFork(from, middle);
                forkFirst.fork();
                MyFork forkSecond = new MyFork(middle, to);
                long value = forkSecond.compute();
                return forkFirst.join() + value;
            }
        }
    }
}
