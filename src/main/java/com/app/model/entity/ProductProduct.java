package com.app.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class ProductProduct {

	@Id
	@Column(name = "id_product")
	private Long idProduct;

	@Id
	@Column(name = "id_related_product")
	private Long idRelatedProduct;

}
