/**
 * 
 */
package com.terzeron.java;
 
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

import java.io.IOException;
 
/**
 * @author terzeron
 *
 */
public class PdfTextExtractor {
	public String getText(String pdfFileName) throws IOException {
		//System.out.println("getText(" + pdfFileName + ")");
		PdfReader reader = null;
		try {
			reader = new PdfReader(pdfFileName);
		} catch (NullPointerException e) {
			System.out.println("\nNullPointerException at " + pdfFileName);
			return pdfFileName;
		}
		PdfReaderContentParser parser = new PdfReaderContentParser(reader);
		TextExtractionStrategy strategy;
		String text = "";
		int start = 1;
		int size = 20;
		int numPages = reader.getNumberOfPages();
		int end = Math.min(start + size - 1, numPages);
		for (int i = start; i <= end; i++) {
			SimpleTextExtractionStrategy st = new SimpleTextExtractionStrategy();
			try {
				strategy = parser.processContent(i, st);
				text += strategy.getResultantText();
			} catch (Exception e) {
				continue;
			} finally {
				st = null;
				strategy = null;
			}
		}
		parser = null;
		reader = null;
		return text;
	}
}
