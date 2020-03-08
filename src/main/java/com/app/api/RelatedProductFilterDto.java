package com.app.api;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class RelatedProductFilterDto implements Serializable {

	private static final long serialVersionUID = 7615362767062833560L;

	@NotBlank
	private String productName;

	@NotBlank
	private String idClient;

}
