package com.proyecto.everis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;


@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaRepositories("com.proyecto.everis.*")
@ComponentScan({ "com.proyecto.everis.controller","com.proyecto.everis.service.impl","com.proyecto.everis.service"})
@EnableReactiveMongoRepositories(basePackages = { "com.proyecto.everis.repository","com.proyecto.everis.service","com.proyecto.everis.service.impl"})
public class MicroCrudApplication extends  AbstractReactiveMongoConfiguration  {
	

	public static void main(String[] args) {
		SpringApplication.run(MicroCrudApplication.class, args);
	}
	 @Bean
	    public MongoClient mongoClient() {
	        return MongoClients.create();
	    }

	    @Override
	    protected String getDatabaseName() {
	        return "reactive";
	    }

}
