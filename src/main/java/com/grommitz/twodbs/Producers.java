package com.grommitz.twodbs;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by martin on 27/02/17.
 */
@ApplicationScoped
public class Producers {

	@PersistenceContext(unitName = "PU1")
	@Produces
	@Db1
	EntityManager em1;

	@PersistenceContext(unitName = "PU2")
	@Produces
	@Db2
	EntityManager em2;

}
