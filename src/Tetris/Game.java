
import java.awt.Color;

import javax.swing.SwingConstants;
public class Game {
	
	public static Window Win;// main
	public static int Score = 0; //����
	public static float timer = 0;
	public static MapGrid[][] whole_Map = new MapGrid[20][10]; 
	public static Blocks main_blocks;
	
	public static void main(String[] args) {
		Win = new Window();
		whole_Map = MapGrid.generate(Window.Map_panel, 20, 10);
		
		for (int i = 0;i<10;i++) { //create red line
			whole_Map[4][i].setHorizontalAlignment(SwingConstants.CENTER);
			whole_Map[4][i].setText("---");

			whole_Map[4][i].setForeground(Color.RED);
		}
		main_blocks = new Blocks(); //create the dropping blocks.
	}
}
