package com.ibm.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.productservice.dto.ProductDTO;
import com.ibm.productservice.entity.Product;
import com.ibm.productservice.service.ProductService;

@RequestMapping("product")
@RestController
public class ProductController {
	
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/")
	public Product products(@RequestBody ProductDTO dto) {
		
		return productService.createProduct(dto);
	}
	
	@GetMapping("/") //localhost:8080/product?id=1
	public Product products(@RequestParam(value="id")Long id) {
		
		return productService.getProduct(id).get();
		
	}
	
	@GetMapping("/{id}") //localhost:8085/product/1
	public Product product(@PathVariable(value="id")Long id) {
		
		return productService.getProduct(id).get();
		
	}

}
