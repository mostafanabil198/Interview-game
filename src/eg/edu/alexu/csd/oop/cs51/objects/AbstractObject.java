package eg.edu.alexu.csd.oop.cs51.objects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.prism.Image;

import eg.edu.alexu.csd.oop.game.GameObject;

public abstract class AbstractObject implements GameObject{
	
private int x,y,width,height;
private String imagePath;
private boolean visible;
private BufferedImage[] buffered_image;
 public  AbstractObject(int width,int height,String imagePath,boolean visible) {
	// TODO Auto-generated constructor stub
	 buffered_image=new BufferedImage[1];
	 this.width=width;
	 this.height=height;
	 this.imagePath=imagePath;
	 this.visible=visible;
	BufferedImage img = null;
	try {
		img = ImageIO.read(new File(imagePath));
	} catch (IOException e) {
		e.printStackTrace();
	}
	BufferedImage imgScaled=(BufferedImage) img.getScaledInstance(width, height, java.awt.Image.SCALE_AREA_AVERAGING);
	buffered_image[0]=imgScaled;
}
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		this.x=x;
		
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		this.y=y;
		
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
		this.visible=visible;
	}
	

	@Override
	public BufferedImage[] getSpriteImages() {
		// TODO Auto-generated method stub
		return buffered_image;
	}

}
