package map;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

import character.character;
import main.gamePanel;

// background manager that controls individual tiles of whole background.
public class backgroundManager extends background {
	
	gamePanel panel;
	public background[] background;
	Color translucent = new Color(1f,0f,1f,.2f );	// custom color for hitbox, change last param for opacity.
//	public hitBox wall;
	
	
	// creating hitboxes
	
	public hitBox wall0 = new hitBox(202, 480, 28, 48, translucent, false);
	public hitBox wall1 = new hitBox(202, 528, 28, 48, translucent, false);
	public hitBox wall2 = new hitBox(202, 576, 28, 48, translucent, false);
	
	public hitBox wall3 = new hitBox(530, 500, 28, 48, translucent, false);
	public hitBox wall4 = new hitBox(530, 548, 28, 48, translucent, false);
	public hitBox wall5 = new hitBox(530, 596, 28, 48, translucent, false);
	
	public hitBox wall6 = new hitBox(300, 448, 48, 28, translucent, false);
	public hitBox wall7 = new hitBox(348, 448, 48, 28, translucent, false);
	
	public hitBox wall8 = new hitBox(420, 96, 28, 48, translucent, false);
	public hitBox wall9 = new hitBox(420, 144, 28, 48, translucent, false);
	public hitBox wall10 = new hitBox(420, 192, 28, 48, translucent, false);
	public hitBox wall11 = new hitBox(420, 240, 28, 48, translucent, false);
	

	
	public hitBox wall12 = new hitBox(100, 250, 48, 28, translucent, false);
	public hitBox wall13 = new hitBox(148, 250, 48, 28, translucent, false);
	public hitBox wall14 = new hitBox(196, 250, 48, 28, translucent, false);
	public hitBox wall15 = new hitBox(244, 250, 48, 28, translucent, false);
	
	
	public hitBox wall16 = new hitBox(400, 298, 48, 28, translucent, false);
	public hitBox wall17 = new hitBox(448, 298, 48, 28, translucent, false);
	public hitBox wall18 = new hitBox(496, 298, 48, 28, translucent, false);
	
	
	
	
	
//	g2.drawImage(background[1].getImage(), 400, 96, panel.getTileSize(), panel.getTileSize(), null);
//	g2.drawImage(background[1].getImage(), 400, 144, panel.getTileSize(), panel.getTileSize(), null);
//	g2.drawImage(background[1].getImage(), 400, 192, panel.getTileSize(), panel.getTileSize(), null);
//	g2.drawImage(background[1].getImage(), 400, 240, panel.getTileSize(), panel.getTileSize(), null);
//	g2.drawImage(background[1].getImage(), 400, 288, panel.getTileSize(), panel.getTileSize(), null);
	
	
	
	
	
	
//	g2.drawImage(background[2].getImage(), 300, 438, panel.getTileSize(), panel.getTileSize(), null);
//	g2.drawImage(background[2].getImage(), 348, 438, panel.getTileSize(), panel.getTileSize(), null);
	
//	g2.drawImage(background[1].getImage(), 520, 500, panel.getTileSize(), panel.getTileSize(), null);
//	g2.drawImage(background[1].getImage(), 520, 548, panel.getTileSize(), panel.getTileSize(), null);
//	g2.drawImage(background[1].getImage(), 520, 596, panel.getTileSize(), panel.getTileSize(), null);
	// end of map walls

	

	character character;
	

	
	public backgroundManager(gamePanel panel) {
		this.panel = panel;
		background = new background[10];
		getTileImage();
		
	//	wall[0] = new hitBox(192, 480, 48, 48, translucent, false);
	
	}
	

