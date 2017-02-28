package com.grommitz.twodbs;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by martin on 27/02/17.
 */
@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private long authorId;

	private String title;

	public Book() {}

	public Book(String title, long authorId) {
		this.title = title;
		this.authorId = authorId;
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}
}
