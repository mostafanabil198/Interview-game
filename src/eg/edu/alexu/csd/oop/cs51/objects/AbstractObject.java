package eg.edu.alexu.csd.oop.cs51.objects;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import eg.edu.alexu.csd.oop.game.GameObject;

public abstract class AbstractObject implements GameObject {

    private int x, y, width, height;
    private String imagePath;
    private boolean visible;
    private BufferedImage[] buffered_image;

    public AbstractObject(int width, int height, String imagePath, boolean visible, String skillName) {
        buffered_image = new BufferedImage[1];
        this.width = width;
        this.height = height;
        this.imagePath = imagePath;
        this.visible = visible;
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Graphics2D g2d = img.createGraphics();
//        g2d.drawImage(img, width, height, null);
//        g2d.setPaint(Color.WHITE);
//        g2d.setFont(new Font("Bernard MT Condensed", Font.BOLD, 8));
//        FontMetrics fm = g2d.getFontMetrics();
//        int y = img.getHeight()/2;
//        int x = img.getWidth()/2 - fm.stringWidth(skillName)/2;
//        g2d.drawString(skillName, x, y);
//        g2d.dispose();
//        BufferedImage imgScaled = (BufferedImage) img.getScaledInstance(width,
//                height, java.awt.Image.SCALE_AREA_AVERAGING);
        
        buffered_image[0] = img;
    }
    
    public AbstractObject(AbstractObject abstractObject) {
        this.buffered_image = abstractObject.buffered_image.clone();
        this.height = abstractObject.height;
        this.imagePath = abstractObject.imagePath;
        this.visible = abstractObject.visible;
        this.width = abstractObject.width;
        this.x = abstractObject.x;
        this.y = abstractObject.y;
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
        // TODO Auto-generated method stub
        return y;
    }

    @Override
    public void setY(int y) {
        // TODO Auto-generated method stub
        this.y = y;

    }

    @Override
    public int getWidth() {
        // TODO Auto-generated method stub
        return width;
    }

    @Override
    public int getHeight() {
        // TODO Auto-generated method stub
        return height;
    }

    @Override
    public boolean isVisible() {
        // TODO Auto-generated method stub
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        // TODO Auto-generated method stub
        return buffered_image;
    }
    
    public abstract AbstractObject clone();

}
