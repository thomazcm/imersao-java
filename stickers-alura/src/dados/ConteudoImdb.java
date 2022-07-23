package dados;

public class ConteudoImdb extends Conteudo{
    private final String imDbRating;
    
    public ConteudoImdb(String titulo, String urlImagem, String imDbRating) {
        super(titulo, urlImagem.replaceAll("(@+)(.*).jpg$", "$1.jpg"));
        this.imDbRating = imDbRating;
    }

    public String getImDbRating() {
        return imDbRating;
    }
}
