package br.com.alura.stickersimersao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import br.com.alura.stickersimersao.dados.Conteudo;
import br.com.alura.stickersimersao.gerador.GeradorDeFigurinhas;
import br.com.alura.stickersimersao.gerador.GeradorDeLista;
import br.com.alura.stickersimersao.util.RequestMaker;

public class AppNasa {
    public static void main(String[] args) throws Exception {
        final String endpoint = "https://api.nasa.gov/planetary/apod"
                + "?api_key=jzjERK6XqJVpPPnokJsLvd3FIxWaoV7pKPlIqmSW" + "&start_date=2022-06-15"
                + "&end_date=2022-06-23";
        String json = RequestMaker.getJsonFromEndpoint(endpoint);
        List<Conteudo> listaConteudo = new GeradorDeLista().criaListaNasa(json);
        
        CriaFigurinhas(listaConteudo);
    }

    private static void CriaFigurinhas(List<Conteudo> listaConteudo)
            throws IOException, MalformedURLException {
        var geradorFigurinha = new GeradorDeFigurinhas();
        for (Conteudo conteudo : listaConteudo) {
            String url = conteudo.getUrlImagem();
            String nomeArquivo = "output/nasa/" + conteudo.getTitulo().replaceAll(":", "");
            System.out.println("criando imagem " + conteudo.getTitulo() + "...");
            geradorFigurinha.criaImagem(new URL(url).openStream(), nomeArquivo);
        }
    }
}
