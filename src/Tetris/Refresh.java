

import java.awt.Color;

public class Refresh {
	public static void refresh(int[][]blocks_location,Color c) {

		// make previous dropping blocks white and update none
		for (int i = 0; i<20;i++) {
			for(int j = 0;j<10;j++) {
				if (Game.whole_Map[i][j].getFeature().equals(MapGrid.OCCUPIED)) {
					Game.whole_Map[i][j].setBackground(Color.WHITE);
					Game.whole_Map[i][j].setFeature(MapGrid.NONE);
				}
			}
		}
		//refresh the current blocks
		for (int i = 0; i<4;i++) {
			//update occupied
			Game.whole_Map[blocks_location[i][0]][blocks_location[i][1]].setBackground(c);
			Game.whole_Map[blocks_location[i][0]][blocks_location[i][1]].setFeature(MapGrid.OCCUPIED);
		}
			
	}
	
}
