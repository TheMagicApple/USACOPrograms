import java.util.ArrayList;
import java.util.Scanner;

public class BuildGates {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		s.nextInt();
		String[] fence=s.next().split("");
		int currentX=0;
		int currentY=0;
		ArrayList<int[]> visitedPoints=new ArrayList<>();
		int[] start=new int[2];
		start[0]=0;
		start[1]=0;
		visitedPoints.add(start);
		int gates=0;
		for(String move:fence) {
			int oldX=currentX;
			int oldY=currentY;
			if(move.equals("N")) {
				currentY++;
			}
			if(move.equals("S")) {
				currentY--;
			}
			if(move.equals("E")) {
				currentX++;
			}
			if(move.equals("W")) {
				currentX--;
			}
			int[] now=new int[2];
			now[0]=currentX;
			now[1]=currentY;
			boolean b=false;
			int counter=0;
			for(int[] visitedPoint:visitedPoints) {
				
				if(visitedPoint[0]==now[0] && visitedPoint[1]==now[1]) {
					b=true;
					//System.out.println("?");
				}
				if(visitedPoint[0]==oldX && visitedPoint[1]==oldY && counter!=visitedPoints.size()-1) {
					b=false;
					break;
				}
				counter++;
			}
			if(b) {
				gates++;
			}
			visitedPoints.add(now);
			//System.out.println(visitedPoints);
		}
		System.out.println(gates);

	}

}
