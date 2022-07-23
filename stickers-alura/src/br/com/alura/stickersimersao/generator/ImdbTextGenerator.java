package br.com.alura.stickersimersao.generator;

public class ImdbTextGenerator implements TextGenerator{
    @Override
    public String generateText(String rating) {
        if (rating.equals(""))
            return ("  SEM  NOTA ");
        Double ratingDouble = Double.parseDouble(rating);
        if (ratingDouble >= 8) {
            return ("TOP DOS TOPS");
        }
        if (ratingDouble >=7){
            return ("  BOM  FILME ");
        }
        if (ratingDouble >=6) {
            return ("MARROMENOS");
        }
        if (ratingDouble >=5) {
            return ("  RUINZINHO ");
        }
        return (" LIXO TOTAL");
    }
}
