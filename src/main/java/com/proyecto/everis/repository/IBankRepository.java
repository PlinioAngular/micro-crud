package com.proyecto.everis.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.everis.model.Bank;

@Repository
public interface IBankRepository extends ReactiveMongoRepository<Bank, String>{

}
