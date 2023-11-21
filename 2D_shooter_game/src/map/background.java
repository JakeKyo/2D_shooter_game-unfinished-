package map;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

// the game background or "map".
public class background {

	private BufferedImage image;
	private boolean issolid = false;
	
	
	public int x;
	int y;
	int width;
	int height;
	
	
	
	
	public background() {
			 
		
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	
	
	public BufferedImage getImage () {
		return this.image;
	}
	
	public void setIsSolid (boolean issolid) {
		this.issolid = issolid;
	}
	
	public int getX () {
		return this.x;
	}
}
