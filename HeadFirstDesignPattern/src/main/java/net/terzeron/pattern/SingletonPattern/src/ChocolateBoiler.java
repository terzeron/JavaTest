/**
 * Created by terzeron on 2016. 1. 11..
 */
public class ChocolateBoiler {
    private boolean empty;
    private boolean boiled;

    private static ChocolateBoiler chocolateBoiler;
    private ChocolateBoiler() {
        empty = true;
        boiled = false;
    }

    public static synchronized ChocolateBoiler getInstance() {
        if (chocolateBoiler == null) {
            chocolateBoiler = new ChocolateBoiler();
        }
        return chocolateBoiler;
    }

    public synchronized void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
        }
        System.out.println("filling");
    }

    public synchronized void drain() {
        if (!isEmpty() && isBoiled()) {
            empty = true;
        }
        System.out.println("draining");
    }

    public synchronized void boil() {
        if (!isEmpty() && !isBoiled()) {
            boiled = true;
        }
        System.out.println("boiling");
    }

    public synchronized boolean isEmpty() {
        return empty;
    }

    public synchronized boolean isBoiled() {
        return boiled;
    }

    public static void main(String[] args) {
        ChocolateBoiler chocolateBoiler = ChocolateBoiler.getInstance();
        chocolateBoiler.fill();
        chocolateBoiler.boil();
        chocolateBoiler.drain();
    }
}

