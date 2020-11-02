package com.ibm.productservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.productservice.converter.ProductConverter;
import com.ibm.productservice.dto.ProductDTO;
import com.ibm.productservice.entity.Product;
import com.ibm.productservice.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepo;
	
	public Product createProduct(ProductDTO dto) {
		
		ProductConverter converter=new ProductConverter();
		
		
		return productRepo.save(converter.convertToEntity(dto));
		
	}
	
	public Optional<Product> getProduct(Long id) {
		
		return productRepo.findById(id);
	}
	
	

}
