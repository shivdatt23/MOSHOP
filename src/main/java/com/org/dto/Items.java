package com.org.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Items {

	@Id
	private int id;
	
	private String name;
	private double price;
	private String category;
	private int stockLeft;
	
	
	@ManyToOne
	@JoinColumn
	private Cart cart;
	
}
