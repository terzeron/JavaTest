package net.terzeron.jdom.saxbuilder;
import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

public class SAXBuilderTest {
	public static void main(String[] args) {
		SAXBuilder builder = new SAXBuilder();
		try {
			Document doc = builder.build("http://terzeron.net/index.xml");
			XMLOutputter outp = new XMLOutputter();
			outp.output(doc, System.out);
		} catch (Exception ex) {
			System.out.print(ex);
		}
	}
}
