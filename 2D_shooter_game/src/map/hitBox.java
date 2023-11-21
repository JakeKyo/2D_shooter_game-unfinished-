package map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class hitBox extends Rectangle {
	
	Color color;
	int x;
	int y;
	int width;
	int height;
	public Boolean coll;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public hitBox (int x, int y, int width, int height, Color color, Boolean coll) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.coll = coll;
		
	}
	
	public void draw(Graphics2D g2) {
		g2.setColor(this.color);
		g2.fillRect((int) this.x, this.y, this.width, this.height);
		
	}
	
	public void movebox (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	public double getX() {
		return x;
	}
	
	
	public double getY() {
		return y;
	}
	

	
	

}
