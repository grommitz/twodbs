package com.grommitz.twodbs;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

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
	@Path("by")
	public List<Author> getAuthors() {
		return db1Dao.getAllAuthors();
	}

}
