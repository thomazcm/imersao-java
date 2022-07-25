package br.com.alura.restapi.util;

import java.util.List;

import br.com.alura.restapi.model.Content;

public interface ListCreator {
    public List<Content> createList(String json);
}