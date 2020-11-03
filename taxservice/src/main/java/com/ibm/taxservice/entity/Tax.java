package com.ibm.taxservice.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tax")
public class Tax {
	
	private Long id;
	
	private String name;
	
	private Double tax;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

}
