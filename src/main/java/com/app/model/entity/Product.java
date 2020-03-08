package com.app.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Product {

	@Id
	@Column(name = "id_product")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduct;

	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "id_client")
	private Client client;

	@ManyToMany
	@JoinTable(
		name = "product_product",
		joinColumns = @JoinColumn(name = "id_product"),
		inverseJoinColumns = @JoinColumn(name = "id_related_product"))
	private List<Product> relatedProducts;

}
