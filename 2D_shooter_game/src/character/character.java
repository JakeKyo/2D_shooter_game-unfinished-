package character;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import main.gamePanel;
import main.keyHandler;
import main.mouseHandler;
import map.backgroundManager;
import map.hitBox;
import objects.leftClickShoot;



// use for object collisions from projectiles: 




// class to represent character object. The character player controls.
public class character {
	
	
	private int x = 100;
	private int y = 100;
	private int speed = 4;

	
	private BufferedImage pacmanrightimage;
	private BufferedImage pacmanleftimage;
	private BufferedImage pacmanupimage;
	private BufferedImage pacmandownimage;
	
	
	public String direction = "right";
	private boolean iscollision = false;
	private int collisionbump = 10;
	
	
	Color translucent = new Color(1f,0f,0f,.2f );	// custom col for hitbox - change last param to set opacity.
	
	
	
	
	keyHandler key;
	gamePanel panel;
	mouseHandler mouse;
	defaultAttacks defaultAttacks;
	leftClickShoot leftClickShoot;
	public hitBox characterhitbox;
	backgroundManager manager;
	
	
	
	
	
//	defaultAttacks leftclickattack = new defaultAttacks(panel, mouse, key);
	
//	private Rectangle hitbox = new Rectangle(0, 0, panel.tilesize, panel.tilesize);

	
	public character (gamePanel panel, keyHandler key, mouseHandler mouse, backgroundManager manager) {
		
		this.key = key;
		this.panel = panel;
		this.mouse = mouse;
		this.manager = manager;
		setImage();

		
		characterhitbox = new hitBox(this.x, this.y, 48, 48, translucent, false);
		characterhitbox.setSize(48, 48);
		characterhitbox.setLocation(x, y);
		
	}
	

	
	
	
	// load in images for main character
	public void setImage () {
		try {
			
				pacmanupimage = ImageIO.read(getClass().getResourceAsStream("/pacMan/pacmanup.png"));
				pacmandownimage = ImageIO.read(getClass().getResourceAsStream("/pacMan/pacmandown.png"));
				pacmanrightimage = ImageIO.read(getClass().getResourceAsStream("/pacMan/pacmanright.png"));
				pacmanleftimage = ImageIO.read(getClass().getResourceAsStream("/pacMan/pacmanleft.png"));
				
			
		} catch (IOException e) {
			
			e.printStackTrace();}
		}
		
	
		// updates automatically when a key is pressed. Moves player position & direction
		public void update() {
			
	
			if (key.uppress == true) {
				y -= speed;
				direction = "up";
				panel.attackone.mapdirection = "up";
				characterhitbox.movebox(x, y);
				characterhitbox.setLocation(x, y);
				characterhitbox.setBounds(x, y, 48, 48);
				
				
			
			}
			
			else if (key.downpress == true) {
				y += speed;
				direction = "down";
				panel.attackone.mapdirection = "down";
				characterhitbox.movebox(x, y);
				characterhitbox.setLocation(x, y);
				characterhitbox.setBounds(x, y, 48, 48);
			}
			
			else if (key.leftpress == true) {
				x -= speed;
				direction = "left";
				panel.attackone.mapdirection = "left";
				characterhitbox.movebox(x, y);
				characterhitbox.setLocation(x, y);
				characterhitbox.setBounds(x, y, 48, 48);
				
			}
			
			else if (key.rightpress == true) {
				x += speed;
				direction = "right";
				panel.attackone.mapdirection = "right";
				characterhitbox.movebox(x, y);
				characterhitbox.setLocation(x, y);
				characterhitbox.setBounds(x, y, 48, 48);
				
			}
			
			else if (key == null) {
				direction = "right";
				panel.attackone.mapdirection = "right";
				}
			

			iscollision = false;
	//		panel.collision.checker(this, null);
			
			
			collisionchecker(manager);
			
			}
		
		
		// draws graphics to screen. 
		public void draw(Graphics2D g2) {
				
		BufferedImage image = pacmanrightimage;
		
		if (direction == "up") {
			image = pacmanupimage;
		}
		else if (direction == "down") {
			image = pacmandownimage;
		}
		else if (direction == "right") {
			image = pacmanrightimage;
		
		}
		else if (direction == "left") {
			image = pacmanleftimage;
		}
		
		
		g2.drawImage(image, x, y, 48, 48, null);
		characterhitbox.draw(g2);
		
	}
		
		
		public int getX () {
			return x;
		}
		
		
		public int increaseX (int x) {
			this.x += x;
			return this.x;
		}
		
		
		public void decreaseX (int x) {
			this.x -= x;
		}
		
	
		public int getY () {
			return y;
		}
		
		
		public void decreaseY (int y) {
			this.y -= y;
		}
		
