package com.terzeron.java.birthday;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.util.Calendar;

public class BirthdayConverterTest {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Mike");

        Birthday birthday = new Birthday();
        birthday.setPerson(person);
        birthday.setGenderMale();
        birthday.setDate(Calendar.getInstance());

        XStream xstream = new XStream(new DomDriver());
        xstream.registerConverter(new BirthdayConverter());
        System.out.println(xstream.toXML(birthday));
    }
}
