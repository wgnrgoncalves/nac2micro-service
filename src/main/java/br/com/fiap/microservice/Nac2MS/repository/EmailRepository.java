package br.com.fiap.microservice.Nac2MS.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fiap.microservice.Nac2MS.model.Email;

public interface EmailRepository extends MongoRepository<Email, String> {

}