	// create individual tile images and assign images to them
	public void getTileImage() {
		
		background[0] = new background();
		background[1] = new background();
		background[2] = new background();
		
		try {
			
			background[0].setImage(ImageIO.read(getClass().getResourceAsStream("/map/wall.png")));
			background[0].setIsSolid(true);
			
			background[1].setImage(ImageIO.read(getClass().getResourceAsStream("/map/verticalmapwall.png")));
			background[1].setIsSolid(true);
			
			background[2].setImage(ImageIO.read(getClass().getResourceAsStream("/map/horizontalmapwall.png")));
			background[2].setIsSolid(true);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	// draws graphics to screen
	public void draw(Graphics2D g2) {
		
		
		
		// draw border wall
		while (x < panel.getScreenWidth()) {
			
			g2.drawImage(background[0].getImage(), x, y, panel.getTileSize(), panel.getTileSize(), null);
			x += panel.getTileSize();
			
			
			if (x == panel.getScreenWidth()) {
				x = panel.getScreenWidth() - (panel.getTileSize() + 10);
				
				break;
			}	
			
			}
			
			
			while (y < panel.getScreenHeight()) {
				
				g2.drawImage(background[0].getImage(), x - 3, y, panel.getTileSize(), panel.getTileSize(), null);
				y += panel.getTileSize();
				
				
				if (y == panel.getScreenHeight()) {
					y = panel.getScreenHeight() - (panel.getTileSize() - 10);
					
					break;
				}
				
				
			}
			
			
			y -= panel.getTileSize();
			while ( x > 0 && y == 730 - panel.getTileSize()) {
				
				g2.drawImage(background[0].getImage(), x, y, panel.getTileSize(), panel.getTileSize(), null);
				x -= panel.getTileSize();
				
				if (x < 0) {
					g2.drawImage(background[0].getImage(), -10, y, panel.getTileSize(), panel.getTileSize(), null);
				
					break;
				}
			}
			

			while ( y > 0 && x < 0) {
				
				g2.drawImage(background[0].getImage(), x + 10, y, panel.getTileSize(), panel.getTileSize(), null);
				y -= panel.getTileSize();
				}
			    // end of border wall
			
			// resetting vars below may be why projectiles dont take x , y co-ords. keeps resetting
			
			y = 0;
			x = 0;
			
			// draw map walls
			g2.drawImage(background[1].getImage(), 192, 480, panel.getTileSize(), panel.getTileSize(), null);
			g2.drawImage(background[1].getImage(), 192, 528, panel.getTileSize(), panel.getTileSize(), null);
			g2.drawImage(background[1].getImage(), 192, 576, panel.getTileSize(), panel.getTileSize(), null);
			

			g2.drawImage(background[1].getImage(), 410, 96, panel.getTileSize(), panel.getTileSize(), null);
			g2.drawImage(background[1].getImage(), 410, 144, panel.getTileSize(), panel.getTileSize(), null);
			g2.drawImage(background[1].getImage(), 410, 192, panel.getTileSize(), panel.getTileSize(), null);
			g2.drawImage(background[1].getImage(), 410, 240, panel.getTileSize(), panel.getTileSize(), null);
	//		g2.drawImage(background[1].getImage(), 400, 288, panel.getTileSize(), panel.getTileSize(), null);
			
			
			g2.drawImage(background[2].getImage(), 100, 240, panel.getTileSize(), panel.getTileSize(), null);
			g2.drawImage(background[2].getImage(), 148, 240, panel.getTileSize(), panel.getTileSize(), null);
			g2.drawImage(background[2].getImage(), 196, 240, panel.getTileSize(), panel.getTileSize(), null);
			g2.drawImage(background[2].getImage(), 244, 240, panel.getTileSize(), panel.getTileSize(), null);
			
			
			g2.drawImage(background[2].getImage(), 400, 288, panel.getTileSize(), panel.getTileSize(), null);
			g2.drawImage(background[2].getImage(), 448, 288, panel.getTileSize(), panel.getTileSize(), null);
			g2.drawImage(background[2].getImage(), 496, 288, panel.getTileSize(), panel.getTileSize(), null);
			
			
			g2.drawImage(background[2].getImage(), 300, 438, panel.getTileSize(), panel.getTileSize(), null);
			g2.drawImage(background[2].getImage(), 348, 438, panel.getTileSize(), panel.getTileSize(), null);
			
			
			g2.drawImage(background[1].getImage(), 520, 500, panel.getTileSize(), panel.getTileSize(), null);
			g2.drawImage(background[1].getImage(), 520, 548, panel.getTileSize(), panel.getTileSize(), null);
			g2.drawImage(background[1].getImage(), 520, 596, panel.getTileSize(), panel.getTileSize(), null);
			// end of map walls
			
			
			// using built in methods ro ensure hitboxes are correct size, in right position
			
			
			
			
			
			
			
			wall0.setSize(28, 48);
			wall0.setLocation(202, 480);
							
			wall1.setSize(28, 48);
			wall1.setLocation(202, 528);
								
			wall2.setSize(28, 48);
			wall2.setLocation(202, 576);
			
			
			
			wall3.setSize(28, 48);
			wall3.setLocation(530, 500);
						
			wall4.setSize(28, 48);
			wall4.setLocation(530, 548);
						
			wall5.setSize(28, 48);
			wall5.setLocation(530, 596);
			
						
			
			wall6.setSize(48, 28);
			wall6.setLocation(300, 448);
						
			wall7.setSize(48, 28);
			wall7.setLocation(348, 448);
			
			
	
			wall8.setSize(28, 48);
			wall8.setLocation(420, 96);
			
			wall9.setSize(28, 28);
			wall9.setLocation(420, 144);
			
			wall10.setSize(28, 28);
			wall10.setLocation(420, 192);
			
			wall11.setSize(28, 28);
			wall11.setLocation(420, 240);
			
			
			
			
			wall12.setSize(48, 28);
			wall12.setLocation(100, 250);
			
			wall13.setSize(48, 28);
			wall13.setLocation(148, 250);
			
			wall14.setSize(48, 28);
			wall14.setLocation(196, 250);
	
			wall15.setSize(48, 28);
			wall15.setLocation(244, 250);
			
			
			
		//	public hitBox wall16 = new hitBox(400, 288, 48, 28, translucent, false);
		//	public hitBox wall17 = new hitBox(448, 288, 48, 28, translucent, false);
		//	public hitBox wall18 = new hitBox(496, 288, 48, 28, translucent, false);
			
		
			
			wall16.setSize(48, 28);
			wall16.setLocation(400, 298);	
			
			wall17.setSize(48, 28);
			wall17.setLocation(448, 298);
			
			wall18.setSize(48, 28);
			wall18.setLocation(496, 298);
						
					
				
			wall0.draw(g2);
			wall1.draw(g2);
			wall2.draw(g2);
			wall3.draw(g2);
			wall4.draw(g2);
			wall5.draw(g2);
			wall6.draw(g2);
			wall7.draw(g2);
			wall8.draw(g2);
			wall9.draw(g2);
			wall10.draw(g2);
			wall11.draw(g2);
			wall12.draw(g2);
			wall13.draw(g2);
			wall14.draw(g2);
			wall15.draw(g2);
			wall16.draw(g2);
			wall17.draw(g2);
			wall18.draw(g2);
			
		}


	
	
		
	}
	


