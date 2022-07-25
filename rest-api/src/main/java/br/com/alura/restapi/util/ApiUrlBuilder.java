package br.com.alura.restapi.util;

public abstract class ApiUrlBuilder {
    
    public static String getLink(String apiEndpoint, String apiKey) {
        if (apiEndpoint.contentEquals("imdb")) {
            return "https://imdb-api.com/en/API/MostPopularMovies/"
                    +apiKey;
        }
        if (apiEndpoint.contentEquals("nasa")) {
            return "https://api.nasa.gov/planetary/apod?api_key="
                    +apiKey
                    +"&start_date=2022-06-01"
                    +"&end_date=2022-06-30";
        }
        return null;
    }
}
