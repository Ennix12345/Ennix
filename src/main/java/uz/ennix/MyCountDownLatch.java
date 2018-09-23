package uz.ennix;

import java.util.concurrent.CountDownLatch;

public class MyCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Latch(countDownLatch);
        new Latch(countDownLatch);
        new Latch(countDownLatch);

        countDownLatch.await();
        System.out.println("All job is done!");
    }
}
class Latch extends Thread{
    CountDownLatch countDownLatch;

    public Latch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        start();
    }
    @Override
    public void run() {
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done!");
        countDownLatch.countDown();
    }
}