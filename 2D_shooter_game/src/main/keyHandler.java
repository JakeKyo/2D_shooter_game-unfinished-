package main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import menu.escapeMenu;


// key handler to take keyboard inputs for the games UI
public class keyHandler implements KeyListener {

	public boolean uppress, leftpress, downpress, rightpress;
	public boolean menuclick;
	private boolean enterclick, enterrelease;
	private boolean bombattack;
	
	gamePanel panel;
	
	public keyHandler (gamePanel panel) {
		this.panel = panel;
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_W) {
			uppress = true;
			
			
		}
		else if (code == KeyEvent.VK_A) {
			leftpress = true;
			
		}
		else if (code == KeyEvent.VK_S) {
			downpress = true;
			
		}
		else if (code == KeyEvent.VK_D) {
			rightpress = true;
			
		}
		
		if (code == KeyEvent.VK_ESCAPE && menuclick == false) {
			
			menuclick = true;
		}
		else if (code == KeyEvent.VK_ESCAPE && menuclick == true) {
			menuclick = false;
		}
		
		if (escapeMenu.getMenuInUse() == true) {
			
			if (code == KeyEvent.VK_DOWN) {
				panel.menu.increaseSelectedNum();
			}
			
			if (code == KeyEvent.VK_UP) {
				panel.menu.decreaseSelectednNum();
				
			}
			
			if (code == KeyEvent.VK_ENTER && enterclick == false && panel.menu.getSelectedNum() == 0) {
				enterclick = true;
				panel.menu.setFpsToggle(true);
			}
			
			else if (code == KeyEvent.VK_ENTER && enterclick == true && panel.menu.getSelectedNum() == 0) {
				panel.menu.setFpsToggle(false);
				enterclick = false;
			}
			
			if (code == KeyEvent.VK_RIGHT && panel.menu.getSelectedNum() == 1) {
				panel.menu.setSfxVolume(panel.menu.getSfxVolume() + 20);
				if (panel.menu.getSfxVolume() > 200 ) {
					panel.menu.setSfxVolume(200);
				}
		}
			
			
			if (code == KeyEvent.VK_LEFT && panel.menu.getSelectedNum() == 1) {
				panel.menu.setSfxVolume(panel.menu.getSfxVolume() - 20);
				if (panel.menu.getSfxVolume() < 0 ) {
					panel.menu.setSfxVolume(0);
						
					}
				
			}
			
			if (code == KeyEvent.VK_RIGHT && panel.menu.getSelectedNum() == 2) {
				panel.menu.setMusicVolume(panel.menu.getMusicVolume() + 20);
				if (panel.menu.getMusicVolume() > 200 ) {
					panel.menu.setMusicVolume(200);
				}
		}
			
			if (code == KeyEvent.VK_LEFT && panel.menu.getSelectedNum() == 2) {
				panel.menu.setMusicVolume(panel.menu.getMusicVolume() - 20);
				if (panel.menu.getMusicVolume() < 0 ) {
					panel.menu.setMusicVolume(0);
						
					}
				
			}
			
			if (code == KeyEvent.VK_ENTER && panel.menu.getSelectedNum() == 3) {
				
				String [] buttons = {"Yes", "No"};

				int optionpane = JOptionPane.showOptionDialog(null,
				   "Do you really want to close application?",
				   null, JOptionPane.WARNING_MESSAGE,
				   0,
				   null,
				   buttons,
				   buttons[1]);
				
				if (optionpane == 0) {
					System.exit(0);;
				}
				
		}
			
			if (code == KeyEvent.VK_ENTER && panel.menu.getSelectedNum() == 4) {
				menuclick = false;
				panel.menu.setSelectedNum(0);
			}
	}
			
		
		if (code == KeyEvent.VK_E && panel.bomb.getPickedUp() == true) {
			
			bombattack = true;
		}
		
	}

	
	@Override
	public void keyReleased(KeyEvent e) {
		
	int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_W) {
			uppress = false;
		}
		else if (code == KeyEvent.VK_A) {
			leftpress = false;
		}
		else if (code == KeyEvent.VK_S) {
			downpress = false;
		}
		else if (code == KeyEvent.VK_D) {
			rightpress = false;
		}
		else if (code == KeyEvent.VK_E) {
			bombattack = false;
		}
		
		
	}
	
	
	public boolean getEnterClick () {
		return this.enterclick;
	}
	
	public boolean getReleaseClick () {
		return this.enterrelease;
	}
	
	public boolean getBombAttack () {
		return this.bombattack;
	}

}
