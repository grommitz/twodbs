package com.grommitz.twodbs;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by martin on 27/02/17.
 */
@RequestScoped
public class Db2Dao {

	private EntityManager em;

	public Db2Dao() {}

	@Inject
	public Db2Dao(@Db2 EntityManager em) {
		this.em = em;
	}

	public Book save(Book book) {
		em.persist(book);
		return book;
	}

	public List<Book> getAllBooks() {
		return em.createQuery("SELECT bk FROM Book bk").getResultList();
	}

}
