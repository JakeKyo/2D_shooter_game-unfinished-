package main;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import character.character;
import menu.escapeMenu;
import objects.leftClickShoot;

public class mouseHandler implements MouseListener {

	public boolean leftMouseClicked;
	gamePanel panel;
	character character;
	escapeMenu menu;
	
	mouseHandler (gamePanel panel) {
		this.panel = panel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	//	if (e.getButton() == MouseEvent.BUTTON1) {
	//		leftMouseClicked = true;
			
			
	//	}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		if (e.getButton() == MouseEvent.BUTTON1) {
			leftMouseClicked = true;
	//		panel.attackone.set(panel.attackone.getMapDirection(), character.getX(), character.getY(), true);
	//		System.out.println(character.getX());
			
		}
		
		if (escapeMenu.getMenuInUse() == true) {
			
				// how to check if mouse is clicked on a string / shape drawn in graphics2d class??
			if (panel.menu.fpsoval.contains(e.getPoint())) {
				
				panel.menu.setSelectedNum(0);
				
				if (panel.menu.getFpsToggle() == false) {
					panel.menu.setFpsToggle(true);
				}
				
				else if  (panel.menu.getFpsToggle() == true) {
					panel.menu.setFpsToggle(false);
				}
			}
			
			
			if (panel.menu.sfxrectangle.contains(e.getPoint())) {
			
			
				panel.menu.setSelectedNum(1);
				
				Point sfxcoord = e.getPoint();
				System.out.println((int) sfxcoord.getX() - 320);
				panel.menu.setSfxVolume( (int) sfxcoord.getX() - 320);
				
		}
			
		
			if (panel.menu.musicrectangle.contains(e.getPoint())) {
				
				
				panel.menu.setSelectedNum(2);
				
				Point musiccoord = e.getPoint();
				System.out.println((int) musiccoord.getX() - 320);
				panel.menu.setMusicVolume( (int) musiccoord.getX() - 320);
		
		
		}
			
			
			if (panel.menu.quitrectangle.contains(e.getPoint())) {
				
				panel.menu.setSelectedNum(3);
				
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
			
			
			if (panel.menu.backrectangle.contains(e.getPoint())) {
				panel.key.menuclick = false;
			}
		
		}
			
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}
		
	

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}

	
}
