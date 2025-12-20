
import java.awt.Color;

public enum Shapes {
	
	I("I",Color.GREEN),O("O",Color.ORANGE),
	S("S",Color.MAGENTA),Z("Z",Color.BLUE),
	L("L",Color.YELLOW),R_L("R_L",Color.RED),
	T("T",Color.PINK);
	
	public String[][] diff_shapes;
	public Color color;
	
	private Shapes(String name,Color c){
		this.diff_shapes = shape_data(name);
		this.color = c;
	}
	
	private String[][] shape_data(String name){
		
		/*According to the middle block of all blocks, shape data return the other 3 blocks' 
		 * relative location. Also records other changing shapes' relative location. 
		 */
		
		String[][] diff_shapes = new String[4][3];
		switch (name){
			case "I":
				diff_shapes[0][0] = "UP_UP";
				diff_shapes[0][1] = "UP";
				diff_shapes[0][2] = "DOWN";
				diff_shapes[1][0] = "LEFT";
				diff_shapes[1][1] = "RIGHT";
				diff_shapes[1][2] = "RIGHT_RIGHT";
				diff_shapes[2][0] = "UP";
				diff_shapes[2][1] = "DOWN";
				diff_shapes[2][2] = "DOWN_DOWN";
				diff_shapes[3][0] = "LEFT_LEFT";
				diff_shapes[3][1] = "LEFT";
				diff_shapes[3][2] = "RIGHT";
				return diff_shapes;
			case "O":
				String [][] shapes_O = new String[1][3];
				shapes_O[0][0] = "RIGHT";
				shapes_O[0][1] = "DOWN";
				shapes_O[0][2] = "RIGHT_DOWN";
				return shapes_O;
			case "S":
				diff_shapes[0][0] = "LEFT";
				diff_shapes[0][1] = "UP";
				diff_shapes[0][2] = "RIGHT_UP";
				diff_shapes[1][0] = "UP";
				diff_shapes[1][1] = "RIGHT";
				diff_shapes[1][2] = "RIGHT_DOWN";
				diff_shapes[2][0] = "LEFT_DOWN";
				diff_shapes[2][1] = "DOWN";
				diff_shapes[2][2] = "RIGHT";
				diff_shapes[3][0] = "LEFT_UP";
				diff_shapes[3][1] = "LEFT";
				diff_shapes[3][2] = "DOWN";
				return diff_shapes;
			case "Z":
				diff_shapes[0][0] = "LEFT_UP";
				diff_shapes[0][1] = "UP";
				diff_shapes[0][2] = "RIGHT";
				diff_shapes[1][0] = "DOWN";
				diff_shapes[1][1] = "RIGHT";
				diff_shapes[1][2] = "RIGHT_UP";
				diff_shapes[2][0] = "LEFT";
				diff_shapes[2][1] = "DOWN";
				diff_shapes[2][2] = "RIGHT_DOWN";
				diff_shapes[3][0] = "UP";
				diff_shapes[3][1] = "LEFT";
				diff_shapes[3][2] = "LEFT_DOWN";
				return diff_shapes;
			case "L":
				diff_shapes[0][0] = "UP_UP";
				diff_shapes[0][1] = "UP";
				diff_shapes[0][2] = "RIGHT";
				diff_shapes[1][0] = "DOWN";
				diff_shapes[1][1] = "RIGHT_RIGHT";
				diff_shapes[1][2] = "RIGHT";
				diff_shapes[2][0] = "LEFT";
				diff_shapes[2][1] = "DOWN";
				diff_shapes[2][2] = "DOWN_DOWN";
				diff_shapes[3][0] = "UP";
				diff_shapes[3][1] = "LEFT";
				diff_shapes[3][2] = "LEFT_LEFT";
				return diff_shapes;
			case "R_L":
				diff_shapes[0][0] = "UP_UP";
				diff_shapes[0][1] = "UP";
				diff_shapes[0][2] = "LEFT";
				diff_shapes[1][0] = "UP";
				diff_shapes[1][1] = "RIGHT_RIGHT";
				diff_shapes[1][2] = "RIGHT";
				diff_shapes[2][0] = "RIGHT";
				diff_shapes[2][1] = "DOWN";
				diff_shapes[2][2] = "DOWN_DOWN";
				diff_shapes[3][0] = "DOWN";
				diff_shapes[3][1] = "LEFT";
				diff_shapes[3][2] = "LEFT_LEFT";
				return diff_shapes;
			case "T":
				diff_shapes[0][0] = "RIGHT";
				diff_shapes[0][1] = "DOWN";
				diff_shapes[0][2] = "LEFT";
				diff_shapes[1][0] = "LEFT";
				diff_shapes[1][1] = "UP";
				diff_shapes[1][2] = "DOWN";
				diff_shapes[2][0] = "UP";
				diff_shapes[2][1] = "LEFT";
				diff_shapes[2][2] = "RIGHT";
				diff_shapes[3][0] = "UP";
				diff_shapes[3][1] = "RIGHT";
				diff_shapes[3][2] = "DOWN";
				return diff_shapes;
			
			default:
				return diff_shapes;
		}
		
	}
}
