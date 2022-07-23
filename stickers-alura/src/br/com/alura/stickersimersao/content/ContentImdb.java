package br.com.alura.stickersimersao.content;

public class ContentImdb extends Content{
    private final String imDbRating;
    
    public ContentImdb(String titulo, String urlImagem, String imDbRating) {
        super(titulo, urlImagem.replaceAll("(@+)(.*).jpg$", "$1.jpg"));
        this.imDbRating = imDbRating;
    }

    public String getImDbRating() {
        return imDbRating;
    }
}
