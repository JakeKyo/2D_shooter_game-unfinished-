package main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import character.character;

import character.defaultAttacks;
import enemy.enemy;
import map.backgroundManager;
import menu.escapeMenu;
import objects.bomb;
import objects.leftClickShoot;


/**
 * @author kntjk
 *
 */
public class gamePanel extends JPanel implements Runnable {
	
	

	// setup individual tile sizes and window sizes.
	 final int originaltilesize = 16;
	 final int scale = 3;
	 
	 final int tilesize = originaltilesize * scale;
	 final int maxscreencol = 16;
	 final int maxscreenrow = 16;
	 final int screenwidth = tilesize * maxscreencol;
	 final int screenheight = tilesize * maxscreenrow;
	 
	 
	 int fps = 60; // change me to set FPS - Higher the value, the smoother
	 long lastfps;

	 
	 Thread mainthread;
	 

	 BufferedImage pacmanimage;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// creating objects
	public mouseHandler mouse = new mouseHandler(this);
	backgroundManager manager = new backgroundManager(this);
	public keyHandler key = new keyHandler(this);
	public character character = new character(this, key, mouse, manager);
//	public collision collision = new collision(this, manager, character);
	public defaultAttacks attackone = new leftClickShoot(this, mouse, key, manager, 100);
//	defaultAttacks defaultAttacks = new defaultAttacks(this, mouse, key);
	public enemy enemy = new enemy(this, manager, character, 600, 400, 200);
//	public enemy enemy = new enemy(this, manager, character, 600, 300, 200);
	
	public bomb bomb = new bomb(this, character, manager);
	public escapeMenu menu = new escapeMenu(this, key);
	
	
	
	public gamePanel() {
		
		
		setDoubleBuffered(true);
		setBackground(Color.BLACK);;
		setVisible(true);
		addKeyListener(key);
		setFocusable(true);
		startgame();
		addMouseListener(mouse);
		
	 }
	
	// start game thread - starts game
	public void startgame() {
		mainthread = new Thread(this);
		mainthread.start();
	}
	
	// creates a game loop at specific FPS
//	public void run() {
//		
//		 
//	    int fps = 120; // change me to set FPS - Higher the value, the smoother
//		double interval = 1000000000 / fps;
//		double drawtime = System.nanoTime() + interval;
//		
//		
//		while (mainthread != null) {
//			
//			update();
//			repaint();
//			
//			
//			try {
//				double remaingtime = drawtime - System.nanoTime();
//				remaingtime = remaingtime / 1000000;
//				
//				
//				if (remaingtime < 0) {
//					remaingtime = 0;
//				}
//				
//				Thread.sleep((long) remaingtime);
//				
//				drawtime += interval;
//				
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		//	System.out.println("Game thread is running!!");
//			
//		}
// 		
//	}
	
	
	public void run() {
		
		 

		double interval = 1000000000 / fps;
		double delta = 0;
		long lasttime = System.nanoTime();
		long currenttime;
		long timer = 0;
		long drawcount = 0;
		
		
		while (mainthread != null) {
			
			currenttime = System.nanoTime();
			
			delta += (currenttime - lasttime) / interval;
			timer += (currenttime - lasttime);
			lasttime = currenttime;
			
			if (delta >= 1) {
				update();
				repaint();
				delta--;
				drawcount++;
			}
			
			if (timer >= 1000000000) {
				System.out.println("Current FPS: " + drawcount);
				lastfps = drawcount;
				drawcount = 0;
				timer = 0;
			}
				
		}
		
	}
	
	
	public void update() {
		
		character.update();
		attackone.update();
		enemy.update();
	//	enemy1.update();
		bomb.update();
		menu.update();
		
		
	}
	
	
	// creates graphical objects on screen
	public void paintComponent (Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g; 

		manager.draw(g2);
		character.draw(g2);
		attackone.draw(g2);
		enemy.draw(g2);
//		enemy1.draw(g2);
		bomb.draw(g2);
		
		
		if (escapeMenu.getMenuInUse() == true) {
			menu.drawescapemenu(g2);
		}
		
		if (menu.getFpsToggle() == true) {
			menu.drawfps(g2);
		}
		
		

		g2.dispose();
	
}
	
	
	public int getTileSize() {
		return this.tilesize;
	}

	
	public int getScreenWidth() {
		return this.screenwidth;
	}
	
	
	public int getScreenHeight() {
		return this.screenheight;
	}
	
	
	public long getLastFps () {
		return this.lastfps;
	}

}
