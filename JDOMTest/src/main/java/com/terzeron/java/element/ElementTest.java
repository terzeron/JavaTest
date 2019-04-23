package com.terzeron.java.element;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

public class ElementTest {
	public static void main(String[] args) {
		Document doc = new Document();
		Element e = new Element("root");
		e.setText("This is the root");
		doc.addContent(e);
		
		XMLOutputter outp = new XMLOutputter();
		try {
			outp.output(doc, System.out);
		} catch (Exception ex) {
			System.out.print(ex);
		}
	}
}
