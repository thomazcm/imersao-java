package br.com.alura.stickersimersao.gerador;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.alura.stickersimersao.dados.Conteudo;
import br.com.alura.stickersimersao.dados.ConteudoImdb;
import br.com.alura.stickersimersao.util.JsonParser;

public class GeradorDeLista {
    public List<Conteudo> criaListaNasa(String json) {
        List<Map<String, String>> listaInicial = JsonParser.parse(json);
        var listaConteudo = new ArrayList<Conteudo>();
        for (Map<String, String> conteudo : listaInicial) {
            if (conteudo.get("media_type").contains("image")) {
                listaConteudo.add(new Conteudo(conteudo.get("title"),
                                               conteudo.get("url")
                                               ));
            }
        }
        return listaConteudo;
    }

    public List<Conteudo> criaListaImdb(String json) {
        List<Map<String, String>> listaInicial = JsonParser.parse(json);
        var listaConteudo = new ArrayList<Conteudo>();
        for (Map<String, String> conteudo : listaInicial) {
            listaConteudo.add(new ConteudoImdb(conteudo.get("title"),
                                               conteudo.get("image"), 
                                               conteudo.get("imDbRating")
                                               ));
        }
        return listaConteudo;
    }
}
