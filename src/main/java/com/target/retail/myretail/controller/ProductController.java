package com.target.retail.myretail.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.target.retail.myretail.domain.Product;
import com.target.retail.myretail.domain.ProductRepository;

@RestController("/")
public class ProductController {
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	private ProductRepository productRepository;
	@Autowired
	public ProductController(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@GetMapping("/products")
	public List<Product> getProducts(){
		LOG.info("Getting the list of all products");
		return productRepository.findAll();
	}
	
	@GetMapping("/products/{id}")
	public Optional<Product> getProductById(@PathVariable long id){
		LOG.info("Getting product information with ID: {}.", id);
		return productRepository.findById(id);
	}
	
	@PostMapping("/products")
	public void createProduct(@RequestBody Product product ) {
		LOG.info("Saving Product information.");
		productRepository.save(product);
	}
	
	 @PutMapping("/products/{id}") 
	 public Product updateProduct(@RequestBody Product newproduct, @PathVariable Long id){
		 LOG.info("Updating Product price information with ID: {}.", id);
		 return productRepository.findById(id)
			      .map(product -> {
			    	product.setPrice(newproduct.getPrice());
			        return productRepository.save(product);
			      }).orElseGet(() -> {
			    	  newproduct.setId(id);
				        return productRepository.save(newproduct);
				  });
	 }
	 
	 
}
