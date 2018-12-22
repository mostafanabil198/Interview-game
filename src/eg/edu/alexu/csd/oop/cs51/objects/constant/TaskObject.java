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
import java.util.List;

import javax.imageio.ImageIO;

import eg.edu.alexu.csd.oop.cs51.tasks.Task;
import eg.edu.alexu.csd.oop.game.GameObject;

public class TaskObject implements GameObject {
    private static final int WIDTH = 200;
    private static final int HEIGHT = 60;
    private String imgPath;
    private int x, y;
    private boolean visible;
    private Task task;
    private BufferedImage[] buffered_image;
    private String text;
    
    public TaskObject(Task task) {
        imgPath = "res/" + task.getCompanyName() + ".png"; 
        text = task.getSkills().get(0) +
                " - " + task.getSkills().get(1) +
                " - " + task.getSkills().get(2);
        
        this.task = task;
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
        g2d.setPaint(Color.WHITE);
        g2d.setFont(new Font("Bernard MT Condensed", Font.BOLD, 14));
        FontMetrics fm = g2d.getFontMetrics();
        int y = img.getHeight()/2 + 10;
        int x = img.getWidth()/2 - fm.stringWidth(text)/2;
        g2d.drawString(text, x, y);
        g2d.dispose();
        BufferedImage imgScaled = resize(img, WIDTH, HEIGHT);
        
        buffered_image[0] = imgScaled;
    }
    public TaskObject(TaskObject taskObject) {
        this.buffered_image = taskObject.buffered_image.clone();
        this.visible = taskObject.visible;
        this.imgPath = taskObject.imgPath;
        this.task = taskObject.task;
        this.text = taskObject.text;
        this.x = taskObject.x;
        this.y = taskObject.y;
    }
    
    public void markAsDone() {
        Graphics2D g2d = buffered_image[0].createGraphics();
        g2d.setPaint(Color.BLACK);
        g2d.setFont(new Font("Bernard MT Condensed", Font.BOLD, 14));
        g2d.setStroke(new BasicStroke(2));
        FontMetrics fm = g2d.getFontMetrics();
        int y = buffered_image[0].getHeight()/2 + 6;
        int x = (buffered_image[0].getWidth()/2 - fm.stringWidth(text)/2) - 3;
        g2d.drawLine(x, y, x + fm.stringWidth(text) + 3 , y);
        g2d.dispose();
        
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
