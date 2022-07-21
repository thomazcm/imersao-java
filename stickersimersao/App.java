package br.com.alura.stickersimersao;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

import br.com.alura.stickersimersao.util.RequestSaver;

public class App {
    public static void main(String[] args) {
        String json = pegarJsonString("https://imdb-api.com/en/API/Top250Movies/k_l3uzs1py", false);
        List<Map<String, String>> listaDeFilmes = new JsonParser().parse(json);

        for (Map<String, String> filme : listaDeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println();
        }
        
    }

    private static String pegarJsonString(String url, Boolean newRequest) {
        URI endereco = URI.create(url);
        var httpClient = HttpClient.newHttpClient();
        var httpRequest = HttpRequest.newBuilder(endereco).GET().build();

        if (newRequest) {
            try {
                HttpResponse<String> response = httpClient.send(httpRequest, BodyHandlers.ofString());
                return response.body();
            } catch (IOException | InterruptedException e){
                e.printStackTrace();
            }
            return null;
        }
        return RequestSaver.getJson();
    }
}
