package net.terzeron.jdom.node;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.jdom.CDATA;
import org.jdom.Comment;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.EntityRef;
import org.jdom.JDOMException;
import org.jdom.ProcessingInstruction;
import org.jdom.Text;
import org.jdom.input.SAXBuilder;


public class NodeLister {
	public static void main(String[] arags) {
		String urlStr = "http://terzeron.net/index.xml";
		SAXBuilder builder = new SAXBuilder();
		try {
			Document doc = builder.build(urlStr);
			listNodes(doc, 0);
		} catch (JDOMException e) {			
			System.out.println(urlStr + " is not well-formed.");
			System.out.println(e.getMessage());			
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void listNodes(Object o, int depth) {
		printSpaces(depth);
		
		if (o instanceof Element) {
			Element element = (Element) o;
			System.out.println("Element: " + element.getName());
			List<Element> children = (List<Element>) element.getContent();
			Iterator<Element> iterator = (Iterator<Element>) children.iterator();
			while (iterator.hasNext()) {
				Object child = iterator.next();
				listNodes(child, depth + 1);
			}
		} else if (o instanceof Document) {
			System.out.println("Document");
			Document doc = (Document) o;
			List<Element> children = (List<Element>) doc.getContent();
			Iterator<Element> iterator = (Iterator<Element>) children.iterator();
			while (iterator.hasNext()) {
				Object child = iterator.next();
				listNodes(child, depth + 1);
			}
		} else if (o instanceof Comment) {
			System.out.println("Comment");
		} else if (o instanceof CDATA) {
			System.out.println("CDATA: '" + ((Text) o).getText() + "'");
			// CDATA is a subclass of Text so this test must come before the test for Text
		} else if (o instanceof Text) {
			//System.out.println("Text: '" + ((Text) o).getText() + "'");
		} else if (o instanceof EntityRef) {
			System.out.println("Entity reference: " + o);
		} else if (o instanceof ProcessingInstruction) {
			System.out.println("Processing instruction");
		} else {
			System.out.println("Unexpected type: " + o.getClass());
		}
	}

	private static void printSpaces(int depth) {
		for (int i = 0; i < depth; i++) {
			System.out.print(' ');
		}
	}
}
