package br.com.alura.stickersimersao.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.alura.stickersimersao.content.Content;

public class NasaListGenerator implements ListGenerator{
    @Override
    public List<Content> generateList(String endpoint) {
        var contentList = new ArrayList<Content>();
        for (Map<String, String> content : createInitialList(endpoint)) {
            if (content.get("media_type").contains("image")) {
                contentList.add(new Content(content.get("title"),
                                               content.get("url")));
            }
        }
        return contentList;
    }
}
