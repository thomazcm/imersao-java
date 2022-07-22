package br.com.alura.stickersimersao;

public class Teste {

    public static void main(String[] args) {
        String url = "https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX128_CR0,3,128,176_AL_.jpg";
        int end = url.indexOf("@");
        System.out.println(end);
        String novaUrl = url.substring(0, end+1)+".jpg";
        System.out.println(novaUrl);
    }

}
