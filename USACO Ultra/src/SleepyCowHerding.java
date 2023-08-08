import java.util.Arrays;
import java.util.Scanner;

public class SleepyCowHerding {
	static int[] cows;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		cows=new int[n];
		
		for(int i=0;i<n;i++) {
			cows[i]=s.nextInt();
		}
		Arrays.sort(cows);
		int moves=0;
		//int leftEndpoint=cows[0];
		//int rightEndpoint=cows[cows.length-1];
		while(true) {
			int leftDistanceClosed=cows[1]-cows[0];
			int rightDistanceClosed=cows[cows.length-1]-cows[cows.length-2];
			if(leftDistanceClosed>rightDistanceClosed) { //move the left one
				moveLeft();
			}else { //move the right one
				moveRight();
			}
			moves++;
			Arrays.sort(cows);
			boolean bad=false;
			for(int i=0;i<cows.length-1;i++) {
				if(cows[i+1]!=cows[i]+1) {
					bad=true;
					break;
				}
			}
			if(!bad) {
				break;
			}
		}
		System.out.println(moves);

	}
	static void moveLeft() {
		int newPosition=cows[1]+1;
		//cows[0]=cows[1]+1;
		int index=2;
		while(newPosition==cows[index]) { //blocked
			newPosition++;
			index++;
			if(index==cows.length) {
				moveRight();
				return;
			}
		}
		cows[0]=newPosition;
	}
	static void moveRight() {
		int newPosition=cows[cows.length-2]-1;
		//cows[0]=cows[1]+1;
		int index=cows.length-3;
		while(newPosition==cows[index]) { //blocked
			newPosition--;
			index--;
			if(index==-1) {
				moveLeft();
				return;
				
			}
		}
		cows[cows.length-1]=newPosition;
	}

}
