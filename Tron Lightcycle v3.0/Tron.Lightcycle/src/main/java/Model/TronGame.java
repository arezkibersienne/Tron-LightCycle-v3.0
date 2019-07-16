package Model;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TronGame extends JPanel{
	/**
	 * 
	 * @author Arezki Ibersienne
	 * @category Jave 2D game
	 */
	
	// declare all instance variables  
		  private Cycle player = new Cycle();
		  private Cycle player2 = new Cycle();
		  private int spawn = 0; //used for spawn
		  private int frameCount;// used for the score
		  private static String title = "Tron : LightCycle v3.0";
		  private Timer timer;// handles animation
		  private static Image offScreenBuffer;// needed for double buffering graphics
		  private Graphics offScreenGraphics;// needed for double buffering graphics

	
	 /**
	 * main() is needed to initialize the window.<br>
	 */
	 public static void main(String[] args) {
		 JFrame window = new JFrame(title);
		 window.setSize(new Dimension(600 , 600));
	   //window.setBounds(0, 0, 600, 400);// window size
	 	 window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 window.setResizable(false);
		 window.setLocationRelativeTo(null);

		 TronGame game = new TronGame();
		 window.getContentPane().add(game);
		 window.setBackground(Color.BLACK);
		 window.setVisible(true);
		 game.init();
		  }

		
/*
* initialisation method 
 */
	public void init() {
			
		
			
	}
/*
* draw method
*/
		
	public void draw(Graphics g) {
		}

	
/*
 * 
 */
	public void actionPerformed() {
		
		
	}
}