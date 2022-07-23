package br.com.alura.stickersimersao.generator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import br.com.alura.stickersimersao.content.Content;
import br.com.alura.stickersimersao.content.ContentImdb;

public class ImageGenerator {
    public void createListImages(List<Content> contentList, String directory) {
        try {
            for (Content content : contentList) {
                String fileName = directory + content.getTitle().replaceAll(":", "");
                var inputStreamUrl = new URL(content.getImageUrl()).openStream();
                BufferedImage sourceImage = ImageIO.read(inputStreamUrl);
                BufferedImage newImage = new BufferedImage(sourceImage.getWidth(), 
                                                           sourceImage.getHeight(), 
                                                           BufferedImage.TRANSLUCENT);
                saveImage(sourceImage, newImage, fileName);
                System.out.println("Creating image [" + content.getTitle() + "]...");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    public void createListImages(List<Content> contentList, String directory, TextGenerator textGenerator) {
        try {
            for (Content content : contentList) {
                String fileName = directory + content.getTitle().replaceAll(":", "");
                var inputStreamUrl = new URL(content.getImageUrl()).openStream();
                BufferedImage sourceImage = ImageIO.read(inputStreamUrl);
                ////// repeated code above/////
                Integer newHeight = (int) Math.round(sourceImage.getHeight()*1.16);
                var newImage = new BufferedImage(sourceImage.getWidth(),
                                                           newHeight,
                                                           BufferedImage.TRANSLUCENT);
                var contentImdb = (ContentImdb) content;
                String stickerText = textGenerator.generateText(contentImdb.getImDbRating());
                saveImage(sourceImage, newImage, fileName, stickerText);
                System.out.println("Creating image [" + content.getTitle() + "]...");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    private void saveImage(BufferedImage sourceImage, BufferedImage newImage, String fileName) throws IOException {
        String format = "png";
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(sourceImage, 0, 0, null);
        ImageIO.write(newImage, format, new File(fileName + "." + format));
    }

    private void saveImage(BufferedImage sourceImage, BufferedImage newImage, String fileName,
            String stickerText) throws IOException {
        String format = "png";
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(sourceImage, 0, 0, null);
        ////// repeated code above/////
        Integer fontSize = (int) Math.round(sourceImage.getWidth()*0.110);
        graphics.setFont(new Font(Font.MONOSPACED, Font.BOLD, fontSize));
        graphics.setColor(Color.YELLOW);
        
        Integer yCorrection = (int) Math.round((newImage.getHeight()-sourceImage.getHeight())*0.88);
        Integer yText = newImage.getHeight() - yCorrection + fontSize;
        Integer xText = (int) Math.round(sourceImage.getWidth()*0.105);
        graphics.drawString(stickerText, xText, yText);
        
        ImageIO.write(newImage, format, new File(fileName + "." + format));
    }
}
