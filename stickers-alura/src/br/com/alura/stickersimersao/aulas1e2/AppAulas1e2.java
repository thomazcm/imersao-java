package br.com.alura.stickersimersao.aulas1e2;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class AppAulas1e2 {
    public static void main(String[] args) {
//        final String endpoint = "https://imdb-api.com/en/API/Top250Movies/k_l3uzs1py";
        final String endpoint = "https://imdb-api.com/en/API/MostPopularMovies/k_l3uzs1py";
        var gerenciador = new GerenciadorDeLista("resources/lista.txt");
        GeradorDeFigurinhasAulas1e2 gerador = new GeradorDeFigurinhasAulas1e2();

        List<Map<String, String>> listaDeFilmes = gerenciador.criaLista(endpoint);
        gerenciador.restauraImagens(listaDeFilmes);
        gerenciador.arquiva(listaDeFilmes);
        
        criarStickers(gerador, listaDeFilmes);
    }

    private static void criarStickers(GeradorDeFigurinhasAulas1e2 gerador, List<Map<String, String>> listaDeFilmes) {
        int i = 0;
        for (Map<String, String> filme : listaDeFilmes) {
            try {
                i++;
                String urlImagem = filme.get("image");
                String nomeArquivo = "resources/stickers/sticker-" + i;
                String textoSticker = criaTexto(filme.get("imDbRating"));
                gerador.cria(new URL(urlImagem).openStream(), nomeArquivo, textoSticker);
            } catch (IOException e) {
                System.out.println("imagem não encontrada para o filme " + i + ": " + filme.get("title"));
            }
        }
    }

    private static String criaTexto(String rating) {
        if (rating.equals(""))
            return ("  SEM  NOTA ");
        Double nota = Double.parseDouble(rating);
        if (nota >= 8) {
            return ("TOP DOS TOPS");
        }
        if (nota >=7){
            return ("  BOM  FILME ");
        }
        if (nota >=6) {
            return ("MARROMENOS");
        }
        if (nota >=5) {
            return ("  RUINZINHO ");
        }
        return (" LIXO TOTAL");
    }
}
