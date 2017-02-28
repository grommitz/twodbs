package com.grommitz.twodbs;

/**
 * Created by martin on 27/02/17.
 */
public class Service {

	private Db1Dao db1Dao;
	private Db2Dao db2Dao;

	public Service(Db1Dao db1Dao, Db2Dao db2Dao) {
		this.db1Dao = db1Dao;
		this.db2Dao = db2Dao;
	}

	public void save(Author author, Book book) {

		author = db1Dao.save(author);
		book.setAuthorId(author.getId());
		book = db2Dao.save(book);

	}


}
