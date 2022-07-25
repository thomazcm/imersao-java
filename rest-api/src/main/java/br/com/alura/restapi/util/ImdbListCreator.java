package br.com.alura.restapi.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.alura.restapi.model.Content;
import br.com.alura.restapi.model.ImdbMovie;

public class ImdbListCreator  implements ListCreator{
    
    @Override
    public List<Content> createList(String json) {
        List<Map<String,String>> initialList = new JsonParser().parseListFromString(json);
        var movieList = new ArrayList<Content>();
        
        for (Map<String, String> movie : initialList) {
            movieList.add(new ImdbMovie(movie.get("title"),
                                        movie.get("image"),
                                        movie.get("imDbRating")
                                        ));
        }
        return movieList;
    }
}
