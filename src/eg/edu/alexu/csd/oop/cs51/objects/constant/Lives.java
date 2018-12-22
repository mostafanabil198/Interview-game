package eg.edu.alexu.csd.oop.cs51.objects.constant;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import eg.edu.alexu.csd.oop.cs51.GameInfo;
import eg.edu.alexu.csd.oop.game.GameObject;

public class Lives implements GameObject{
    private static final int WIDTH = 80;
    private static final int HEIGHT = 40;
    private static final String imgPath = "res/heart.png";
    private int x, y;
    private int lives;
    private boolean visible;
    private BufferedImage[] buffered_image;
    
    public Lives(int noLives) {
        x = 100;
        y = 10;
        lives = noLives;
        this.visible = true;
        buffered_image = new BufferedImage[1];
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(imgPath));
            img = resize(img, WIDTH, HEIGHT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Graphics2D g2d = img.createGraphics();
        g2d.setPaint(Color.BLACK);
        g2d.setFont(new Font("Bernard MT Condensed", Font.BOLD, 24));
        FontMetrics fm = g2d.getFontMetrics();
        int y = img.getHeight()/2 + fm.getHeight()/2 - 5;
        int x = 45;
        g2d.drawString(" X"+lives, x, y);
        g2d.dispose();
        BufferedImage imgScaled = resize(img, WIDTH, HEIGHT);
        
        buffered_image[0] = imgScaled;
    }
    public Lives(Lives lives) {
        this.buffered_image = lives.buffered_image.clone();
        this.visible = lives.visible;
        this.x = lives.x;
        this.y = lives.y;
    }
    
    public void repaint() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(imgPath));
            img = resize(img, WIDTH, HEIGHT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Graphics2D g2d = img.createGraphics();
        g2d.setPaint(Color.BLACK);
        g2d.setFont(new Font("Bernard MT Condensed", Font.BOLD, 24));
        FontMetrics fm = g2d.getFontMetrics();
        int y = img.getHeight()/2 + fm.getHeight()/2 - 5;
        int x = 45;
        g2d.drawString(" X"+lives, x, y);
        g2d.dispose();
        BufferedImage imgScaled = resize(img, WIDTH, HEIGHT);
        
        buffered_image[0] = imgScaled;
        
    }
    
    @Override
    public int getX() {
        return x;
    }
    @Override
    public void setX(int x) {
        this.x = x;
    }
    @Override
    public int getY() {
        return y;
    }
    @Override
    public void setY(int y) {
        this.y = y;
    }
    @Override
    public int getWidth() {
        return WIDTH;
    }
    @Override
    public int getHeight() {
        return HEIGHT;
    }
    @Override
    public boolean isVisible() {
        return visible;
    }
    @Override
    public BufferedImage[] getSpriteImages() {
        return buffered_image;
    }
    
    private static BufferedImage resize(BufferedImage img, int newW, int newH) { 
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }  

}
