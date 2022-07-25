package br.com.alura.restapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.restapi.model.Content;
import br.com.alura.restapi.repository.ImdbMovieRepository;
import br.com.alura.restapi.repository.NasaImageRepository;

@Controller
@RequestMapping("list")
public class ListController {
    @Autowired
    private ImdbMovieRepository imdbRepository;
    @Autowired
    private NasaImageRepository nasaRepository;
//    @Autowired
//    private LinguagensRepository linguagensRepository;
    
    
    @GetMapping("/{category}")
    public String home(@PathVariable("category") String category, Model model) {
        List<Content> contentList = getCategoryList(category);
        
        model.addAttribute("contentList", contentList);
        model.addAttribute("category", category);
        model.addAttribute("titulo", getCategoryTitle(category));
        return "home";
    }


    private String getCategoryTitle(String category) {
        switch (category) {
        case "imdb": {
            return "100 Filmes Mais Populares Imdb";
        }
        case "nasa": {
            return "Imagens do dia NASA - Junho de 2022";
        }
        default:
            throw new IllegalArgumentException("Unexpected value: " + category);
        }
    }


    private List<Content> getCategoryList(String category) {
        switch (category) {
        case "imdb": {
            return new ArrayList<Content>(imdbRepository.findAll());
        }
        case "nasa": {
            return new ArrayList<Content>(nasaRepository.findAll());
        }
        default:
            throw new IllegalArgumentException("Unexpected value: " + category);
        }
    }
    
}
