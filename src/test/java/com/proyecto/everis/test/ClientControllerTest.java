package com.proyecto.everis.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.proyecto.everis.controller.ClientController;
import com.proyecto.everis.model.Client;
import com.proyecto.everis.service.impl.ClientServiceImpl;

import reactor.core.publisher.Mono;


@WebFluxTest(controllers = ClientController.class)
public class ClientControllerTest {
	
	@Autowired
	private WebTestClient webTestClient;
	
	@Autowired
	private ClientServiceImpl clientRepository;
	
	@Test
	public void saveClient() {
	Client cl=new Client();
	cl.setId("1");
	cl.setNameClient("PEPE");
	cl.setTypeClient("PERSONAL");
	cl.setTypeDoc("DNI");
	cl.setNumDoc("12345678");
	clientRepository.deleteAll().subscribe();
	 
	webTestClient.post().uri("/clients")
	.contentType(MediaType.APPLICATION_JSON)
	                 .body(Mono.just(cl), Client.class)
	.exchange()
	.expectStatus().isOk()
	.expectHeader().valueEquals("Content-Type", MediaType.APPLICATION_JSON.toString())
	.expectBody()
	.jsonPath("$.nameClient").isEqualTo("PEPE");      
	              
	}
	
	@Test
	public void listClient() {
		webTestClient.get().uri("/clients")
				.exchange()
				.expectStatus().isOk()
				.expectHeader().valueEquals("Content-Type", MediaType.APPLICATION_JSON.toString())
				.expectBodyList(Client.class).hasSize(1);
			     
               
	}	
	
	@Test
	public void listOneClient() {
		webTestClient.get().uri("/clients/{id}",1)
			.exchange()
	        .expectStatus().isOk()
	        .expectHeader().valueEquals("Content-Type", MediaType.APPLICATION_JSON.toString())
	        .expectBody()
	        .jsonPath("$.nameClient").isEqualTo("JUAN");      
	}
	
	@Test
	public void updateClient() {
		Client cl=new Client();
		cl.setId("1");
		cl.setNameClient("JUAN");
		cl.setTypeClient("PERSONAL");
		cl.setTypeDoc("DNI");
		cl.setNumDoc("12345678");
		clientRepository.deleteAll().subscribe();
		 
		webTestClient.put().uri("/clients")
			.contentType(MediaType.APPLICATION_JSON)
	                 .body(Mono.just(cl), Client.class)
	                 .exchange()
	                 .expectStatus().isOk()
	                 .expectHeader().valueEquals("Content-Type", MediaType.APPLICATION_JSON.toString())
	                 .expectBody()
	                 .jsonPath("$.nameClient").isEqualTo("JUAN");      
	              
	}
	
	@Test
	public void deleteOne() {
		webTestClient.delete()
        .uri("/clients/1")
        .exchange()
        .expectStatus().isOk()
        .expectBody(String.class);
	}
	
	@Test
	public void deleteAll() {
		webTestClient.delete()
        .uri("/clients")
        .exchange()
        .expectStatus().isOk()
        .expectBody(String.class);
	}

}
