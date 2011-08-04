package net.terzeron.test.thread5;

public class TwoThreadAlive extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            printMsg();
        }
    }

    public void printMsg() {
        Thread t = Thread.currentThread();
        String name = t.getName();
        System.out.println("name=" + name);
    }

    public static void main(String [] args) {
        TwoThreadAlive tt = new TwoThreadAlive();
        tt.setName("my worker thread");
        
        System.out.println("before start(), tt.isAlive()=" + 
                           tt.isAlive());
        tt.start();
        System.out.println("after start(), tt.isAlive()=" + 
                           tt.isAlive());

        for (int i = 0; i < 10; i++) {
            tt.printMsg();
        }

        System.out.println("at the end of main(), tt.isAlive()=" + 
                           tt.isAlive());
    }
}        
                     
