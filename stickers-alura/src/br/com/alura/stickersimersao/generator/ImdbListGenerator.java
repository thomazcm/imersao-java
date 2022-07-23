package br.com.alura.stickersimersao.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.alura.stickersimersao.content.Content;
import br.com.alura.stickersimersao.content.ContentImdb;
import br.com.alura.stickersimersao.util.JsonParser;

public class ImdbListGenerator implements ListGenerator{
    private JsonParser parser = new JsonParser();
    
    @Override
    public List<Content> generateList(String endpoint) {
        var contentList = new ArrayList<Content>();
        for (Map<String, String> content : createInitialList(endpoint, parser)) {
            contentList.add(new ContentImdb(content.get("title"),
                                               content.get("image"), 
                                               content.get("imDbRating")));
        }
        return contentList;
    }
}
