package com.app.api;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class ClientDto implements Serializable {

	private static final long serialVersionUID = -6205340697435972698L;

	private String idClient;

	private String name;

	private List<ProductDto> products;

}
