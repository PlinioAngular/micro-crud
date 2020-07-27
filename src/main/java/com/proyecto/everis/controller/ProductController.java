package com.proyecto.everis.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.everis.model.Product;
import com.proyecto.everis.service.IProductService;

import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("products")
public class ProductController {
	
	@Autowired
	private IProductService service;
	
	
	@ApiOperation(
            value = "Agrega producto",
            notes = "El parámetro de de tipo Product.class"
    )
	@PostMapping()
	Mono<Product> create(@Valid @RequestBody Product ProductsStream) {
		return this.service.create(ProductsStream);
	}
	
	@ApiOperation(
            value = "Actualiza producto",
            notes = "El parámetro de de tipo Product.class"
    )
	@PutMapping()
	Mono<Product> update(@Valid @RequestBody Product ProductsStream) {
		return this.service.update(ProductsStream);
	}
	
	@ApiOperation(
            value = "Lista todo producto",
            notes = "No necesita parámetros"
    )
	@GetMapping(produces="application/json")
	Flux<Product> list() {
		return service.listAll();
	}
	
	@ApiOperation(
            value = "Agrega producto",
            notes = "El parámetro es de tipo string"
    )
	@GetMapping("/{id}")
	Mono<ResponseEntity<Product>> findById(@PathVariable String id) {
		return this.service.findId(id).
				map(mapper->ResponseEntity.ok(mapper))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	@ApiOperation(
            value = "Agrega producto",
            notes = "El parámetro es de tipo string"
    )
	@DeleteMapping("/{id}")
	Mono<Void> deleteById(@PathVariable String id) {
		return this.service.delete(id);
	}
	@ApiOperation(
            value = "Elimina todo bancos",
            notes = "Utilizado para pruebas"
    )
	@DeleteMapping
	Mono<Void> deleteAll() {
		return this.service.deleteAll();
	}

}

