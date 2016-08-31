package net.terzeron.test.generic;

/**
 * Created by terzeron on 2016. 8. 23..
 */
public class GenericTest {
    <T extends Number> GenericTest(T value) {
        if (value instanceof Integer) {
            System.out.println("Integer value: " + value);
        }
        if (value instanceof Float) {
            System.out.println("Float value: " + value);
        }
        if (value instanceof Double) {
            System.out.println("Double value: " + value);
        }
        if (value instanceof Long) {
            System.out.println("Long value: " + value);
        }
    }

    public static void main(String[] args) {
        GenericTest genericTest = new GenericTest(12);
        genericTest = new GenericTest(12.0F);
        genericTest = new GenericTest(12.0);
        genericTest = new GenericTest(12L);
    }
}
