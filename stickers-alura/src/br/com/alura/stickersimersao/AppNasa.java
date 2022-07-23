package br.com.alura.stickersimersao;

import java.util.List;

import br.com.alura.stickersimersao.content.Content;
import br.com.alura.stickersimersao.generator.ImageGenerator;
import br.com.alura.stickersimersao.generator.ListGenerator;
import br.com.alura.stickersimersao.generator.NasaListGenerator;

public class AppNasa {
    public static void main(String[] args) {
        final String endpoint = "https://api.nasa.gov/planetary/apod?api_key=jzjERK6XqJVpPPnokJsLvd3FIxWaoV7pKPlIqmSW" 
                                + "&start_date=2022-05-20"
                                + "&end_date=2022-05-25";
        ListGenerator generator = new NasaListGenerator();
        
        
        List<Content> contentList = generator.generateList(endpoint);
        new ImageGenerator().createListImages(contentList, "output/nasa/");
    }
}
