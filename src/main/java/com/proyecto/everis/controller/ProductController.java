package com.proyecto.everis.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.everis.model.Product;
import com.proyecto.everis.model.Product;
import com.proyecto.everis.repository.ProductRepository;
import com.proyecto.everis.repository.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("Products")
public class ProductController {
	
	private final ProductRepository productRepository;

	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@PostMapping()
	Mono<Product> create(@Valid @RequestBody Product ProductsStream) {
		return this.productRepository.save(ProductsStream);
	}
	
	@PutMapping()
	Mono<Product> update(@Valid @RequestBody Product ProductsStream) {
		return this.productRepository.save(ProductsStream);
	}

	@GetMapping(produces="application/json")
	Flux<Product> list() {
		return productRepository.findAll();
	}

	@GetMapping("/{id}")
	Mono<Product> findById(@PathVariable String id) {
		return this.productRepository.findById(id);
	}
	
	@DeleteMapping("/{id}")
	Mono<Void> deleteById(@PathVariable String id) {
		return this.productRepository.deleteById(id);
	}

}

