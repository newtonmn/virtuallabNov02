package com.ibm.productservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import io.swagger.annotations.ApiOperation;

@RequestMapping("product")
@RestController
public class ProductController {
	
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/")
	@ApiOperation("This will create product entity")
	public ResponseEntity<Product> products(@RequestBody ProductDTO dto) {
		
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(dto));
	}
	
	@ApiOperation("This return the product for given id")
	@GetMapping("/") //localhost:8080/product?id=1
	public ResponseEntity<Product> products(@RequestParam(value="id")Long id) {
		
		Optional<Product> product= productService.getProduct(id);
		
		if(product.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.OK).body(product.get());
		}else {
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		
		
	}
	
	@GetMapping("/{id}") //localhost:8085/product/1
	public Product product(@PathVariable(value="id")Long id) {
		
		return productService.getProduct(id).get();
		
	}

}
