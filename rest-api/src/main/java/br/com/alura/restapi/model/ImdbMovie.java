package br.com.alura.restapi.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="imdbMovies")
public class ImdbMovie extends Content {
    private String imdbRating;
    private List<Integer> stars = new ArrayList<Integer>();

    public ImdbMovie(String title, String imageUrl, String imdbRating) {
        super(title, fixImageLink(imageUrl));
        this.imdbRating = imdbRating;
        giveStars(imdbRating);
    }
    
    private static String fixImageLink(String imageUrl) {
        try {
            int index = imageUrl.indexOf("._V");
            return imageUrl.substring(0, index)+".jpg";
        } catch (StringIndexOutOfBoundsException e) {
            return imageUrl;
        }
    }

    private void giveStars(String imdbRating) {
        try {
            int ratingRounded = (int) Math.round(Double.parseDouble(imdbRating));
            for (int i = 0; i < ratingRounded; i++) {
                stars.add(1);
            }
        } catch(NumberFormatException e) {
            return;
        }
    }

    public List<Integer> getStars() {
        return stars;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImbRating(String imDbrating) {
        this.imdbRating = imDbrating;
    }
}
