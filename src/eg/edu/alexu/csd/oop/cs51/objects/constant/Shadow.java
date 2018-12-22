package eg.edu.alexu.csd.oop.cs51.objects.constant;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import eg.edu.alexu.csd.oop.game.GameObject;

public class Shadow implements GameObject {
	private int x, y, width, height;
	private boolean visible;
	private BufferedImage[] buffered_image;

	public Shadow() {
		buffered_image = new BufferedImage[67];
		x = 0;
		y = 0;
		width = 1366;
		height = 768;
		visible = true;
		String shdowFold = "res/shadow";
		for (int i = 1; i <= 67; i++) {
			try {
				buffered_image[i - 1] = ImageIO.read(new File(shdowFold + "/" + i + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public void setX(int x) {
		

	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setY(int y) {
		

	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public boolean isVisible() {
		return visible;
	}

	@Override
	public BufferedImage[] getSpriteImages() {

		return buffered_image;
	}

}
