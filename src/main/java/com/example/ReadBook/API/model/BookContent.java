package com.example.ReadBook.API.model;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity(name = "Content")
@Table(name = "Content")
public class BookContent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private long id ;
	
	@Column(name = "pageNumber", nullable = false)
	private long pageNumber ;
	
	@Column(name ="text", nullable = false, columnDefinition = "VARCHAR(10000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
	private String text ;
	
	@CreationTimestamp
	@Column(name = "createdAt", nullable = false, updatable = false, insertable = false,
	columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdAt ;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bookId", referencedColumnName = "id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Book bookId;
	
	public BookContent() {
		;
	}

	public BookContent(long pageNumber, String text, Date createdAt, Book bookId) {
		super();
		this.pageNumber = pageNumber;
		this.text = text;
		this.createdAt = createdAt ;
		this.bookId = bookId;
	}
}
