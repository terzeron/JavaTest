package net.terzeron.xstream.birthday;

import java.util.Calendar;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class BirthdayConverter {
	public boolean canConvert(Class clazz) {
		return Birthday.class == clazz;
	}
	
	public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
		Birthday birthday = (Birthday) value;
	}
	
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		Birthday birthday = new Birthday();
		String gender = reader.getAttribute("gender");
		if (gender != null) {
			if (gender.length() > 0) {
				if (gender.charAt(0) == 'f') {
					birthday.setGenderFemale();
				} else if (gender.charAt(0) == 'm') {
					birthday.setGenderMale();
				} else {
					throw new ConversionException("Invalid gender value: " + gender);
				}
			} else {
				throw new ConversionException("Empty string is invalid gender value");
			}
		}
		while (reader.hasMoreChildren()) {
			reader.moveDown();
			if ("person".equals(reader.getNodeName())) {
				Person person = (Person) context.convertAnother(birthday, Person.class);
				birthday.setPerson(person);
			} else if ("birthday".equals(reader.getNodeName())) {
				Calendar date = (Calendar) context.convertAnother(birthday, Calendar.class);
				birthday.setDate(date);
			}
			reader.moveUp();
		}
		return birthday;
	}
}
