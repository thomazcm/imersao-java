package br.com.alura.stickersimersao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws IOException {
        final String endpoint = "https://imdb-api.com/en/API/Top250Movies/k_l3uzs1py";
        var gerenciador = new GerenciadorDeLista();
        
        List<Map<String, String>> listaDeFilmes = gerenciador.criaLista(endpoint);
        //List<Map<String, String>> listaDeFilmes = gerenciador.acessaLista();
        
        //gerenciador.arquiva(listaDeFilmes);
        
        

        for (Map<String, String> filme : listaDeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println();
        }
    }
}
