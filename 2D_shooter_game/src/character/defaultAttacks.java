package character;

import java.awt.Color;
import java.awt.Graphics2D;

import main.gamePanel;
import main.keyHandler;
import main.mouseHandler;
import map.backgroundManager;
import map.hitBox;
import objects.leftClickShoot;

public class defaultAttacks extends character {
	
	private String name;
	private int firespeed;
	private int range;
	private int damage;
	private boolean alive = false;
	String mapdirection = "right";
	
	private int mapx;
	private int mapy;
	
	
	
	
	Color translucent = new Color(1f,0f,0f,.0f );	// custom col for hitbox - change last param to set opacity.
	public hitBox attackhitbox;
	
	

	public defaultAttacks (gamePanel panel, mouseHandler mouse, keyHandler key, backgroundManager manager) {
		super(panel, key, mouse, manager);
		this.panel = panel;
		this.mouse = mouse;
		this.key = key;
		this.manager = manager;
		
		
		attackhitbox = new hitBox(this.mapx, this.mapy, 48, 48, translucent, false);
		attackhitbox.setSize(48, 48);
		attackhitbox.setLocation(mapx, mapy);
		
	}
	
	
	public void set (String direction, int mapx, int mapy, boolean alive) {
		this.direction = direction;
	//	this.mapx = mapx;
		this.mapy = mapy;
		this.alive = alive;
		
	}
	
	
	public void setName (String name) {
		this.name = name;
	}
	
	
	
	public void setFireSpeed (int speed) {
		this.firespeed = speed;
	}
	
	
	public void setRange (int range) {
		this.range = range;
	}
	
	
	public void setDamage (int damage) {
		this.damage = damage;
	}
	
	public  int getDamage() {
		return damage;
	}
	
	
	
	public void update () {
		

		collisionchecker();
		
		if (panel.mouse.leftMouseClicked == false) {
			mapx = panel.character.getX();
			mapy = panel.character.getY();
			
		}
		
		if (panel.mouse.leftMouseClicked == true) {
			setAlive(true);
			
		}
		

	}
	
	
	public void draw (Graphics2D g2) {
		
		
		if (panel.mouse.leftMouseClicked == true && mapdirection.equals("right")) {
			
			
			mapdirection = "right";
			attackhitbox.setLocation(mapx++, mapy);
			g2.drawImage(((objects.leftClickShoot) panel.attackone).getImage(), mapx++, this.mapy, 48, 48, null);
			
			panel.attackone.range--;
			
			if (panel.attackone.range < 0) {
				panel.attackone.setAlive(false);
				mapx = -200;
				panel.mouse.leftMouseClicked = false;
				setRange(200);
			}
		}
		
		else if (panel.mouse.leftMouseClicked == true && mapdirection.equals("left")) {
			mapdirection = "left"
;			attackhitbox.setLocation(mapx--, mapy);
			g2.drawImage(((objects.leftClickShoot) panel.attackone).getImage(), this.mapx--, this.mapy, 48, 48, null);
		
			panel.attackone.range--;
			
			if (panel.attackone.range < 0) {
				panel.attackone.setAlive(false);
				mapx = -200;
				panel.mouse.leftMouseClicked = false;
				setRange(200);
			}
		}
		
		else if (panel.mouse.leftMouseClicked == true && mapdirection.equals("up")) {
			mapdirection = "up";
			attackhitbox.setLocation(mapx, mapy--);
			g2.drawImage(((objects.leftClickShoot) panel.attackone).getImage(), this.mapx, this.mapy--, 48, 48, null);
		
			panel.attackone.range--;
			
			if (panel.attackone.range < 0) {
				panel.attackone.setAlive(false);
				mapx = -200;
				panel.mouse.leftMouseClicked = false;
				setRange(200);
			}
		}
		
		else if (panel.mouse.leftMouseClicked == true && mapdirection.equals("down")) {
			mapdirection = "down";
			attackhitbox.setLocation(mapx, mapy++);
			g2.drawImage(((objects.leftClickShoot) panel.attackone).getImage(), this.mapx, this.mapy++, 48, 48, null);
		
			panel.attackone.range--;
			
			if (panel.attackone.range < 0) {
				panel.attackone.setAlive(false);
				mapx = -200;
				panel.mouse.leftMouseClicked = false;
				setRange(200);
			}
		
		}
		
	}
	
	
	public void collisionchecker () {
		
		if (mapx < 48) {
			mapx = -2000;
		}
		
		if (mapx > 660) {
			mapx = -2000;
		}
		
		if (mapy < 48) {
			mapx = -2000;
		}
		
		if (mapy > 640) {
			mapx = -2000;
		}
		
		if (attackhitbox.intersects(manager.wall0) || attackhitbox.intersects(manager.wall1) || attackhitbox.intersects(manager.wall2) || attackhitbox.intersects(manager.wall3) || attackhitbox.intersects(manager.wall4) || attackhitbox.intersects(manager.wall5) || attackhitbox.intersects(manager.wall6) || attackhitbox.intersects(manager.wall7) || attackhitbox.intersects(manager.wall8) || attackhitbox.intersects(manager.wall9) || attackhitbox.intersects(manager.wall10) || attackhitbox.intersects(manager.wall11) || attackhitbox.intersects(manager.wall12) || attackhitbox.intersects(manager.wall13) || attackhitbox.intersects(manager.wall14) || attackhitbox.intersects(manager.wall15) || attackhitbox.intersects(manager.wall16) || attackhitbox.intersects(manager.wall17) || attackhitbox.intersects(manager.wall18)) {
			mapx = -2000;
			
		}
		
		
		if (attackhitbox.intersects(panel.enemy.enemyhitbox)) {
		//	System.out.println("Ouchh im deaddddd");
			panel.enemy.decreaseHealth(damage);
			System.out.println(panel.enemy.getHealth());
			
	//		panel.enemy.setX(-2000);
			mapx = -3000;
		}
		
		
		
	}
	
	
	public Boolean getAlive () {
		return alive;
	}
	
	
	public void setAlive (Boolean alive) {
		this.alive = alive;
	}
	
	
	public String getMapDirection () {
		return mapdirection;
	}
	
	
	public void setMapX (int mapx) {
		this.mapx = mapx;
	}
	
	
	public void setMapY (int mapy) {
		this.mapy = mapy;
	}
	
}
