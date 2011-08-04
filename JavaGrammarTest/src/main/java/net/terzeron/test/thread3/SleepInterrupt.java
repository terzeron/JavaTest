package net.terzeron.test.thread3;

public class SleepInterrupt extends Object implements Runnable {
    public void run() {
        try {
            System.out.println("in run() - about to sleep for 20 seconds");
            Thread.sleep(20000);
            System.out.println("in run() - woke up");
        } catch (InterruptedException x) {
            System.out.println("in run() - interrupted while sleeping");
            return;
        }

        System.out.println("in run() - doing stuff after nap");
        System.out.println("in run() - leaving normally");
    }
    
    public static void main(String [] args) {
        SleepInterrupt si = new SleepInterrupt();
        Thread t = new Thread(si);
        t.start();
        
        try {
            Thread.sleep(5000); 
        } catch (InterruptedException x) {
        }

        System.out.println("in main() - interrupting other thread");
        t.interrupt();
        System.out.println("in main() - leaving");
    }
}
