package objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;
import javax.swing.Timer;

import character.character;
import main.gamePanel;
import map.backgroundManager;
import map.hitBox;

public class bomb implements collectable {
	
	
	hitBox bombhitbox;
	hitBox bombattackhitbox;
	gamePanel panel;
	character character;
	backgroundManager manager;
	
	BufferedImage image;
	int [] positions = new int [2];
	int timer;
	boolean inuse;
	boolean pickedup = false;
	Color translucent = new Color(1f,0f,0f,.2f );	// custom col for hitbox - change last param to set opacity.
	
	Ellipse2D attackcircle;
	
	
	public bomb (gamePanel panel, character character, backgroundManager manager) {
		
		this.panel = panel;
		this.character = character;
		this.manager = manager;
		
		setImage("/collectables/bomb.png");
		setRandomPosition(48, panel.getScreenWidth() - 108, 48, panel.getScreenHeight() - 108);
		inuse = true;
	
	
		bombhitbox = new hitBox(positions[0], positions[1], 48, 48, translucent, false);
		bombhitbox.setSize(48, 48);
		bombhitbox.setLocation(positions[0], positions[1]);
		
	
	}

	@Override
	public void setImage (String path) {
		
		
		try {
			this.image = ImageIO.read(getClass().getResourceAsStream(path));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void setRandomPosition (int lowx, int highx, int lowy, int highy) {
		
		 Random random = new Random();
		   int x = random.ints(lowx, highx)
		      .findFirst()
		      .getAsInt();
		   int y = random.ints(lowy, highy)
				      .findFirst()
				      .getAsInt();
		  
		   positions [0] = x;
		   positions [1] = y;
		   
	}

	

	@Override
	public void draw (Graphics2D g2) {
		
		g2.drawImage(image, positions[0], positions[1], 48, 48, null);
		
		
		if (pickedup == true) {
	//		System.out.println("hahaha");
			g2.setColor(Color.RED);
			g2.drawOval(panel.character.getX() - 110, panel.character.getY() - 110, 275, 275);
			attackcircle = new Ellipse2D.Double (panel.character.getX() -110, panel.character.getY() -110, 275, 275);
			g2.setFont(g2.getFont().deriveFont(30F));
			g2.drawString("Press 'E' to attack", panel.character.getX() - 50, panel.character.getY() - 20);
			
			if (attackcircle.intersects(panel.enemy.enemyhitbox) && panel.key.getBombAttack() == true) {
				System.out.println("yayaya");
				panel.enemy.setX(-6000);
				panel.enemy.enemyhitbox.setLocation(-7000, 200);
				pickedup = false;
			}
			
			if (panel.key.getBombAttack() == true) {
				pickedup = false;
			}
			
		}
		
		
	}

	
	public void randomtime () {
		
		
			    
				  
				  setRandomPosition(48, panel.getScreenWidth() - 108, 48, panel.getScreenHeight() - 108);
					bombhitbox.setLocation(positions[0], positions[1]);
					inuse = true;
			  
			
	}

	
	@Override
	public void update () {
		
	
		
		if (inuse == false && pickedup == false) {
			
			
			
			new java.util.Timer().schedule( 
			        new java.util.TimerTask() {
			            @Override
			            public void run() {
			                
			            	setRandomPosition(48, panel.getScreenWidth() - 108, 48, panel.getScreenHeight() - 108);
							bombhitbox.setLocation(positions[0], positions[1]);
							inuse = true;
							
			            }
			        }, 
			        2000
			);
			
	
		}
		
		collisionchecker(panel, character, manager);
		
		
		
	}

	@Override
	public void collisionchecker (gamePanel panel, character character, backgroundManager manager) {
		
		if (panel.character.characterhitbox.intersects(bombhitbox)) {
			System.out.println("you picked up a bomb. Kaaabooom!!");
			positions[0] = -5000;
			panel.bomb.bombhitbox.setLocation(-6500, 200);
			inuse = false;
			pickedup = true;
		}
		
		
		if (bombhitbox.intersects(manager.wall0) || bombhitbox.intersects(manager.wall1) || bombhitbox.intersects(manager.wall2) || bombhitbox.intersects(manager.wall3) || bombhitbox.intersects(manager.wall4) || bombhitbox.intersects(manager.wall5) || bombhitbox.intersects(manager.wall6) || bombhitbox.intersects(manager.wall7) || bombhitbox.intersects(manager.wall8) || bombhitbox.intersects(manager.wall9) || bombhitbox.intersects(manager.wall10) || bombhitbox.intersects(manager.wall11) || bombhitbox.intersects(manager.wall12) || bombhitbox.intersects(manager.wall13) || bombhitbox.intersects(manager.wall14) || bombhitbox.intersects(manager.wall15) || bombhitbox.intersects(manager.wall16) || bombhitbox.intersects(manager.wall17) || bombhitbox.intersects(manager.wall18)) {
			
			positions[0] += 20;
			positions[1] += 20;
			bombhitbox.setLocation(positions[0], positions[1]);
		}
		

	}
	
	
//	public void attackchecker () {
//		if (bombattackhitbox.intersects(panel.enemy.enemyhitbox)) {
//			panel.enemy.setX(-5000);
//		}
//	}
	
	
	public void bombattack () {
		
		
	}

	
	public boolean getPickedUp () {
		return pickedup;
	}
	
	public void setPickedUp (boolean val) {
		this.pickedup = val;
	}

	
		
		
}

	