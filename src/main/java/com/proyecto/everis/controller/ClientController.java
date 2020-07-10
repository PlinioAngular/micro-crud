package com.proyecto.everis.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proyecto.everis.service.IClientService;
import com.proyecto.everis.model.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("clients")
public class ClientController {
	
	@Autowired
	private IClientService repository;

	@PostMapping()
	Mono<Client> create(@Valid @RequestBody Client ClientsStream) {
		return this.repository.create(ClientsStream);
	}
	
	@PutMapping()
	Mono<Client> update(@Valid @RequestBody Client ClientsStream) {
		return this.repository.create(ClientsStream);
	}

	@GetMapping(produces="application/json")
	Flux<Client> list() {
		return repository.listAll();
	}

	@GetMapping("/{id}")
	Mono<Client> findById(@PathVariable String id) {
		return this.repository.findId(id);
	}
	
	@DeleteMapping("/{id}")
	Mono<Void> deleteById(@PathVariable String id) {
		return this.repository.delete(id);
	}
	
	@DeleteMapping
	Mono<Void> deleteAll() {
		return this.repository.deleteAll();
	}

}
