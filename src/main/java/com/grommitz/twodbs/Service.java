package com.grommitz.twodbs;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * Created by martin on 27/02/17.
 */
@Startup
@Singleton
public class Service {

	private Db1Dao db1Dao;
	private Db2Dao db2Dao;

	public Service() {}

	@Inject
	public Service(Db1Dao db1Dao, Db2Dao db2Dao) {
		this.db1Dao = db1Dao;
		this.db2Dao = db2Dao;
	}

	@PostConstruct
	public void insertData() {
		Author anne = db1Dao.save(new Author("Anne"));
		Author bob = db1Dao.save(new Author("Bob"));
		Author chris = db1Dao.save(new Author("Chris"));
		Author doris = db1Dao.save(new Author("Doris"));

		db2Dao.save(new Book("Anne's book", anne.getId()));
		db2Dao.save(new Book("Bob's book", bob.getId()));
		db2Dao.save(new Book("Chris's book", chris.getId()));
		db2Dao.save(new Book("Doris's book", doris.getId()));
		db2Dao.save(new Book("Doris's Other book", doris.getId()));

	}

	public void save(Author author, Book book) {

		author = db1Dao.save(author);
		book.setAuthorId(author.getId());
		book = db2Dao.save(book);

	}


}
