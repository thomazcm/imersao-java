package br.com.alura.restapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.alura.restapi.model.NasaImage;

public interface NasaImageRepository extends MongoRepository<NasaImage, String>{

}
