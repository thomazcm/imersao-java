package br.com.alura.stickersimersao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import br.com.alura.stickersimersao.util.JsonParser;
import br.com.alura.stickersimersao.util.RequestHandler;

public class GerenciadorDeLista {
    private File lista = new File("resources/lista.txt");

    public List<Map<String, String>> criaLista(String endpoint) {
        String json = RequestHandler.getJsonFromEndpoint(endpoint);
        return JsonParser.parse(json);
    }

    public List<Map<String, String>> restauraImagens(List<Map<String, String>> lista) {
        for (Map<String, String> atributo : lista) {
            String url = atributo.get("image");
            int fim = url.indexOf("._V");
            String novaUrl = url.substring(0, fim) + ".jpg";
            atributo.replace("image", url, novaUrl);
        }
        return lista;
    }

    public void arquiva(List<Map<String, String>> listaDeFilmes) {
        PrintWriter writer;
        try {
            writer = new PrintWriter(lista);
            for (Map<String, String> filme : listaDeFilmes) {
                for (Map.Entry<String, String> entry : filme.entrySet()) {
                    String key = entry.getKey();
                    String val = entry.getValue();
                    writer.write(key + ": ");
                    writer.write(val);
                    writer.println();
                }
                writer.write("===");
                writer.println();
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
