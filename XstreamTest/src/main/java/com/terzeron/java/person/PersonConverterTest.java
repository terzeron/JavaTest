package com.terzeron.java.person;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class PersonConverterTest {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Guilherme");

        XStream xstream = new XStream(new DomDriver());
        xstream.registerConverter(new PersonConverter()); // name --> fullname
        xstream.alias("person", Person.class);
        System.out.println(xstream.toXML(person));
    }
}
