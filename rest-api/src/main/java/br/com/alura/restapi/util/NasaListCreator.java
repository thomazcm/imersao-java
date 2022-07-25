package br.com.alura.restapi.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.alura.restapi.model.Content;
import br.com.alura.restapi.model.NasaImage;

public class NasaListCreator implements ListCreator {

    @Override
    public List<Content> createList(String json) {
        List<Map<String, String>> initialList = new JsonParser().parseListFromString(json);
        var nasaImageList = new ArrayList<Content>();

        for (Map<String, String> image : initialList) {
            if (image.get("media_type").contentEquals("image")) {
                nasaImageList.add(new NasaImage(image.get("title"),
                                                image.get("url")));
            }
        }
        return nasaImageList;
    }

}
