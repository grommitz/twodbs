package com.grommitz.twodbs;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class BookCollection {

	private Author author;

	private List<Book> books;

	public BookCollection(Author author, List<Book> books) {
		this.author = author;
		this.books = books;
	}

	public Author getAuthor() {
		return author;
	}

	public List<Book> getBooks() {
		return books;
	}
}
