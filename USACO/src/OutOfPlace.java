import java.util.Scanner;

public class OutOfPlace {
	
	public static int[] cows;
	public static int swaps=0;
	public static boolean forwardCow=false;
	public static boolean backwardCow=false;
	public static int findOutOfPlace() {
		backwardCow=false;
		forwardCow=false;
		for(int i=1;i<cows.length;i++) {
			if(cows[i-1]>cows[i] && cows[i+1]>cows[i]) {
				backwardCow=true;
				return i;
				
			}
			if(cows[i-1]<cows[i] && cows[i+1]<cows[i]) {
				forwardCow=true;
				return i;
				
				
			}
		}
		return Integer.MIN_VALUE;
	}
	
	public static void efficientSwap() {
		int badCow=findOutOfPlace();
		//System.out.println(badCow);
		//System.out.println(badCow-1);
		if(backwardCow==true) {
			if(cows[badCow-2]<cows[badCow-1]) {
				//System.out.println(badCow);
				//System.out.println(badCow-1);
				swap(badCow-1,badCow);
				
			}else if(cows[badCow-2]==cows[badCow-1]) {
				
				swap(badCow-2,badCow);
			}
		}
		if(forwardCow==true) {
			if(cows[badCow+2]>cows[badCow+1]) {
				//System.out.println(badCow);
				//System.out.println(badCow-1);
				swap(badCow+1,badCow);
				
			}else if(cows[badCow+2]==cows[badCow+1]) {
				if(cows[badCow+3]>cows[badCow+2]) {
					swap(badCow+2,badCow);
				}else if(cows[badCow+3]==cows[badCow+2]) {
					swap(badCow+3,badCow);
				}
				
			}
		}
		
	}
	public static boolean done() {
		for(int i=0;i<cows.length-1;i++) {
			if(cows[i+1]<cows[i]) {
				return false;
			}
		}
		return true;
	}
	public static void swap(int goodCow,int badCow) {
		int t=cows[badCow];
		//System.out.println(badCow);
		//System.out.println(goodCow);
		cows[badCow]=cows[goodCow];
		cows[goodCow]=t;
	}
	public static int minumumSwaps(int start, int end) {
		
		return 0;
	}

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int numcows=s.nextInt();
		cows = new int[numcows+1];
		for(int i=0;i<numcows;i++) {
			cows[i]=s.nextInt();
		}
		cows[numcows]=cows[numcows-1]+1000000;
		for(int cow:cows) {
			//System.out.print(cow);
		}
		boolean complete=false;
		while(complete==false) {
			efficientSwap();
			swaps++;
			if(done()) {
				System.out.println(swaps);
				complete=true;
			}
		}
		
		//System.out.println(minumumSwaps( findOutOfPlace(), indexToMoveTo() ));
	}

}
