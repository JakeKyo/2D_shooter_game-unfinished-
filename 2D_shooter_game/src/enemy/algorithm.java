package enemy;

import character.character;
import main.gamePanel;

public class algorithm {
	
//	character character;
//	gamePanel panel;
//	
////	private int currentx = 600;
////	private int currenty = 600;
//	
//	private double uppercentage;
//	private double downpercentage;
//	private double leftpercentage;
//	private double rightpercentage;
//	
//	public algorithm () {
//		
//	}
//	
//	
//	// check direction of character and how much map is left in direction to help predict movement / cutoff
//	// take into account any pickupable object / where the most pickupable objects are in the map/ higher weighting towards them areas. 
//	
//	public void movetocharacter (gamePanel panel, character character, int x, int y, int speed) {
//		
//		if (panel.character.getX() < x) {
//			panel.enemy.setX(panel.enemy.getX() - speed);
//			
//			panel.enemy.enemyhitbox.movebox(x, y);
//			panel.enemy.enemyhitbox.setLocation(x, y);
//			panel.enemy.enemyhitbox.setBounds(x, y, 48, 48);
//		}
//		
//		if (panel.character.getX() > x) {
//			panel.enemy.setX(panel.enemy.getX() + speed);
//			
//			panel.enemy.enemyhitbox.movebox(x, y);
//			panel.enemy.enemyhitbox.setLocation(x, y);
//			panel.enemy.enemyhitbox.setBounds(x, y, 48, 48);
//		}
//		
//		if (panel.character.getY() < y) {
//			panel.enemy.setY(panel.enemy.getY() - speed);
//			
//			panel.enemy.enemyhitbox.movebox(x, y);
//			panel.enemy.enemyhitbox.setLocation(x, y);
//			panel.enemy.enemyhitbox.setBounds(x, y, 48, 48);
//			
//		}
//		
//		if (panel.character.getY() > y) {
//			panel.enemy.setY(panel.enemy.getY() + speed);
//			
//			panel.enemy.enemyhitbox.movebox(x, y);
//			panel.enemy.enemyhitbox.setLocation(x, y);
//			panel.enemy.enemyhitbox.setBounds(x, y, 48, 48);
//		}
//		
//		if (panel.enemy.enemyhitbox.intersects(panel.character.characterhitbox)) {
//			System.out.println("you caught meee!!!");
//		}
//		
//	}
//	
//	
//	public void movewithpercentage (gamePanel panel, character character, int x, int y, int speed, String direction) {
//		
//		if (panel.character.getX() < panel.enemy.getX() && direction.equals("left") && panel.character.getY() < panel.enemy.getY()) {
//			
//			panel.enemy.setX(x -= speed); 
//			panel.enemy.setY(y -= speed); 
//		}
//	}
//	
//

}
