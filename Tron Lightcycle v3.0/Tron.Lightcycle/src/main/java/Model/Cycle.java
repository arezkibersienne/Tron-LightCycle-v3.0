package Model;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Cycle  {
	
	/**
	 * 
	 * @author Arezki Ibersienne
	 * @category Jave 2D game
	 */
	

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
		/*
		 * method that draws the cycle on the screen 
		 */
			public void draw(Graphics g) {
					g.setColor(c);
					g.fillRect(xPos, yPos, sideLenght, sideLenght);
					
					
				}
		/*
		* this method is used to update xPos and yPos based on direction	
		*/
			public void updatePos() {
				if(direction == 0) {
					xPos += speed;
				}else if(direction == 90) {
					yPos -= speed;
				}else if(direction == 180) {
					xPos -= speed;
				}else if(direction == 270) {
					yPos += speed;
				}
						
					
				}
}