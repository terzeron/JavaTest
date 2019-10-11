package net.terzeron.xstream.date;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class TestDriver {
	public static void main(String[] args) {
		Calendar calendar = new GregorianCalendar();
		
		XStream xstream = new XStream(new DomDriver());
		//xstream.registerConverter(new DateConverter(new Locale("ko", "kr")));
		xstream.registerConverter(new DateConverter(new Locale("pt", "br")));
		System.out.println(xstream.toXML(calendar));
	}
}
