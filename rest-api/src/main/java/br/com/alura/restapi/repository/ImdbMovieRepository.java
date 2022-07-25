package br.com.alura.restapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.alura.restapi.model.ImdbMovie;

public interface ImdbMovieRepository extends MongoRepository<ImdbMovie, String> {
    
}
