package com.app.api;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class NewProductDto implements Serializable {

	private static final long serialVersionUID = -5937379416260040108L;

	@NotBlank
	@Size(max = 255)
	private String name;

	@Size(min = 12, max = 12)
	private String idClient;

}
