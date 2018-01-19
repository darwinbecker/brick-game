package Game;

import java.awt.Color;						// Background color library
import java.awt.Graphics;					// Graphic library
import java.awt.Graphics2D;
import java.awt.Rectangle;					// Rectangle library
import java.awt.event.ActionEvent;				// does actions
import java.awt.event.ActionListener; 				// 
import java.awt.event.KeyEvent;					// checks keys
import java.awt.event.KeyListener;				// 

import javax.swing.JPanel;					// class extension (Interface)
import javax.swing.Timer;


// implement interface and keys/action listeners
public class Gameplay extends JPanel implements KeyListener, ActionListener{
	
	// creating some variables
	private boolean play = false;
	private int score = 0;
	private  int totalBricks = 21;
	
	// position of the player
	private int playerPosX = 310;
	
	// position of the ball
	private int ballPosX = 350;
	private int ballPosY = 300;
	
	// direction of the ball
	private int ballDirectionX = -1;
	private int ballDirectionY = -2;
	
	// timer and delay
	private Timer timer;
	private int delay = 5;
	
	private MapGenerator map;
	
	// constructor
	public Gameplay() {
		map = new MapGenerator(3, 7);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}
	
	// painting objects (colors of the objects)
	public void paint(Graphics g) {
		
		// background
		g.setColor(Color.black);		// background = black
		g.fillRect(1, 1, 700, 592);		// (x,y,width,height)
		
		// border
		g.setColor(Color.yellow);		// border = yellow
		g.fillRect(0, 0, 697, 3);		// upper border
		g.fillRect(0, 0, 3, 592);		// left border
		g.fillRect(697, 0, 3, 592);		// right border
		
		// map
		map.draw((Graphics2D)g);		// bricks = white
		
		// player
		g.setColor(Color.green);		// player = green
		g.fillRect(playerPosX, 550, 100, 8);
		
		// ball
		g.setColor(Color.yellow);		// ball = yellow
		g.fillOval(ballPosX, ballPosY, 20, 20);
		
		g.dispose();
	}
	
	//@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		// starts the timer
		timer.start();
		
		// interaction between ball and player
		if(new Rectangle(ballPosX, ballPosY, 20, 20).intersects(new Rectangle(playerPosX, 550, 100, 80))) {
			
			// ball bounces upwards if it hits the player
			ballDirectionY = -ballDirectionY;
		}
		
		if(play) {
			// ball moves around
			ballPosX += ballDirectionX;
			ballPosY += ballDirectionY;
			
			// ball bounces against left wall
			if(ballPosX < 0) {
				ballDirectionX =  - ballDirectionX;
			}
			// ball bounces against upper wall
			if(ballPosY < 0) {
				ballDirectionY = - ballDirectionY;
			}
			// ball bounces against right wall
			if(ballPosX > 677) {
				ballDirectionX = - ballDirectionX;
			}
		}
		repaint();
	}

	//@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		// left arrow-key
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			// clamping
			if(playerPosX <= 6) {
				playerPosX = 6;
			}
			else {
				moveLeft();
			}
		}
		// right arrow-key
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			// clamping
			if(playerPosX >= 594) {
				playerPosX = 594;
			}
			else {
				moveRight();
			}
		}
		repaint();
	}

	// moves player to the left
	private void moveLeft() {
		play = true;
		playerPosX -= 25;
	}
	
	// moves player to the right
	private void moveRight() {
		play = true;
		playerPosX += 25;
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
