package br.com.alura.stickersimersao.aulas1e2;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

public abstract class RequestHandler {
    public static String getJsonFromEndpoint(String endpoint) {
        URI uri = URI.create(endpoint);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(uri).GET().build();
        try {
            var response = client.send(request, BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}