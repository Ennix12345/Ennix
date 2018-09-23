package uz.ennix;

import java.util.concurrent.Exchanger;

public class MyExchanger {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Mike(exchanger);
        new Anketa(exchanger);
    }
    static class Mike extends Thread{
        Exchanger<String> exchanger;

        public Mike(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            start();
        }
        @Override
        public void run() {
            try {
                exchanger.exchange("Hi I am Ann");
                sleep(2000);
                exchanger.exchange("I'm beauty");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class Anketa extends Thread{
        Exchanger<String> exchanger;

        public Anketa(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            start();
        }
        @Override
        public void run() {
            try {
                System.out.println(exchanger.exchange(null));
                System.out.println(exchanger.exchange(null));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
