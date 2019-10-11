package net.terzeron.xstream.blog;

import java.util.List;
import java.util.ArrayList;

public class Blog {
	private Author writer;
	private List<Entry> entries;
	
	public Blog(Author writer) {
		this.writer = writer;
		this.entries = new ArrayList<Entry>();
	}
	
	public void add(Entry entry) {
		entries.add(entry);
	}
	
	public List<Entry> getContent() {
		return entries;
	}
}
