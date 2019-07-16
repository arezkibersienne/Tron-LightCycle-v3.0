package Model;

import java.awt.Color;
import java.awt.Graphics;

public class Cycle  {
	
	/**
	 * @author arezki ibersienne
	 * @category Java 2D Game
	 */

	private int xPos , yPos , sideLenght , direction , speed , score; 
	

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
		
	/*
	 * this method return true if the cycle collied with a collored pixel
	 */
		
		public boolean willDie() {
			
			if(direction == 180 && !TronGame.isWhite(xPos - (sideLenght -5), yPos)) 
				return true;
			if(direction == 90 && !TronGame.isWhite(xPos, yPos - (sideLenght - 5)))
				return true;
			if(direction == 0 && !TronGame.isWhite(xPos + (sideLenght + 3), yPos))
				return true;
			if(direction == 270 && !TronGame.isWhite(xPos, yPos + (sideLenght)))
				return true;
			if(xPos >= 600 || xPos <= 0 || yPos >= 580 || yPos <= 150)
				return true;
			else 
				return false;
		}
	

		/*
	 * Getters and setters
	 */
		public int getDirection() {
			return direction;
		}

		public void setDirection(int direction) {
			this.direction = direction;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}

		
}
