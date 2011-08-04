package net.terzeron.jdom.list;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;


public class ElementLister {
	public static void main(String[] args) {
		String urlStr = "http://terzeron.net/index.xml"; 
		SAXBuilder builder = new SAXBuilder();
		try {
			Document doc = builder.build(urlStr);
			Element root = doc.getRootElement();
			listChildren(root, 0);
		} catch (JDOMException e) {
			System.out.println(urlStr + " is not well-formed.");
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static void listChildren(Element current, int depth) {
		printSpaces(depth);
		System.out.println(current.getName()); // getName()
		@SuppressWarnings("unchecked")
		List<Element> children = current.getChildren(); // getChildren()
		Iterator<Element> iterator = (Iterator<Element>) children.iterator(); // iterator()
		while (iterator.hasNext()) {
			Element child = (Element) iterator.next();
			listChildren(child, depth + 1);
		}
	}
	
	public static void printSpaces(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(' ');
		}
	}
}