		public void increaseY (int y) {
			this.y += y;
		}
		
		
		
		public void collisionchecker (backgroundManager manager) {
			this.manager = manager;
			
			if (characterhitbox.intersects(manager.wall0) && direction.equals("right") || characterhitbox.intersects(manager.wall1) && direction.equals("right") || characterhitbox.intersects(manager.wall2) && direction.equals("right") || characterhitbox.intersects(manager.wall3) && direction.equals("right") || characterhitbox.intersects(manager.wall5) && direction.equals("right") || characterhitbox.intersects(manager.wall6) && direction.equals("right") || characterhitbox.intersects(manager.wall7) && direction.equals("right") || characterhitbox.intersects(manager.wall8) && direction.equals("right") || characterhitbox.intersects(manager.wall9) && direction.equals("right") || characterhitbox.intersects(manager.wall10) && direction.equals("right") || characterhitbox.intersects(manager.wall11) && direction.equals("right") || characterhitbox.intersects(manager.wall16) && direction.equals("right") || characterhitbox.intersects(manager.wall12) && direction.equals("right")) {
				
				x -= collisionbump;
				
			}
			
			else if (characterhitbox.intersects(manager.wall0) && direction.equals("left") || characterhitbox.intersects(manager.wall1) && direction.equals("left") || characterhitbox.intersects(manager.wall2) && direction.equals("left") || characterhitbox.intersects(manager.wall3) && direction.equals("left") || characterhitbox.intersects(manager.wall4) && direction.equals("left") || characterhitbox.intersects(manager.wall5) && direction.equals("left") || characterhitbox.intersects(manager.wall7) && direction.equals("left") || characterhitbox.intersects(manager.wall8) && direction.equals("left") || characterhitbox.intersects(manager.wall9) && direction.equals("left") || characterhitbox.intersects(manager.wall10) && direction.equals("left") || characterhitbox.intersects(manager.wall11) && direction.equals("left") || characterhitbox.intersects(manager.wall18) && direction.equals("left") || characterhitbox.intersects(manager.wall15) && direction.equals("left")) {
				x += collisionbump;
				
			}
			
			else if (characterhitbox.intersects(manager.wall0) && direction.equals("down") || characterhitbox.intersects(manager.wall6) && direction.equals("down") || characterhitbox.intersects(manager.wall7) && direction.equals("down") || characterhitbox.intersects(manager.wall3) && direction.equals("down") || characterhitbox.intersects(manager.wall18) && direction.equals("down") || characterhitbox.intersects(manager.wall16) && direction.equals("down") || characterhitbox.intersects(manager.wall17) && direction.equals("down") || characterhitbox.intersects(manager.wall8) && direction.equals("down") || characterhitbox.intersects(manager.wall12) && direction.equals("down") || characterhitbox.intersects(manager.wall13) && direction.equals("down") || characterhitbox.intersects(manager.wall14) && direction.equals("down") || characterhitbox.intersects(manager.wall15) && direction.equals("down")) {
				y -= collisionbump;
				
			}
			
			else if (characterhitbox.intersects(manager.wall2) && direction.equals("up") || characterhitbox.intersects(manager.wall6) && direction.equals("up") || characterhitbox.intersects(manager.wall7) && direction.equals("up") || characterhitbox.intersects(manager.wall12) && direction.equals("up") || characterhitbox.intersects(manager.wall13) && direction.equals("up") || characterhitbox.intersects(manager.wall14) && direction.equals("up") || characterhitbox.intersects(manager.wall15) && direction.equals("up") || characterhitbox.intersects(manager.wall16) && direction.equals("up") || characterhitbox.intersects(manager.wall17) && direction.equals("up") || characterhitbox.intersects(manager.wall18) && direction.equals("up")) {
				y += collisionbump;
			}
			
			
		    if (getX() < 48)  {
		    	x += collisionbump;
		    }
		    
		    
		    if (getY() < 48)  {
		    	y += collisionbump;
		    }
		    
		    
		    if (getX() > 660)  {
		    	x -= collisionbump;
		    }
		    
		    
		    if (getY() > 640)  {
		    	y -= collisionbump;
		    }
		    
		    
		    if (characterhitbox.intersects(panel.enemy.enemyhitbox)) {
		    	System.out.println("you caught me!!");
		    }
		    
		}
	
}
