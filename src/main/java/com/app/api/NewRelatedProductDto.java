package com.app.api;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class NewRelatedProductDto implements Serializable {

	private static final long serialVersionUID = 3490741945365504223L;

	@NotNull
	private Integer idProduct;

	@NotNull
	private Integer idRelatedProduct;

}
