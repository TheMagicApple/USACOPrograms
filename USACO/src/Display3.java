import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;


public class Display3 extends JPanel{
	
	private static int WIDTH = 1000;
	private static int HEIGHT = 800;
	private int scale = 20;
	
	private Billboard board1 ;
	private Billboard board2 ;

	
	private Billboard[] boards;
	
	private JFrame frame;
	
	public Display3(Billboard board1,Billboard board2) {
		this.board1 = board1;
		this.board2 = board2;
		
		boards = new Billboard[] {board1,board2};
		
		frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setContentPane(this);
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String args[]) {
		
		Display3 display = new Display3(
				new Billboard(2, 1, 7, 4),
				new Billboard(5, -1, 10, 3)
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
			if(board == board2) {g.setColor(Color.red);};
			g.fillRect( board.lx*scale+WIDTH/2, (-((board.ly+board.height())*scale))+HEIGHT/2,board.length()*scale,board.height()*scale);
		}
		
		drawGraphLines(g);
		
		g.setColor(Color.black);
		Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
		g2.drawRect( board1.lx*scale+WIDTH/2, (-((board1.ly+board1.height())*scale))+HEIGHT/2,board1.length()*scale,board1.height()*scale);
		
		
	}

}
