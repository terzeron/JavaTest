package net.terzeron.spring.moviefinder;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Vector;

/**
 * 
 */

/**
 * @author terzeron
 *
 */
public class ColonDelimitedMovieFinder implements MovieFinder {
	private String fileName;
	private Vector<Movie> v;
	
	public ColonDelimitedMovieFinder(String fileName) {
		this.fileName = fileName;
		this.v = new Vector<Movie>();
		
		StringBuffer sb = new StringBuffer();
		try {
			FileInputStream fis = new FileInputStream(this.fileName);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			Reader in = new BufferedReader(isr);
			int ch;
			String key = "";
			String value = "";
			while ((ch = in.read()) > -1) {
				if (ch == ':') {
					key = sb.toString();
					sb.delete(0, sb.length());
					value = "";
				} else if (ch == '\n') {
					value = sb.toString();
					sb.delete(0, sb.length());
					Movie m = new Movie();
					System.out.println(key + " " + value);
					m.setDirector(key);
					m.setName(value);
					v.add(m);
					key = "";
				} else {
					sb.append((char) ch);
				}
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see MovieFinder#findAll()
	 */
	public List<Movie> findAll() {
 		return (List<Movie>) v;
	} 
	
}
