package uz.ennix;

import java.util.concurrent.Semaphore;

public class MySemaphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);

        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();
        Person person5 = new Person();
        Person person6 = new Person();
        Person person7 = new Person();

        person1.semaphore = semaphore;
        person2.semaphore = semaphore;
        person3.semaphore = semaphore;
        person4.semaphore = semaphore;
        person5.semaphore = semaphore;
        person6.semaphore = semaphore;
        person7.semaphore = semaphore;

        person1.start();
        person2.start();
        person3.start();
        person4.start();
        person5.start();
        person6.start();
        person7.start();
    }
}
class Person extends Thread{
    Semaphore semaphore;

    @Override
    public void run() {
        System.out.println(this.getName() + " Waiting for table");
        try {
            semaphore.acquire();
            System.out.println(this.getName() + " set on the table");
            System.out.println(this.getName() + " release the table");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}