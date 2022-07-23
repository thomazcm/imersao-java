package br.com.alura.stickersimersao.generator;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import br.com.alura.stickersimersao.content.Content;

public class ImageGenerator {
    public void createListImages(List<Content> contentList, String directory) {
        try {
            for (Content content : contentList) {
                String fileName = directory + content.getTitle().replaceAll(":", "");
                var inputStreamUrl = new URL(content.getImageUrl()).openStream();

                createImage(inputStreamUrl, fileName);
                System.out.println("Creating image [" + content.getTitle() + "]...");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    private void createImage(InputStream inputStream, String fileName) {
        BufferedImage originalImage;
        try {
            originalImage = ImageIO.read(inputStream);
            String format = "png";
            Integer width = originalImage.getWidth();
            Integer height = originalImage.getHeight();

            BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
            Graphics2D graphics = (Graphics2D) newImage.getGraphics();
            graphics.drawImage(originalImage, 0, 0, null);

            ImageIO.write(newImage, format, new File(fileName + "." + format));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

//    public void cria(InputStream inputStream, String nomeArquivo, String textoSticker) throws IOException {
//        BufferedImage imagemOriginal = ImageIO.read(inputStream);
//        Integer largura = imagemOriginal.getWidth();
//        Integer altura = imagemOriginal.getHeight();
//        
//        Integer novaAltura = (int) Math.round(altura*1.16);
//        
//        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
//        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
//        
//        graphics.drawImage(imagemOriginal, 0, 0, null);
//        
//        Integer tamanhoFonte = (int) Math.round(largura*0.110);
//        
//        Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, tamanhoFonte);
//        graphics.setFont(fonte);
//        graphics.setColor(Color.YELLOW);
//        
//        Integer correcaoY = (int) Math.round((novaAltura-altura)*0.88);
//        Integer yTexto = novaAltura - correcaoY + tamanhoFonte;
//        Integer xTexto = (int) Math.round(largura*0.11);
//        
//        
//        graphics.drawString(textoSticker, xTexto, yTexto);
//        ImageIO.write(novaImagem, "png", new File(nomeArquivo+".png"));
//    }
}
