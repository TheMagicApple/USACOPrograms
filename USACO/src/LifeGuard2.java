import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;



//Update display

public class LifeGuard2 {
	
	public int start;
	public int end;
	
	public static List<LifeGuard2> guards = new ArrayList<LifeGuard2>();
	
	public static int[] cowsPerHour = new int[1001];
	
	public LifeGuard2(int start, int end) {
		this.start = start;
		this.end = end;
		
		guards.add(this);
		
		for(int i = start; i < end;i++) {
			cowsPerHour[i]++;
		}
	}
	
	public static int totalTimeCovered() {
		// Finds the time covered by all the cows
		
		int time = 0;
		
		for(int i = 0; i < 1000;i++) {
			if(cowsPerHour[i ] >= 1 ) {
				time++;
			}
		}
		
		return time;	
	}
	
	public int timeCovered() {
		
		int time = 0;
		
		for(int i = start; i < end-1;i++) {
			if(cowsPerHour[i]== 1 ) {
				time++;
			}
		}
		return time;
	}
	
	

	
	public int totalTimeCoveredIfMissing() {
		return totalTimeCovered() - timeCovered();
	}
	
	
	public static int largestTimeAfterFire() {
		
		int largest = 0;
		
		for(LifeGuard2 guard : guards) {
			
			if(guard.totalTimeCoveredIfMissing() > largest) {
				largest =  guard.totalTimeCoveredIfMissing();
			}
		}
		
		return largest;
	}


	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i=0; i < n ; i++) {
			
			new LifeGuard2(scan.nextInt(),scan.nextInt());
		}
		
		
		/*
		new LifeGuard(5,9);
		new LifeGuard(1,4);
		new LifeGuard(3,7);
		*/

		System.out.println( largestTimeAfterFire() );
		
		guards.sort( (l1,l2) -> l1.start - l2.start  );
		
		//new Display(guards);
		

	}
	

}
