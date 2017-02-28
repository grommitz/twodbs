package com.grommitz.twodbs;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by martin on 27/02/17.
 */
@Path("books")
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class BooksApi {

	@Inject
	Db1Dao db1Dao;

	@Inject
	Db2Dao db2Dao;

	@GET
	public List<Book> getBooks() {
		return db2Dao.getAllBooks();
	}

	@GET
	@Path("/by/{authorId}")
	public List<Book> getBooksBy(@PathParam("authorId") long authorId) {
		return db2Dao.getAllBooks().stream()
				.filter(book -> book.getAuthorId() == authorId)
				.collect(Collectors.toList());
	}

	@GET
	@Path("/list/{authorId}")
	public BookCollection getBookCollection(@PathParam("authorId") long authorId) {
		List<Book> books = getBooksBy(authorId);
		Author author = db1Dao.getAuthorById(authorId);
		return new BookCollection(author, books);
	}

}
