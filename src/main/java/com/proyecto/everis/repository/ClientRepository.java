package com.proyecto.everis.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.proyecto.everis.model.Client;

@Component
public interface ClientRepository extends ReactiveMongoRepository<Client, String> {

}
