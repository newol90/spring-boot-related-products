package com.app.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class ProductProductPK implements Serializable {

	private static final long serialVersionUID = 4280242554326827975L;

	@Column(name = "id_product")
	private Integer idProduct;

	@Column(name = "id_related_product")
	private Integer idRelatedProduct;

}