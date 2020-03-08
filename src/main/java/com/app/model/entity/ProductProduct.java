package com.app.model.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class ProductProduct {

	@EmbeddedId
	private ProductProductPK id;

}