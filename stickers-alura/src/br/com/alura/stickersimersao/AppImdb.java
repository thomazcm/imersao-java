package br.com.alura.stickersimersao;

import java.util.List;

import br.com.alura.stickersimersao.content.Content;
import br.com.alura.stickersimersao.generator.ImageGenerator;
import br.com.alura.stickersimersao.generator.ImdbListGenerator;
import br.com.alura.stickersimersao.generator.ImdbTextGenerator;
import br.com.alura.stickersimersao.generator.ListGenerator;

public class AppImdb {
    public static void main(String[] args) {
        final String endpoint = "https://imdb-api.com/en/API/MostPopularMovies/k_l3uzs1py";
        ListGenerator generator = new ImdbListGenerator();
        List<Content> contentList = generator.generateList(endpoint);
        
        new ImageGenerator().createListImages(contentList, "output/imdb/", new ImdbTextGenerator());
    }
}