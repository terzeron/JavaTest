package net.terzeron.javatest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by terzeron on 15. 10. 5..
 */
public class Foo {
    String name;
    List<Bar> bars = new ArrayList<>();

    Foo(String name) {
        this.name = name;
    }
    public String toString() { return name; }
}
