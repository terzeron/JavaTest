package net.terzeron.design_pattern;

/**
 * Created by terzeron on 2016. 2. 3..
 */
public class LightOnCommand implements Command {
    Light light; // 리시버

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }
}
