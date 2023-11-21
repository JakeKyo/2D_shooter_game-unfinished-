package enemy;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import character.character;
import main.gamePanel;
import map.backgroundManager;
import map.hitBox;

public class enemy extends algorithm {
	
	
	private int x = 600;
	private int y = 400;
	private int speed = 1;
	BufferedImage image;
	private int health;
	private boolean alive;
	
	Color translucent = new Color(1f,0f,0f,1f );	// custom col for hitbox - change last param to set opacity.
	
	
	
	gamePanel panel;
	backgroundManager manager;
	character character;
	
	public hitBox enemyhitbox;

	
	public enemy (gamePanel panel, backgroundManager manager, character character, int x, int y, int health) {
		this.x = x;
		this.y = y;
		this.panel = panel;
		this.manager = manager;
		this.character = character;
		setImage();
		this.alive = true;
		this.health = health;
		
		enemyhitbox = new hitBox(this.x, this.y, 48, 48, this.translucent, false);
		enemyhitbox.setSize(48, 48);
		enemyhitbox.setLocation(this.x, this.y);
	
	}
	
	
	public void setImage() {
		
			
			try {
				this.image = ImageIO.read(getClass().getResourceAsStream("/enemy/newenemy.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
	}
	
	
	public void update () {
		
	//	System.out.println(panel.character.getX());
	//	movetocharacter(panel, character, this.x, this.y, this.speed);
		
//		movewithpercentage(panel, character, this.x, this.y, this.speed, panel.character.direction);
		if (health <= 0) {
			x =-2000;
		//	panel.attackone.setMapX(-3000);
			enemyhitbox.setLocation(this.x, this.y);
		}
		
	}
	
	
	public void draw (Graphics2D g2) {
	
		g2.drawImage(image, x, y, 48, 48, null);
		
	}
	
	public void setX (int x) {
		this.x = x;
	}
	
	public void setY (int y) {
		this.y = y;
	}
	
	public int getX () {
		return this.x;
	}
	
	public int getY () {
		return this.y;
	}
	
	public void decreaseHealth (int health) {
		this.health -= health;
	}
	
	public int getHealth () {
		return this.health;
	}
	
}
