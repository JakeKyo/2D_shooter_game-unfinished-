package objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import character.character;
import main.gamePanel;
import map.backgroundManager;

public interface collectable {

	
	
	
	void setImage (String path);
	
	void setRandomPosition (int lowx, int highx, int lowy, int highy);
	
	void update ();
	
	
	void randomtime ();

	void draw (Graphics2D g2);
	
	void collisionchecker (gamePanel panel, character character, backgroundManager manager);

	
	
}
