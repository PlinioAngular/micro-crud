package com.proyecto.everis.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document( collection ="product" )
public class Product {
	
	@Id
	private String id;
	
	private String nameProduct;
	
	private String typeProduct;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public String getTypeProduct() {
		return typeProduct;
	}

	public void setTypeProduct(String typeProduct) {
		this.typeProduct = typeProduct;
	}

	

}
