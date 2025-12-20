
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Window extends JFrame {
	static JPanel Map_panel = new JPanel(); 
	JPanel control_board = new JPanel();
	JPanel infoBoard = new JPanel();
	JButton start = new JButton("START");
	JButton pause = new JButton("PAUSE");
	JButton restart = new JButton("RESTART");
	JLabel game_title = new JLabel("TETRIS");
	JLabel next = new JLabel("next");
	JLabel timer = new JLabel("TIME: ");
	JLabel score = new JLabel("SCORE: ");
	JPanel nextBlock = new JPanel();
	public static JRadioButton slow = new JRadioButton("TURTLE");
	public static JRadioButton normal = new JRadioButton("NORMAL");
	public static JRadioButton hard = new JRadioButton("FAST");
	public static JRadioButton increase = new JRadioButton("INCREASING");
	ButtonGroup difficulty = new ButtonGroup();
	MapGrid[][] whole_next_image;
	
	public Window() {    //initiation of the main_window
		super("Tetris");
		this.setLocation(400,80);
		this.setVisible(true);
		this.setSize(450, 630);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		
		addThings();	
	}
	
	private void addThings() { 
		//set Control board
		Container c = new Container();
		c = this.getContentPane();
		c.setLayout(null);
		
		c.add(control_board);
		control_board.setSize(275, 105);
		control_board.setLocation(0,485);
		control_board.setBorder(BorderFactory.createTitledBorder("Control"));
		control_board.setLayout(null);
		
		start.setBounds(20,30,70,35);
		control_board.add(start);
		start.setFont(new Font("Sancerif",Font.BOLD,9));
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				Window.setDifficultyChangable(false);
				start.setEnabled(false);
				pause.setEnabled(true);
				restart.setEnabled(true);
				new Thread(Game.main_blocks).start();
				new Thread(new ProcessControl()).start();
				new Thread(new GameTimer()).start();
				Game.Win.setFocusable(true);
				Game.Win.addKeyListener(new KeyAdapter() {
					public void keyReleased(KeyEvent e) {
						if (!ProcessControl.isPause || !ProcessControl.restartWait) {
							if (e.getKeyChar()=='a'|| e.getKeyCode()==KeyEvent.VK_LEFT){
								Game.main_blocks.leftwardsAndRightwards("LEFT");
							}else if(e.getKeyChar()=='d'|| e.getKeyCode()==KeyEvent.VK_RIGHT){
								Game.main_blocks.leftwardsAndRightwards("RIGHT");
							}else if( (e.getKeyChar() == 's'|| e.getKeyCode()==KeyEvent.VK_DOWN)){
									Game.main_blocks.accelerate();
							}else if (e.getKeyChar() == 'w'|| e.getKeyCode()==KeyEvent.VK_UP) {
								if (!Game.main_blocks.current_shape.name().equals("O")){
										Game.main_blocks.changeShape();
								}
							}
						}
					}
				});
			}
		});
		
		pause.setBounds(100,30,85,35);
		control_board.add(pause);
		pause.setEnabled(false);
		pause.setFont(new Font("Sancerif",Font.BOLD,9));
		pause.addActionListener (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				if (pause.getText().equals("PAUSE")) {
					pause.setText("CONTINUE");
					Window.setDifficultyChangable(true);
					ProcessControl.isPause = true;
				}else if (pause.getText().equals("CONTINUE")) {
					pause.setText("PAUSE");
					Window.setDifficultyChangable(false);
					ProcessControl.isPause = false;
				}
			}
		});
		
		restart.setBounds(195,30,75,35);
		restart.setEnabled(false);
		control_board.add(restart);
		restart.setFont(new Font("Sancerif",Font.BOLD,9));
		restart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				Window.setDifficultyChangable(false);
				ProcessControl.restartWait = false;
				ProcessControl.isPause = false;
				pause.setEnabled(true);
				Game.main_blocks.restart();
			}
		});
		
		//set map
		c.add(Map_panel);
		Map_panel.setSize(270, 470);
		Map_panel.setLocation(5,10);
		Map_panel.setBorder(BorderFactory.createEmptyBorder());
		
		
		//set info board
		c.add(infoBoard);
		infoBoard.setBounds(275, 0, 200, 590);
		infoBoard.setLayout(null);
		
		infoBoard.add(game_title);
		game_title.setFont(new Font("Sancerif",Font.ITALIC,25));
		game_title.setForeground(Color.MAGENTA);
		game_title.setBounds(15, 20, 100, 50);
		
		infoBoard.add(next);
		next.setFont(new Font("Sancerif",Font.ITALIC,23));
		next.setForeground(Color.BLUE);
		next.setBounds(35, 90, 100, 50);
		
		infoBoard.add(timer);
		timer.setFont(new Font("Sancerif",Font.BOLD,13));
		timer.setBounds(10, 280, 100, 50);
		timer.setVisible(true);
		
		infoBoard.add(score);
		score.setFont(new Font("Sancerif",Font.BOLD,13));
		score.setBounds(10, 330, 100, 50);
		score.setVisible(true);
		
		infoBoard.add(nextBlock);
		nextBlock.setFont(new Font("Sancerif",Font.ITALIC,25));
		nextBlock.setBounds(25, 140, 68, 120);
		nextBlock.setBorder(BorderFactory.createTitledBorder(""));
		
		difficulty.add(slow);
		difficulty.add(normal);
		difficulty.add(hard);
		difficulty.add(increase);
		infoBoard.add(slow);
		infoBoard.add(normal);
		infoBoard.add(hard);
		infoBoard.add(increase);
		slow.setBounds(5, 390, 100, 25);
		normal.setBounds(5, 420, 100, 25);
		hard.setBounds(5, 450, 100, 25);
		increase.setBounds(5, 480, 150, 25);
		normal.setSelected(true);
		
		whole_next_image = MapGrid.generate(nextBlock, 4, 2);//control the changing of next.
	
	}
	
	public void deadDialog() {
		ProcessControl.isPause = true;
		ProcessControl.restartWait = true;
		JDialog dead = new JDialog(Game.Win,true);
		dead.setTitle("DEAD");
		dead.setBounds(300, 300, 300, 300);
		dead.setDefaultCloseOperation(HIDE_ON_CLOSE);
		dead.setLayout(null);
		JLabel deadText = new JLabel("YOU DEAD!");
		dead.add(deadText);
		deadText.setBounds(80, 100, 150, 50);
		deadText.setFont(new Font("Sancerif",Font.BOLD,19));
		deadText.setForeground(Color.RED);
		dead.setVisible(true);
		Window.setDifficultyChangable(true);
		Game.Win.pause.setEnabled(false);
		ProcessControl.init();
	}
	
	public static void setDifficultyChangable(boolean isChangable) {
		slow.setEnabled(isChangable);
		normal.setEnabled(isChangable);
		hard.setEnabled(isChangable);
		increase.setEnabled(isChangable);
	}
	
	public static int getDifficultyVelocity() {
		if (slow.isSelected()) return -150;
		if (normal.isSelected()) return 0;
		if (hard.isSelected())  return 150;
		if(increase.isSelected())	return -50 + (int)Game.timer / 5 * 30;
		
		return 0;
		
	}
}