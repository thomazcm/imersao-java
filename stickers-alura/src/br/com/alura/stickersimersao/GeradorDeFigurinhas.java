package br.com.alura.stickersimersao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {
    
    public void cria(InputStream inputStream, String nomeArquivo, String textoSticker) throws IOException {
        BufferedImage imagemOriginal = ImageIO.read(inputStream);
        Integer largura = imagemOriginal.getWidth();
        Integer altura = imagemOriginal.getHeight();
        
        Integer novaAltura = (int) Math.round(altura*1.16);
        
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        
        graphics.drawImage(imagemOriginal, 0, 0, null);
        
        Integer tamanhoFonte = (int) Math.round(largura*0.110);
        
        Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, tamanhoFonte);
        graphics.setFont(fonte);
        graphics.setColor(Color.YELLOW);
        
        Integer correcaoY = (int) Math.round((novaAltura-altura)*0.88);
        Integer yTexto = novaAltura - correcaoY + tamanhoFonte;
        Integer xTexto = (int) Math.round(largura*0.11);
        
        
        graphics.drawString(textoSticker, xTexto, yTexto);
        ImageIO.write(novaImagem, "png", new File(nomeArquivo+".png"));
    }
}
