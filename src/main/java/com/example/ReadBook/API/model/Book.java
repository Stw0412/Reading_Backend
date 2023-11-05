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
@Entity(name = "Book")
@Table(name = "Book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private long id ;
	
	@Column(name = "nameBook", nullable = false, columnDefinition = "VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
	private String nameBook ;
	
	@Column(name = "author", nullable = false, columnDefinition = "VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
	private String author ;
	
	@Column(name = "description", nullable = false, columnDefinition = "VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
	private String description ;
	
	@CreationTimestamp
	@Column(name = "createdAt", nullable = false, updatable = false, insertable = false,
	columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdAt ;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "typeId", referencedColumnName = "id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private BookType typeId ;
	
	public Book() {
		;
	}

	public Book(String nameBook, String author, String description, Date createdAt, BookType typeId) {
		super();
		this.nameBook = nameBook;
		this.author = author;
		this.description = description;
		this.createdAt = createdAt;
		this.typeId = typeId ;
	}
	
}
