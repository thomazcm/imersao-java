package br.com.alura.stickersimersao.generator;

import java.util.List;
import java.util.Map;

import br.com.alura.stickersimersao.content.Content;
import br.com.alura.stickersimersao.util.JsonParser;
import br.com.alura.stickersimersao.util.RequestMaker;

public interface ListGenerator {
    public List<Content> generateList(String endpoint);
    
    default List<Map<String, String>> createInitialList(String endpoint, JsonParser parser) {
        String json = RequestMaker.getJsonFromEndpoint(endpoint);
        return parser.parseListFromString(json);
    }
}
