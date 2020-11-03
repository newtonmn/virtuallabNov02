package com.ibm.taxservice.entity;



//@Entity
//@Table(name="tax")
public class Tax {
	
	//@Id
	//@GeneratedValue
	private Long id;
	
	//@Column(name="name")
	private String name;
	
	//@Column(name="taxes")
	private Double taxes;

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

	public Double getTaxes() {
		return taxes;
	}

	public void setTaxes(Double taxes) {
		this.taxes = taxes;
	}

	

}
