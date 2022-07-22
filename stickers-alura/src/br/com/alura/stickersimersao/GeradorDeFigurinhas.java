package br.com.alura.stickersimersao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {
    public void cria() throws IOException {
        // leitura da imagem
        InputStream inputStream = new FileInputStream(new File("resources/imagem-maior.jpg"));
        
        BufferedImage imagemOriginal = ImageIO.read(inputStream);
        // cria nova imagem em memória com transparência e com tamanho novo
        Integer largura = imagemOriginal.getWidth();
        Integer altura = imagemOriginal.getHeight();
        Integer novaAltura = altura + 150;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        
        graphics.drawImage(imagemOriginal, 0, 0, null);
        
        
        
        //escrever uma frase na nova imagem
        Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 98);
        graphics.setFont(fonte);
        graphics.setColor(Color.YELLOW);
        graphics.drawString("TOPPER", 100, novaAltura-40);
        
        // copiar a imagem original pra nova imagem(em memória)
        ImageIO.write(novaImagem, "png", new File("resources/figurinha.png"));
        
        
        
    }
    public static void main(String[] args) throws IOException {
        GeradorDeFigurinhas gerador = new GeradorDeFigurinhas();
        gerador.cria();
    }
    
}
