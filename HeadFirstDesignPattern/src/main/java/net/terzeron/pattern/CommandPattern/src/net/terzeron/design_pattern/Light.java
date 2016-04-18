package net.terzeron.design_pattern;

/**
 * Created by terzeron on 2016. 2. 3..
 */
public class Light {
    String location;

    public Light() {

    }

    public Light(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " Light is on");
    }

    public void off() {
        System.out.println(location + " Light is off");
    }
}
