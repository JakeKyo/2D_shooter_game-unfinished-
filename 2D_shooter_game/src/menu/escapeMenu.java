package menu;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JWindow;
import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

import main.gamePanel;
import main.keyHandler;

public class escapeMenu  {
	

	
	gamePanel panel;
	keyHandler key;
	private static boolean menuinuse = false;
	private int selectednum = 0;
	private boolean fpstoggle;
	private int sfxvolume, musicvolume;
	
	public Ellipse2D.Double fpsoval;
	public Rectangle sfxrectangle;
	public Rectangle musicrectangle;
	public Rectangle quitrectangle;
	public Rectangle backrectangle;
	
	public escapeMenu (gamePanel panel, keyHandler key) {
		this.panel = panel;
		this.key = key;
	
	}
	
	
	public void update () {

		if (key.menuclick == true) {
			menuinuse = true;
			
		}
		else if (key.menuclick == false) {
			menuinuse = false;
		}

	}
	
	
	public void drawwindow (Graphics2D g2, int x, int y, int width, int height) {
		
		
		Color menuback = new Color(0, 0, 0, 210);
		g2.setColor(menuback);
		g2.fillRoundRect(x, y, width, height, 35, 35);
		
		menuback = new Color(255, 255, 255);
		g2.setColor(menuback);
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
		
	}
	
	
	public void drawescapemenu (Graphics2D g2) {
		
		g2.setColor(Color.WHITE);
		g2.setFont(g2.getFont().deriveFont(32F));
		
		
		// window
		
		int x = 160;
		int y = 90;
		int width = 450;
		int height = 550;
		drawwindow (g2, x, y, width, height) ;
	
		
		String menuheader = "Game Menu";
		String navigationtext = "Menu supports mouse and keyboard control.";
		String navigationtext2 = "Use arrow keys/enter for keyboard navigation.";
		int headerx= 300;
		int headery = 140;
		g2.drawString(menuheader, headerx, headery);
		g2.setFont(g2.getFont().deriveFont(20F));
		g2.drawString(navigationtext, headerx - 110, headery + 30);
		g2.drawString(navigationtext2, headerx - 110, headery + 55);
		g2.setFont(g2.getFont().deriveFont(32F));
		
		String fpstext = "FPS";
		String sfxtext = "SFX";
		String musictext = "Music";
		String quittext = "Quit";
		String backtext = "Back";
		
		g2.drawString(fpstext, 200, 270);
		g2.drawOval(350, 240, 40, 40);
		fpsoval = new Ellipse2D.Double(350, 240, 40, 40);
		if (selectednum == 0) {
			g2.drawString(">", 180, 270);
			if (fpstoggle == true) {
				g2.fillOval(350, 240, 40, 40);
			}
		}
		
		if (fpstoggle == true) {
			g2.fillOval(350, 240, 40, 40);
			
		}
		
		
		g2.drawString(sfxtext, 200, 345);
		g2.drawRect(320, 315, 200, 40);
		sfxrectangle = new Rectangle (320, 315, 200, 40);
		sfxrectangle.add(340, 315);
		if (selectednum == 1) {
			g2.drawString(">", 180, 345);
			if (sfxvolume == 20) {
				g2.fillRect(320, 315, 20, 40);
			}
			else if (sfxvolume == 40) {
				g2.fillRect(320, 315, 40, 40);
			}
			else if (sfxvolume == 60) {
				g2.fillRect(320, 315, 60, 40);
			}
			else if (sfxvolume == 80) {
				g2.fillRect(320, 315, 80, 40);
			}
			else if (sfxvolume == 100) {
				g2.fillRect(320, 315, 100, 40);
			}
			else if (sfxvolume == 120) {
				g2.fillRect(320, 315, 120, 40);
			}
			else if (sfxvolume == 140) {
				g2.fillRect(320, 315, 140, 40);
			}
			else if (sfxvolume == 160) {
				g2.fillRect(320, 315, 160, 40);
			}
			else if (sfxvolume == 180) {
				g2.fillRect(320, 315, 180, 40);
			}
			else if (sfxvolume == 200) {
				g2.fillRect(320, 315, 200, 40);
			}
		}
		g2.fillRect(320, 315, sfxvolume, 40);
		
		
		g2.drawString(musictext, 200, 420);
		g2.drawRect(320, 390, 200, 40);
		musicrectangle = new Rectangle (320, 390, 200, 40);
		if (selectednum == 2) {
			g2.drawString(">", 180, 420);

			if (musicvolume == 20) {
				g2.fillRect(320, 390, 20, 40);
			}
			else if (musicvolume == 40) {
				g2.fillRect(320, 390, 40, 40);
			}
			else if (musicvolume == 60) {
				g2.fillRect(320, 390, 60, 40);
			}
			else if (musicvolume == 80) {
				g2.fillRect(320, 390, 80, 40);
			}
			else if (musicvolume == 100) {
				g2.fillRect(320, 390, 100, 40);
			}
			else if (musicvolume == 120) {
				g2.fillRect(320, 390, 120, 40);
			}
			else if (musicvolume == 140) {
				g2.fillRect(320, 390, 140, 40);
			}
			else if (musicvolume == 160) {
				g2.fillRect(320, 390, 160, 40);
			}
			else if (musicvolume == 180) {
				g2.fillRect(320, 390, 180, 40);
			}
			else if (musicvolume == 200) {
				g2.fillRect(320, 390, 200, 40);
			}
		}
		g2.fillRect(320, 390, musicvolume, 40);
		
		
		g2.drawString(quittext, 200, 495);
		quitrectangle = new Rectangle (195, 465, 70, 35);
		if (selectednum == 3) {
			g2.drawString(">", 180, 495);
		}
		
		g2.drawString(backtext, 200, 610);
		backrectangle = new Rectangle (198, 580, 80, 37);
		if (selectednum == 4) {
			g2.drawString(">", 180, 610);
		}
		
//		drawfps(g2);
		
		
	}
	
	
	public void drawfps (Graphics2D g2) {
		if (fpstoggle == true ) {
			g2.setColor(Color.RED);
			g2.setFont(g2.getFont().deriveFont(50F));
			g2.drawString(Long.toString(panel.getLastFps()), 610, 100);
		}
	}
	
	
	public static boolean getMenuInUse () {
		return menuinuse;
	}
	
	public static void setMenuInUse (boolean val) {
		menuinuse = val;
	}
	
	public int getSelectedNum () {
		return selectednum;
	}
	
	public void increaseSelectedNum () {
		selectednum ++;
		if (selectednum > 4) {
			selectednum = 0;
		}
	}
	
	public void decreaseSelectednNum () {
		selectednum --;
		if (selectednum < 0) {
			selectednum = 4;
		}
	}
	
	public void setSelectedNum (int num) {
		this.selectednum = num;
	}
	
	public void setFpsToggle (boolean val) {
		this.fpstoggle = val;
	}
	
	public boolean getFpsToggle () {
		return this.fpstoggle;
	}
	
	public void setSfxVolume (int vol) {
		this.sfxvolume = vol;
	}
	
	public int getSfxVolume () {
		return this.sfxvolume;
	}
	
	public void setMusicVolume (int vol) {
		this.musicvolume = vol;
	}
	
	public int getMusicVolume () {
		return this.musicvolume;
	}
	

}
