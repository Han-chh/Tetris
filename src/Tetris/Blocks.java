
import java.awt.Color;

public class Blocks implements Runnable{
	
	private int[][] blocks_location = new int[4][2]; //4 blocks' x and y coordinate
	private int changing_shape = 1 ; //1 2 3 4respectively for 4 different changing shape.
	public Shapes current_shape; // enum shape records the changing shape data.
	private int fullRows = 0;
	private int next_image = 0;
	public static int velocity = 0;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ProcessControl.isPause = false;
		move();
	}
	
	
	private void move()  {
		while(ProcessControl.restartWait) { // if the program is waiting for restart then waiting
			try {
				
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		randomCreate();
		Window.setDifficultyChangable(false);
		while(true) {
			velocity = Window.getDifficultyVelocity();
			try {
				Thread.sleep(350 - velocity);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			dropOneGrid();
		}
		
		
	}
	private void dropOneGrid() {
		
		checkBottom();
		checkStored();
		if(ProcessControl.restartWait) {
			for (int i = 0;i<4;i++) { // if it is waiting restart, set the blocks white
				Game.whole_Map[blocks_location[i][0]]
						[blocks_location[i][1]].setBackground(Color.WHITE);
			}
		}
		while(ProcessControl.isPause || ProcessControl.restartWait) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		for (int i = 0;i<4;i++) { //coordinates going down
			blocks_location[i][0]=blocks_location[i][0]+1;
		}
		Refresh.refresh(blocks_location, current_shape.color);
		
	}
	
	private void checkBottom() { //check if the blocks reaches the bottom
		for (int i = 0;i<4;i++) { // check bottom
			if (blocks_location[i][0]>=Game.whole_Map.length - 1) {
				setStored(blocks_location,current_shape.color);
				detectScore();
				updateScore();
				randomCreate();
			}
		}
		
	}
	private void checkStored() {//check if the blocks reaches the stored places
		for (int i = 0;i<4;i++) { // check stored

			if (Game.whole_Map[blocks_location[i][0] + 1][blocks_location[i][1]].
					getFeature().equals(MapGrid.STORED)) {
				setStored(blocks_location,current_shape.color);
				detectScore();
				updateScore();
				detectDeath();
				randomCreate();
			}
			
		}
	}
	private void detectDeath() {
		//detect dead
		for (int i = 0;i<10;i++) {
			if (Game.whole_Map[4][i].getFeature().equals(MapGrid.STORED)) {
				Game.Win.deadDialog();
			}
		}
	}
	private void setStored(int[][] blocks_location,Color c) { //set the blocks which are on the bottom stored.
		for (int i = 0; i<4;i++) {
			Game.whole_Map[blocks_location[i][0]][blocks_location[i][1]].setBackground(c);
			Game.whole_Map[blocks_location[i][0]][blocks_location[i][1]].setFeature(MapGrid.STORED);
		}
		
	}
	public void restart() {
		
		Game.Win.pause.setText("PAUSE");
		ProcessControl.isPause = true;
		next_image = 0;
		for(int i = 0;i<4;i++) {
			blocks_location[i][0] = 0;
			blocks_location[i][1] = 0;
		}
		ProcessControl.init();
		randomCreate();
		ProcessControl.isPause = false;		
	}
	private int next() {
		int block = (int)(Math.random()*7+1);
		if(!ProcessControl.restartWait) {
			for (int i = 0;i<4;i++) {
				for(int j = 0;j<2;j++) {
					Game.Win.whole_next_image[i][j].setBackground(Color.WHITE);
				}
			}
			switch (block) {
			case 1:
				for(int i = 0;i<4;i++) {
					Game.Win.whole_next_image[i][0].setBackground(Color.GREEN);
				}
				break;
			case 2:
				for(int i = 0;i<2;i++) {
					Game.Win.whole_next_image[1][i].setBackground(Color.ORANGE);
					Game.Win.whole_next_image[2][i].setBackground(Color.ORANGE);
				}
				break;
				
			case 3:
				Game.Win.whole_next_image[0][0].setBackground(Color.MAGENTA);
				Game.Win.whole_next_image[1][0].setBackground(Color.MAGENTA);
				Game.Win.whole_next_image[1][1].setBackground(Color.MAGENTA);
				Game.Win.whole_next_image[2][1].setBackground(Color.MAGENTA);
				break;
				
			case 4:
				Game.Win.whole_next_image[0][1].setBackground(Color.BLUE);
				Game.Win.whole_next_image[1][0].setBackground(Color.BLUE);
				Game.Win.whole_next_image[1][1].setBackground(Color.BLUE);
				Game.Win.whole_next_image[2][0].setBackground(Color.BLUE);
				break;
				
			case 5:
				Game.Win.whole_next_image[0][0].setBackground(Color.YELLOW);
				Game.Win.whole_next_image[1][0].setBackground(Color.YELLOW);
				Game.Win.whole_next_image[2][0].setBackground(Color.YELLOW);
				Game.Win.whole_next_image[2][1].setBackground(Color.YELLOW);
				break;
				
			case 6:
				Game.Win.whole_next_image[0][1].setBackground(Color.RED);
				Game.Win.whole_next_image[1][1].setBackground(Color.RED);
				Game.Win.whole_next_image[2][1].setBackground(Color.RED);
				Game.Win.whole_next_image[2][0].setBackground(Color.RED);
				break;
				
			case 7:
				Game.Win.whole_next_image[0][0].setBackground(Color.PINK);
				Game.Win.whole_next_image[1][0].setBackground(Color.PINK);
				Game.Win.whole_next_image[1][1].setBackground(Color.PINK);
				Game.Win.whole_next_image[2][0].setBackground(Color.PINK);
				break;
			}
			return block;
		}
		return block;
	}
	private void randomCreate() { //calculate the random coor of the mid-block showing up
		fullRows = 0;
		int init_block = next_image;
		if (next_image == 0) {
			init_block = (int)(Math.random()*7+1);
		}
		next_image = next();
		changing_shape = 1;
		blocks_location[0][1] = 4;
		switch (init_block) {
			case 1:
				blocks_location[0][0] = 2;							//set location,color and occupied
				Game.whole_Map[2][4].setBackground(Color.GREEN);
				Game.whole_Map[2][4].setFeature(MapGrid.OCCUPIED);
				break;
			
			case 2:
				blocks_location[0][0] = 0;
				Game.whole_Map[0][4].setBackground(Color.ORANGE);
				Game.whole_Map[0][4].setFeature(MapGrid.OCCUPIED);
				break;
				
			case 3:
				blocks_location[0][0] = 1;
				Game.whole_Map[1][4].setBackground(Color.MAGENTA);
				Game.whole_Map[1][4].setFeature(MapGrid.OCCUPIED);
				break;
				
			case 4:
				blocks_location[0][0] = 1;
				Game.whole_Map[1][4].setBackground(Color.BLUE);
				Game.whole_Map[1][4].setFeature(MapGrid.OCCUPIED);
				break;
				
			case 5:
				blocks_location[0][0] = 2;
				Game.whole_Map[2][4].setBackground(Color.YELLOW);
				Game.whole_Map[2][4].setFeature(MapGrid.OCCUPIED);
				break;
				
			case 6:
				blocks_location[0][0] = 2;
				Game.whole_Map[2][4].setBackground(Color.RED);
				Game.whole_Map[2][4].setFeature(MapGrid.OCCUPIED);
				break;
				
			case 7:
				blocks_location[0][0] = 1;
				Game.whole_Map[0][4].setBackground(Color.PINK);
				Game.whole_Map[0][4].setFeature(MapGrid.OCCUPIED);
				break;
		}
		current_shape= Shapes.valueOf( Shapes.values()[init_block-1].name());//which shape now is
		fill_surrounding(); //fill the surroundings
			
	}

	private void fill_surrounding() {
		//fill the surrounding blocks of the mid-block
		String [] surroundings = current_shape.diff_shapes[changing_shape - 1]; //get the surroundings algorithm
		for(int i = 0;i<surroundings.length;i++) {
			fill(blocks_location[0],surroundings[i],i+1 ); //do filling
		}
		for (int i = 0;i<4;i++) { // check boundary
			if (blocks_location[i][0]>19 ||blocks_location[i][1] < 0 ||
					blocks_location[i][1] > 9 || Game.whole_Map[blocks_location
					[i][0]][blocks_location[i][1]].getFeature().equals("STORED")) {
				changing_shape--;
				if (changing_shape == 0) {
					changing_shape = 4;
				}
				fill_surrounding();
			}
		}
		Refresh.refresh(blocks_location, current_shape.color);
		
	}
	
	private void fill(int []mid_coor, String direction,int index) { //fill single block
		//fill
		switch (direction) {
			case "UP":
				blocks_location[index][0] = mid_coor[0] - 1;
				blocks_location[index][1] = mid_coor[1];
				break;
			case "DOWN":
				blocks_location[index][0] = mid_coor[0] + 1;
				blocks_location[index][1] = mid_coor[1];
				break;
			case "LEFT":
				blocks_location[index][0] = mid_coor[0];
				blocks_location[index][1] = mid_coor[1] - 1;
				break;
			case "RIGHT":
				blocks_location[index][0] = mid_coor[0];
				blocks_location[index][1] = mid_coor[1] + 1;
				break;
			case "UP_UP":
				blocks_location[index][0] = mid_coor[0] - 2;
				blocks_location[index][1] = mid_coor[1];
				break;
			case "DOWN_DOWN":
				blocks_location[index][0] = mid_coor[0] + 2;
				blocks_location[index][1] = mid_coor[1];
				break;
			case "LEFT_LEFT":
				blocks_location[index][0] = mid_coor[0];
				blocks_location[index][1] = mid_coor[1] - 2;
				break;
			case "RIGHT_RIGHT":
				blocks_location[index][0] = mid_coor[0];
				blocks_location[index][1] = mid_coor[1] + 2;
				break;
				
			case "RIGHT_DOWN":
				blocks_location[index][0] = mid_coor[0] + 1;
				blocks_location[index][1] = mid_coor[1] + 1;
				break;
			case "RIGHT_UP":
				blocks_location[index][0] = mid_coor[0] - 1;
				blocks_location[index][1] = mid_coor[1] + 1;
				break;
			case "LEFT_DOWN":
				blocks_location[index][0] = mid_coor[0] + 1;
				blocks_location[index][1] = mid_coor[1] - 1;
				break;
			case "LEFT_UP":
				blocks_location[index][0] = mid_coor[0] - 1;
				blocks_location[index][1] = mid_coor[1] - 1;
				break;
			
		}
			
	}
	
	public void leftwardsAndRightwards(String direction) {
		int translation = 0;
		if (direction.equals("LEFT")) {
			translation = -1;
		}else if(direction.equals("RIGHT")) {
			translation = 1;
		}
		if (rightAndLeftCheck(translation)) {
			for (int i = 0;i<4;i++) { //coordinates going left or right
				blocks_location[i][1]=blocks_location[i][1] + translation;
			}
			Refresh.refresh(blocks_location, current_shape.color);
		}
	}
	
	
	private boolean rightAndLeftCheck(int translation) {
		
		for (int i = 0;i<4;i++) { // check two sides
			if ((blocks_location[i][1]>=9 && translation == 1) || 
					(blocks_location[i][1]<=0 &&translation == -1)) {
				return false;
			}else if ((translation == 1 && Game.whole_Map[blocks_location[i][0]][blocks_location[i][1] + 1].
					getFeature().equals(MapGrid.STORED))|| 
					(translation == -1 && Game.whole_Map[blocks_location[i][0]][blocks_location[i][1] - 1].
							getFeature().equals(MapGrid.STORED))){
								return false;
							}
		}
		return true;
	}
	
	public void accelerate() {
		dropOneGrid();
	}
	
	public void changeShape() {
		changing_shape++;
		if (changing_shape == 5) {
			changing_shape = 1;
		}
		fill_surrounding();
	}
	
	private void detectScore() { // detect the getting score action
		
		int count;
		//detect full
		for(int i = 0;i<15;i++) {
			count = 0;
			for(int j = 0;j<=9;j++) {
				if (Game.whole_Map[19-i][j].getFeature().equals(MapGrid.STORED)){
					count++;
				}
			}
			if (count == 10) {
				//clear
				fullRows ++;
				clear(19-i);
				//drop
			}
		}
	}
	
	private void clear(int row) {
		for (int i = 0;i < 10;i++) {
			Game.whole_Map[row][i].setBackground(Color.WHITE);
			Game.whole_Map[row][i].setFeature(MapGrid.NONE);
		}
		drop(row);
	}
	
	private void drop(int clearedRow) {
		int i = clearedRow - 1;
		while(i > 0) {
			for (int j = 0; j<10;j++) {
				if (Game.whole_Map[i][j].getFeature().equals(MapGrid.STORED)) {
					Color c = Game.whole_Map[i][j].getBackground();
					Game.whole_Map[i][j].setBackground(Color.WHITE);
					Game.whole_Map[i][j].setFeature(MapGrid.NONE);
					Game.whole_Map[i + 1][j].setBackground(c);
					Game.whole_Map[i + 1][j].setFeature(MapGrid.STORED);
				}
			}
			i--;
		}
		detectScore();
	}
	private void updateScore() {
		if (fullRows == 1) {
			Game.Score = Game.Score + 10;
		}else if (fullRows > 1) {
			int score = 10 * (fullRows*fullRows);
			Game.Score = Game.Score + score;
		}
	}
	
}
