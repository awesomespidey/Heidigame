import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Fruit extends GameObject {
	public BufferedImage image;
	public boolean needImage = true;
	public boolean gotImage = false;
	String fruit;

	Fruit(int x, int y, int width, int height, String fruit) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		this.fruit = fruit;
		if (needImage) {
			loadImage(fruit);
		}
	}

	void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, width, height);
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}
}
