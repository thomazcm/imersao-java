package br.com.alura.stickersimersao.aulas1e2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import br.com.alura.stickersimersao.util.JsonParser;
import br.com.alura.stickersimersao.util.RequestMaker;

public class GerenciadorDeLista {
    private File arquivo;
    
    public GerenciadorDeLista(String arquivo) {
        this.arquivo = new File(arquivo);
    }

    public List<Map<String, String>> criaLista(String endpoint) {
        String json = RequestMaker.getJsonFromEndpoint(endpoint);
        return JsonParser.parseListFromString(json);
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
            writer = new PrintWriter(arquivo);
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
