package uz.ennix;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();
    static int account = 0;

    public static void main(String[] args) {
        new MyThread2().start();
        new MyThread1().start();
    }

    static class MyThread1 extends Thread {
        @Override
        public void run() {
            lock.lock();
            account += 10;
            condition.signal();
            lock.unlock();
        }
    }

    static class MyThread2 extends Thread {
        @Override
        public void run() {
            if(account<10){
                try {
                    lock.lock();
                    System.out.println("account 1 - " + account);
                    condition.await();
                    System.out.println("account 2 - " + account);
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            account -= 10;
            System.out.println("at the end " + account);

        }
    }
}