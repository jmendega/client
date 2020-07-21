package com.springboot.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.models.Product;
import com.springboot.services.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class ClientController {

	@Autowired
	ProductService productService;

	@GetMapping("/products")
	public List<Product> getProducts() throws IOException {
		log.info("getProducts()");
		return productService.getProducts();
	}

	@PostMapping("/createProduct")
	public Product createProduct(@RequestBody Product product) throws IOException {
		log.info("createProduct -> {} ", product);
		return productService.createProduct(product);
	}

	@RequestMapping(value = "/updateProduct/{id}", method = RequestMethod.PUT)
	public Product updateProduct(@PathVariable String id, @RequestBody Product product) throws Exception {
		log.info("updateProduct -> {} -> {}", id, product);
		productService.UpdateProduct(id, product);
		return product;
	}
	
	@RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.DELETE)
	public Product deleteProduct(@PathVariable String id) throws Exception {
		log.info("deleteProduct -> {}", id);
		return productService.deleteProduct(id);
		 
	}

}
