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
@Entity(name = "Customer")
@Table(
		name = "Customer",
		uniqueConstraints = {
				@UniqueConstraint(
						name = "userName_unique", columnNames = "userName")}
		)
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id ;
	
	@Column(name = "fristName", nullable = false, columnDefinition = "VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
	private String fristName ;
	
	@Column(name = "lastName", nullable = false, columnDefinition = "VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
	private String lastName ;
	
	@Column(name = "userName", nullable = false, unique = true)
	private String userName ;
	
	@Column(name = "password", nullable = false)
	private String password ;
	
	public Customer() {
		;
	}

	public Customer(String fristName, String lastName, String userName, String password) {
		super();
		this.fristName = fristName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}
}
