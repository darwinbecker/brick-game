package Game;

import javax.swing.JFrame;

public class MainGame {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Gameplay gameplay = new Gameplay();
		frame.setBounds(350,100,700,600);						// sets window size
		frame.setTitle("Brick Game by Darwin");							// name of the game
		frame.setAutoRequestFocus(false);						// makes window static (not movable)
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	// closes the game (stops the console/terminal)
		frame.add(gameplay);										// places gameplay into the window
		frame.setVisible(true);									// makes window visible
	}

}
