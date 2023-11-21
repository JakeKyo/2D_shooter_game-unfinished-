package Sound;



import main.gamePanel;
import menu.escapeMenu;





public class backgroundMusic {
	
	gamePanel panel;
	escapeMenu menu;
	
	int volume = panel.menu.getSfxVolume();
	
	
	backgroundMusic (gamePanel panel, escapeMenu menu) {
		this.panel = panel;
		this.menu = menu;
	}
	
	
	public void getMusic (String file) {
		
		
	}

}
