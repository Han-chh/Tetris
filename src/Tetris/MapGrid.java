

import java.awt.*;
import javax.swing.*;

public class MapGrid extends JLabel{
	
	private String feature; // its current condition
	public static final String OCCUPIED = "OCCUPIED";//conditions
	public static final String STORED = "STORED";
	public static final String NONE = "NONE";

	public MapGrid() { //Constructor of grids objects.
		super();
		this.setVisible(false);
		this.feature = NONE; //initiation is none
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setOpaque(true);
	}
	
	
	//map generating method
	public static MapGrid[][] generate(JPanel map_panel, int rows,int columns) {
		
		map_panel.removeAll();
		map_panel.repaint();
		map_panel.setLayout(new GridLayout(rows, columns));
		MapGrid[][] map_grids_list = new MapGrid[rows][columns]; 
		for (int i = 0;i<rows;i++) {
			for (int j = 0;j<columns;j++) {
				map_grids_list[i][j] = new MapGrid();
				map_panel.add(map_grids_list[i][j]);
				map_grids_list[i][j].setVisible(true);
				map_grids_list[i][j].setBackground(Color.WHITE);
			}
		}
		return map_grids_list;
	}
	
	
	public void setFeature(String feature) { //set feature
		this.feature = feature;
	}
	
	
	public String getFeature() {//get feature
		return this.feature;
	}
	
}
