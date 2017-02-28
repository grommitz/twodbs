package com.grommitz.twodbs;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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

	public Author getAuthorById(long authorId) {
		TypedQuery<Author> query = em.createQuery("SELECT au FROM Author au WHERE au.id = :id", Author.class);
		return query.setParameter("id", authorId).getSingleResult();
	}

}
