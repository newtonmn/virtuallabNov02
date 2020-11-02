package com.ibm.productservice.converter;

import com.ibm.productservice.dto.ProductDTO;
import com.ibm.productservice.entity.Product;

public class ProductConverter {
	
	
	public Product convertToEntity(ProductDTO dto) {
		
		Product product=new Product();
		
		product.setProductName(dto.getName());
		product.setQuantity(dto.getQuantity());
		
		return product;
	}

}
