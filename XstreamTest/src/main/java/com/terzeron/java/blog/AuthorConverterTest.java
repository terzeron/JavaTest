package com.terzeron.java.blog;

import com.thoughtworks.xstream.XStream;

public class AuthorConverterTest {
	public static void main(String[] args) {
        Blog teamBlog = new Blog(new Author("Guilherme Silveira"));
        teamBlog.add(new Entry("first","My first blog entry."));
        teamBlog.add(new Entry("tutorial",
                "Today we have developed a nice alias tutorial. Tell your friends! NOW!"));

        XStream xstream = new XStream();
        //xstream.alias("blog", Blog.class);
        xstream.alias("entry", Entry.class);

        xstream.addImplicitCollection(Blog.class, "entries");

        xstream.useAttributeFor(Blog.class, "writer");
        xstream.aliasField("author", Blog.class, "writer");
        xstream.registerConverter(new AuthorConverter());
        
        xstream.aliasPackage("my.company", "net.terzeron");

        System.out.println(xstream.toXML(teamBlog));
	}
}
