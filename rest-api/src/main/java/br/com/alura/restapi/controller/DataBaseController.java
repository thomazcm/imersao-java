package br.com.alura.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.restapi.model.Content;
import br.com.alura.restapi.model.ImdbMovie;
import br.com.alura.restapi.model.NasaImage;
import br.com.alura.restapi.repository.ImdbMovieRepository;
import br.com.alura.restapi.repository.NasaImageRepository;
import br.com.alura.restapi.util.ApiUrlBuilder;
import br.com.alura.restapi.util.HttpRequestMaker;
import br.com.alura.restapi.util.ImdbListCreator;
import br.com.alura.restapi.util.NasaListCreator;

@RestController
@RequestMapping("api")
public class DataBaseController {
    @Autowired
    private ImdbMovieRepository imdbRepository;
    @Autowired
    private NasaImageRepository nasaRepository;

    @GetMapping("save/{apiEndpoint}/{apiKey}")
    public String saveApiContent(@PathVariable("apiEndpoint") String apiEndpoint,
            @PathVariable("apiKey") String apiKey) {
        String endpointUrl = ApiUrlBuilder.getLink(apiEndpoint, apiKey);
        String json = new HttpRequestMaker().request(endpointUrl);
        if (apiEndpoint.contentEquals("imdb")) {
            return saveImdbList(json);
        }
        if (apiEndpoint.contentEquals("nasa")) {
            return saveNasaList(json);
        }
        return "Categoria inválida";
    }

    @GetMapping("get/imdb")
    public List<ImdbMovie> getImdbApiContent() {
        return imdbRepository.findAll();
    }

    @GetMapping("get/nasa")
    public List<NasaImage> getNasaApiContent() {
        return nasaRepository.findAll();
    }

    private String saveImdbList(String json) {
        List<Content> imdbMovies = new ImdbListCreator().createList(json);
        if (imdbRepository.findAll().isEmpty()) {
            for (Content content : imdbMovies) {
                var movie = (ImdbMovie) content;
                imdbRepository.save(movie);
            }
            return "Filmes Imdb salvos com sucesso";
        }
        return "Banco de dados já possui as imagens";
    }

    private String saveNasaList(String json) {
        List<Content> nasaList = new NasaListCreator().createList(json);
        if (nasaRepository.findAll().isEmpty()) {
            for (Content content : nasaList) {
                var nasaImage = (NasaImage) content;
                nasaRepository.save(nasaImage);
            }
            return "Imagens do dia da Nasa salvas no banco de dados";
        } else {
            return "Banco de dados já possui as imagens";
        }
    }
    
//    @GetMapping("refresh-imdb/{apiKey}")
//    public String()

    @GetMapping("clear/{password}")
    private String clearRepositories(@PathVariable("password") String password) {
        if (password.contentEquals("")) {
            imdbRepository.deleteAll();
            nasaRepository.deleteAll();
            return "Banco de dados deletado";
        }
        return "senha inválida";
    }
}
