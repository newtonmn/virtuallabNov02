package com.ibm.taxservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.taxservice.service.TaxService;

@RestController
public class TaxController {
	
	@Autowired
	TaxService taxService;
	
	
	@GetMapping("/tax/{name}")
	public Double tax(@PathVariable(value="name") String name) {
		
	return taxService.tax(name);
	}

}
