package Game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class MapGenerator {
	
	public int brickWidth;
	public int brickHeight;
	public int [][] map;
	
	// constructor
	public MapGenerator(int row, int col) {
		
		// number of bricks
		map = new int[row][col];
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				map[i][j] = 1 ;
			}
		}
		
		brickWidth = 540 / col;
		brickHeight = 150 / row;
	}
	
	public void draw(Graphics2D g) {
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				
				if(map[i][j] > 0) {
					
					// bricks = white
					g.setColor(Color.white);
					// paints all bricks in one single rectangle
					g.fillRect(j * brickWidth + 80, i * brickHeight + 50 , brickWidth, brickHeight);	
					// gives every single brick a border
					g.setStroke(new BasicStroke(3));
					// brick borders = black
					g.setColor(Color.black);
					// paints the border of the brick
					g.drawRect(j * brickWidth + 80, i * brickHeight + 50 , brickWidth, brickHeight);
				}
			}
		}
		
	}
}
