package Model;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TronGame extends JPanel implements KeyListener, ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * @author Arezki Ibersienne
	 * @category Jave 2D game
	 */
	
	  // declare all instance variables 
	  private boolean pl = false , pl2 = false;
	  private String scr , scr2;
	  private final Font myFont = new Font("Courier New", 1, 40);
	  private final Font myFont2 = new Font("Courier New", 1, 20);
	  private AudioClip sound1;
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
	    window.addKeyListener(game);
	    game.init();
	  }

	  /**
	   * init method needed to initialize non-static fields
	   */
	  public void init() {
	    offScreenBuffer = createImage(600, 600);
	    offScreenGraphics = offScreenBuffer.getGraphics();
	    timer = new Timer(20, this);
	    // timer fires every 20 milliseconds.. invokes method actionPerformed()
	    sound1 = Applet.newAudioClip(getClass().getResource("/bg.wav"));
	    initRound();
	  }

	  /**
	   * initializes all fields needed for each round of play 
	   */
	  public void initRound() {
	    frameCount = 0;
	    offScreenGraphics.clearRect(0, 0, 600, 600);
	    repaint();
	    player = new Cycle(100 , 230 , spawn ,Color.cyan );
	    player2 = new Cycle(400 , 230 , spawn ,Color.yellow);
	  }
	  
	  
	  /**
	   * Called automatically after a repaint request<br>
	   */
	  public void paint(Graphics g) {
	    draw((Graphics2D) offScreenGraphics);
	    g.drawImage(offScreenBuffer, 0, 0, this);
	    g.setColor(Color.lightGray);
	    g.fillRect(0, 0, 600, 150);
	    g.setFont(myFont);
	    if(pl) {
	    	g.setColor(Color.lightGray);
	    	g.fillRoundRect(100, 300, 400, 150, 10, 10);
	    	g.setColor(Color.yellow);
	    	g.drawString("Player 2 Won", 150 ,385);
	    	g.setFont(myFont2);
	    	g.drawString("Score : ", 230 , 420);
	    	scr2 = String.valueOf(player2.getScore());
	    	g.drawString(scr2, 330, 420);
	    }
	    if(pl2) {
	    	g.setColor(Color.lightGray);
	    	g.fillRoundRect(100, 300, 400, 150, 10, 10);
	    	g.setColor(Color.cyan);
	    	g.drawString("Player 1 Won", 150 , 385);
	    	g.setFont(myFont2);
	    	g.drawString("Score : ", 230 , 420);
	    	scr = String.valueOf(player.getScore());
	    	g.drawString(scr, 330, 420);
	    }
	    }

	  /**
	   * renders all objects to Graphics g
	   */
	  public void draw(Graphics2D g) {
	    g.setColor(Color.BLACK);

	    
	    // render all game objects here
	    player.draw(g);
	    player2.draw(g);
		  }

	  /**
	   * Called automatically when the timer fires<br>
	   * this is where all the game fields will be updated
	   */
	  public void actionPerformed(ActionEvent e) {

	    // update all game Objects here
		player.updatePos();
		player2.updatePos();
	    frameCount++;// update the frameCount
	    repaint();// needed to refresh the animation
	    //keeping score
	    
	    player.setScore(frameCount);
	    player2.setScore(frameCount);

	    //Stop timer whene player is dead
	  	    if(player.willDie()) 
	    {	timer.stop();
	    	pl = true;
	    }else {
	    	pl = false;
	    }
	    if(player2.willDie())
	    {
	    	timer.stop();
	    	pl2 = true;
	    }else {
	    	pl2 = false;
	    }
	   }

	  /**
	   * handles any key pressed events and updates the Cycle's direction by setting
	   * their direction to either 0,90,180 or 270 based on which key is pressed.
	   */
	  public void keyPressed(KeyEvent e) {
	    int keyCode = e.getKeyCode();
	    if (keyCode == KeyEvent.VK_LEFT) {
	    	player.setDirection(180);
	    } else if (keyCode == KeyEvent.VK_RIGHT) {
	    	player.setDirection(0);
	    }else if (keyCode == KeyEvent.VK_UP) {
	    	player.setDirection(90);
	    }else if(keyCode == KeyEvent.VK_DOWN) {
	    	player.setDirection(270);
	    }
	    if(keyCode == KeyEvent.VK_Z) {
	    	player2.setDirection(90);
	    }else if(keyCode == KeyEvent.VK_S) {
	    	player2.setDirection(270);
	    }else if(keyCode == KeyEvent.VK_Q) {
	    	player2.setDirection(180);
	    }else if(keyCode == KeyEvent.VK_D) {
	    	player2.setDirection(0);
	    }
	  }
	  

	  /**
	   * handles any key released events ... <br>
	   * starts game by the '6 Key'<br>
	   * kills the game window by the 'Escape Key'
	   */
	  public void keyReleased(KeyEvent e) {
	    int keyCode = e.getKeyCode();
	    if (keyCode == KeyEvent.VK_P) {
	      // start the game .. if the game has not currently running
	    	
	      if (!timer.isRunning()) {
	        timer.start();
	        initRound();
	        sound1.play();
	      }
	    } else if (keyCode == KeyEvent.VK_ESCAPE) {
	      // kill game process... close the window
	      System.exit(0);
	    }
	  }

	  /**
	   * this method is needed for implementing interface KeyListener<br>
	   */
	  public void keyTyped(KeyEvent e) {
	  }

	  /**
	   * returns true if the color value of the pixel<br>
	   * with coordinates (x,y) is WHITE, false otherwise<br>
	   */
	  public static boolean isWhite(int x, int y) {
	    BufferedImage bi = (BufferedImage) offScreenBuffer;
	    if (bi == null)
	      return true;
	    try {
	      int colorVal = bi.getRGB(x, y);
	      return (colorVal == -16777216);
	    } catch (Exception ex) {
	      return false;
	    }
	  }
	  /**
	   * this method return player state
	   */

	public Cycle getPlayer() {
		return player;
	}

	public Cycle getPlayer2() {
		return player2;
	}

	public Timer getTimer() {
		return timer;
	}
	  
	}// end class TronGame