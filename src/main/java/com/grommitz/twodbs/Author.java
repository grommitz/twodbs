package com.grommitz.twodbs;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by martin on 27/02/17.
 */
@Entity
public class Author {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	public Author() {}

	public Author(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
