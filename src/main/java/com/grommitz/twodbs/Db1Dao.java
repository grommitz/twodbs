package com.grommitz.twodbs;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by martin on 27/02/17.
 */
@RequestScoped
public class Db1Dao {

	private EntityManager em;

	public Db1Dao() {}

	@Inject
	public Db1Dao(@Db1 EntityManager em) {
		this.em = em;
	}

	public Author save(Author author) {
		em.persist(author);
		return author;
	}

	public List<Author> getAllAuthors() {
		return em.createQuery("SELECT au FROM Author au").getResultList();
	}

}
