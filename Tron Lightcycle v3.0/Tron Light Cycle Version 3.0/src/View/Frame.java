package View;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.TronGame;

public class Frame extends JPanel {
	
	/**
	 * @author Arezki Ibersienne
	 * @category JAVA 2D GAME
	 */
	private static final long serialVersionUID = 1L;
	
	public Frame(String title,int width , int height ,TronGame game ){
		JFrame window = new JFrame(title);
	    window.setSize(new Dimension(width , height));
	    //window.setBounds(0, 0, 600, 400);// window size
 	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setResizable(false);
	    window.setLocationRelativeTo(null);
	    window.setBackground(Color.BLACK);
	    window.setVisible(true);
	    window.getContentPane().add(game);
	    window.addKeyListener(game);
	    game.init();

}
}