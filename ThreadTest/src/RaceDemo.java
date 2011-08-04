public class RaceDemo {

  private final static int NUMRUNNERS = 200;

  public static void main(String[] args) {
    SelfishRunner[] runners = new SelfishRunner[NUMRUNNERS];

    for (int i = 0; i < NUMRUNNERS; i++) {
      runners[i] = new SelfishRunner(i);
      runners[i].setPriority(2);
    }
    for (int i = 0; i < NUMRUNNERS; i++)
      runners[i].start();
    
    System.out.println("end");
  }
}

class SelfishRunner extends Thread {

  private int tick = 1;

  private int num;

  public SelfishRunner(int num) {
    this.num = num;
  }

  public void run() {
    while (tick < 40000000) {
      tick++;
      if ((tick % 500000) == 0)
        System.out.println("Thread #" + num + ", tick = " + tick);
    }
  }
}
           
         
  