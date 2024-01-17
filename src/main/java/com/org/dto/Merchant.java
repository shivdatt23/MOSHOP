package com.org.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Merchant {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String password;
	private long mobile;
	private String shopName;
	private String address;
	private String status="active";
	
	@ManyToOne
	@JoinColumn
	private Admin admin;
	
	@OneToMany(mappedBy = "merchant",cascade=CascadeType.ALL)
	private List<Product> product;
}
