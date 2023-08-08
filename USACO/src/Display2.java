import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;


public class Display2 extends JPanel{
	
	private static int WIDTH = 1000;
	private static int HEIGHT = 800;
	private int scale = 20;
	
	private Billboard board1 ;
	private Billboard board2 ;
	private Billboard board3 ;
	
	private Billboard[] boards;
	
	private JFrame frame;
	
	public Display2(Billboard board1,Billboard board2,Billboard board3) {
		this.board1 = board1;
		this.board2 = board2;
		this.board3 = board3;
		boards = new Billboard[] {board1,board2,board3};
		
		frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setContentPane(this);
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String args[]) {
		
		Display2 display = new Display2(
				new Billboard(1,2,3,5),
				new Billboard(6,0,10,4),
				new Billboard(2,1,8,3)
				);
	}
	
	public void drawGraphLines(Graphics g) {
		
		g.setColor(Color.gray);
		
		for(int i = 0; i < WIDTH; i+=scale) {
			g.drawLine(i, 0, i, HEIGHT);
		}
		
		for(int i = 0; i < HEIGHT; i+=scale) {
			g.drawLine(0, i, WIDTH, i);
		}
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		g.setColor(Color.black);
		for(Billboard board : boards) {
			if(board == board3) {g.setColor(Color.red);};
			
			g.fillRect( board.lx*scale+WIDTH/2, (-((board.ly+board.height())*scale))+HEIGHT/2,board.length()*scale,board.height()*scale);
		}
		
		drawGraphLines(g);
	}

}
