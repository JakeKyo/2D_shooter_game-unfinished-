package main;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {
	
	
	private JFrame mainframe = new JFrame();
	gamePanel panel = new gamePanel();
	windowHandler window = new windowHandler();



	public Main () {
		

		mainframe.add(panel);
		mainframe.addWindowListener(window);
		mainframe.setDefaultCloseOperation(0);
		mainframe.setMinimumSize(new Dimension(panel.screenwidth, panel.screenheight));
		mainframe.setResizable( false );
		mainframe.setLocationRelativeTo( null );
		mainframe.setTitle( "PacMan (by Jake)" );
		mainframe.getContentPane().setBackground(Color.BLACK); 
		mainframe.pack();
		mainframe.setVisible(true);
		
		
	}
	
	


	public static void main(String[] args) {
		
		
		Main Main = new Main();
		


	}}
