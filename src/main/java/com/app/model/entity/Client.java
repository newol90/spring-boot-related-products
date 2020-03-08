package com.app.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Client {

	@Id
	@Column(name = "id_client")
	private String idClient;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "client")
	private List<Product> products;
}
