package br.com.alura.stickersimersao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import br.com.alura.stickersimersao.dados.Conteudo;
import br.com.alura.stickersimersao.gerador.GeradorDeFigurinhas;
import br.com.alura.stickersimersao.gerador.GeradorDeLista;
import br.com.alura.stickersimersao.util.RequestMaker;

public class AppImdb {
    public static void main(String[] args) throws Exception {
        final String endpoint = "https://imdb-api.com/en/API/MostPopularMovies/k_l3uzs1py";
        String json = RequestMaker.getJsonFromEndpoint(endpoint);
        List<Conteudo> listaConteudo = new GeradorDeLista().criaListaImdb(json);
        
        CriaFigurinhas(listaConteudo);
    }

    private static void CriaFigurinhas(List<Conteudo> listaConteudo)
            throws IOException, MalformedURLException {
        var geradorFigurinha = new GeradorDeFigurinhas();
        for (Conteudo conteudo : listaConteudo) {
            String url = conteudo.getUrlImagem();
            String nomeArquivo = "output/imdb/" + conteudo.getTitulo().replaceAll(":", "");
            System.out.println("criando imagem " + conteudo.getTitulo() + "...");
            geradorFigurinha.criaImagem(new URL(url).openStream(), nomeArquivo);
        }
    }
    
    }