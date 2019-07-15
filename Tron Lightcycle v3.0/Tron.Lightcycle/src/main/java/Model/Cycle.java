package Model;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Cycle  {

	private int xPos , yPos , sideLenght , direction , speed , spawnState, score; 
	

	private Color c; 
	/*
	 * 
	 * xPos and yPos are the position of the cycle.
	 * 
	 * sideLenght , which is the integer lenght of a side 
	 * 
	 * direction 
	 * ---------
	 * 0 = right 
	 * 90 = up
	 * 180 = left
	 * 270 = down
	 * 
	 * speed is an int number of pixels the cycle move each frame
	 * 
	 * spawnState
	 * ----------
	 * in which state is the player
	 * 
	 * 1 = down
	 * 2 = up
	 * 3 = reverse
	 * 4 = side
	 *
	 * Color c is a the cycle color 
	 */
	
	
	
	/*
	 * Default constructor with no parameters
	 */
		public Cycle() {
			xPos = 0 ;
			yPos = 0 ; 
			direction = 0;
			sideLenght = 0;
			speed = 0;
			c = null;
		}
			
		/*
		 * constructor with parameters 
		 */
			public Cycle(int xPos , int yPos , int direction , Color c) {
				this.xPos = xPos;
				this.yPos = yPos;
				this.direction = direction;
				this.c = c;
				sideLenght = 4;
				speed = 4;
			}
	
}