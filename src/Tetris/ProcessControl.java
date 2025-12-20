
import java.awt.Color;


public class ProcessControl implements Runnable {
	
	public volatile static boolean isPause = false;
	public static boolean restartWait = false;
	@Override
	public void run() {
		while(true) {
			Game.Win.score.setText("SCORE: " + Game.Score);
			Game.Win.timer.setText("TIME: " + String.format("%.2f", Game.timer));
			Game.Win.requestFocus();
		}
	}
	
	public static void init() {
		Game.timer = 0;
		Game.Score = 0;	
		
		for(int i= 0;i<20;i++) {
			for (int j = 0; j<10;j++) {
				Game.whole_Map[i][j].setBackground(Color.WHITE);
				Game.whole_Map[i][j].setFeature(MapGrid.NONE);
			}
		}
		for (int i = 0;i<4;i++) {// set the next image white.
			Game.Win.whole_next_image[i][0].setBackground(Color.WHITE);
			Game.Win.whole_next_image[i][1].setBackground(Color.WHITE);
		}
	}
}
