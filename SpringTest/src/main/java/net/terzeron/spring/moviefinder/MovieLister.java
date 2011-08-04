package net.terzeron.spring.moviefinder;
import java.util.Iterator;
import java.util.List;

/**
 * 
 */

/**
 * @author terzeron
 *
 */
public class MovieLister {
	private MovieFinder finder;
	
	public MovieLister() {
		finder = new ColonDelimitedMovieFinder("movie1.txt");
	}
	
	public Movie[] moviesDirectedBy(String arg) {
		List<Movie> allMovies = finder.findAll();
		for (Iterator<Movie> it = allMovies.iterator(); it.hasNext(); ) {
			Movie movie = it.next();
			if (!movie.getDirector().equals(arg)) 
				it.remove();	
		}
		return (Movie[]) allMovies.toArray(new Movie[allMovies.size()]);
	}
	
	public static void main(String[] args) {
		MovieLister ml = new MovieLister();
		Movie[] mla = ml.moviesDirectedBy("hello");
		for (int i = 0; i < mla.length; i++) {
			System.out.println(mla[i].getName());
		}
	}
}
