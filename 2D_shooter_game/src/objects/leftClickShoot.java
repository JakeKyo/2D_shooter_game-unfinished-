package objects;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import character.defaultAttacks;
import main.gamePanel;
import main.keyHandler;
import main.mouseHandler;
import map.backgroundManager;

public class leftClickShoot extends defaultAttacks {
	
	
	gamePanel panel;
	keyHandler key;
	mouseHandler mouse;
	defaultAttacks defaultAttacks;
	private BufferedImage image;
	
	
	
	
	public leftClickShoot (gamePanel panel, mouseHandler mouse, keyHandler key, backgroundManager manager, int damage) {
		super(panel, mouse, key, manager);
		this.panel = panel;
		this.mouse = mouse;
		this.key = key;
		setDamage(damage);
		
		
		setName("Default long range");
		setFireSpeed(10);
		setImage();
		setRange(200);
		setDamage(100);
		
		
	}
	
	
	public void setImage () {
		
		try {
			 image = ImageIO.read(getClass().getResourceAsStream("/attacks/leftClick.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public BufferedImage getImage () {
		return image;
	}

}
