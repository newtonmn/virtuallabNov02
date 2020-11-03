package com.ibm.productservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.productservice.converter.ProductConverter;
import com.ibm.productservice.dto.ProductDTO;
import com.ibm.productservice.entity.Product;
import com.ibm.productservice.repository.ProductRepository;
import com.ibm.productservice.restclient.TaxClient;

@Service
public class ProductService {
	
	final TaxClient taxClient;
	
	@Autowired
	ProductRepository productRepo;
	
	public ProductService(TaxClient taxClient) {
		this.taxClient=taxClient;
	}
	
	public Product createProduct(ProductDTO dto) {
		
		ProductConverter converter=new ProductConverter();
		
		
		return productRepo.save(converter.convertToEntity(dto));
		
	}
	
	public Optional<Product> getProduct(Long id) {
		
		return productRepo.findById(id);
	}
	
	public void deleteProduct(Long id)throws Exception {
		
		Optional<Product> product=productRepo.findById(id);
		if(product.isPresent()) {		
		productRepo.delete(product.get());
		}else {
			throw new Exception();
		}
		
	}
	
public ProductDTO getProducts(Long id) {
		
		Product product= productRepo.findById(id).get();
		ProductConverter converter=new ProductConverter();
		
		ProductDTO dto=converter.convertToDTO(product);
		
		Double tax=taxClient.tax(dto.getName());
		dto.setTax(tax);
		
		return dto;
	}
	
	
	

}
