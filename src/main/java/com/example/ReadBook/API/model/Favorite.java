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
@Entity(name = "Favorite")
@Table(name = "Favorite")
public class Favorite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private long id ;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerId", referencedColumnName = "id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Customer customerId ;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bookId", referencedColumnName = "id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Book bookId ;
	
	@CreationTimestamp
	@Column(name = "createdAt", nullable = false, updatable = false, insertable = false,
	columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdAt ;
	
	public Favorite() {
		;
	}

	public Favorite(Customer customerId, Book bookId, Date createdAt) {
		super();
		this.customerId = customerId;
		this.bookId = bookId;
		this.createdAt = createdAt;
	}
	
	
}
