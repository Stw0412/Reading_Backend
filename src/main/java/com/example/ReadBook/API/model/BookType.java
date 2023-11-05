package com.example.ReadBook.API.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity(name = "Type")
@Table(
		name = "Type",
		uniqueConstraints = {
			@UniqueConstraint(
				name = "nameType_unique", columnNames = "nameType")}
		)
public class BookType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private long id ;
	
	@Column(name = "nameType", nullable = false, unique = true, columnDefinition = "VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
	private String nameType ;
	
	public BookType() {
		;
	}

	public BookType(String nameType) {
		super();
		this.nameType = nameType;
	}
}
