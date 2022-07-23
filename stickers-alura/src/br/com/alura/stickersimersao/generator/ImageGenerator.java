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
        for (Content content : contentList) {
            var sourceImage = getBufferedImageFromUrl(content.getImageUrl());
            var newImage = new BufferedImage(sourceImage.getWidth(), 
                                             sourceImage.getHeight(), BufferedImage.TRANSLUCENT);
            
            saveImage(sourceImage, newImage, directory+content.getTitle());
        }
    }

    public void createListImages(List<Content> contentList, String directory, TextGenerator textGenerator) {
        for (Content content : contentList) {
            var sourceImage = getBufferedImageFromUrl(content.getImageUrl());
            var newHeight = (int) Math.round(sourceImage.getHeight()*1.16);
            var newImage = new BufferedImage(sourceImage.getWidth(),
                                             newHeight, BufferedImage.TRANSLUCENT);
            var contentImdb = (ContentImdb) content;
            var stickerText = textGenerator.generateText(contentImdb.getImDbRating());
            
            saveImage(sourceImage, newImage, directory+content.getTitle(), stickerText);
        }
    }

    private BufferedImage getBufferedImageFromUrl(String url) {
        try {
            BufferedImage sourceImage;
            var inputStreamUrl = new URL(url).openStream();
            sourceImage = ImageIO.read(inputStreamUrl);
            return sourceImage;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    private Graphics2D createGraphics(BufferedImage sourceImage, BufferedImage newImage) {
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(sourceImage, 0, 0, null);
        return graphics;
    }

    private void saveImage(BufferedImage sourceImage, BufferedImage newImage, String fileName) {
        createGraphics(sourceImage, newImage);
        writeImage(newImage, fileName);
    }

    private void saveImage(BufferedImage sourceImage, BufferedImage newImage, String fileName,
            String stickerText) {
        Graphics2D graphics = createGraphics(sourceImage, newImage);
        writeStickerText(sourceImage, newImage, stickerText, graphics);
        writeImage(newImage, fileName);
    }

    private void writeStickerText(BufferedImage sourceImage, BufferedImage newImage, String stickerText,
            Graphics2D graphics) {
        Integer fontSize = (int) Math.round(sourceImage.getWidth()*0.110);
        graphics.setFont(new Font(Font.MONOSPACED, Font.BOLD, fontSize));
        graphics.setColor(Color.YELLOW);
        
        Integer yCorrection = (int) Math.round((newImage.getHeight()-sourceImage.getHeight())*0.88);
        Integer yText = newImage.getHeight() - yCorrection + fontSize;
        Integer xText = (int) Math.round(sourceImage.getWidth()*0.105);
        graphics.drawString(stickerText, xText, yText);
    }

    private void writeImage(BufferedImage newImage, String fileName) {
        try {
            System.out.println("Creating image [" + fileName +"]...");
            ImageIO.write(newImage, "png", new File(fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
