package com.app.api;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class ProductDto implements Serializable {

	private static final long serialVersionUID = -854087951612427929L;

	private Integer idProduct;

	private String name;

	private ClientDto client;

	private List<ProductDto> relatedProducts;

}
