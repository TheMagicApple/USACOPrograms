import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Convention2 {
	private static int nCows;
	private static int[][] cows;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		nCows=s.nextInt();
		ArrayList<ArrayList<Integer>> cows=new ArrayList<>();
		for(int i=0;i<nCows;i++) {
			ArrayList<Integer> cow=new ArrayList<>();
			cow.add(s.nextInt());
			cow.add(s.nextInt());
			cows.add(cow);
		}
		long startingTime=System.currentTimeMillis();
		int currentTime=0;
		boolean done=false;
		ArrayList<Integer> waitingTimes=new ArrayList<>();
		while(cows.size()>0) {
			boolean foundGo=false;
			int bestIndex=-2;
			for(int i=0;i<cows.size();i++) {
				if(cows.get(i).get(0)<=currentTime) {
					foundGo=true;
					bestIndex=i;
					break;
				}
			}
			if(foundGo) {
				waitingTimes.add(currentTime-cows.get(bestIndex).get(0));
				currentTime+=cows.get(bestIndex).get(1);
				cows.remove(bestIndex);
			}else {
				int leastDifference=Integer.MAX_VALUE;
				for(ArrayList<Integer> cow:cows) {
					if(cow.get(0)-currentTime<leastDifference) {
						leastDifference=cow.get(0)-currentTime;
					}
				}
				currentTime+=leastDifference;
			}
			//System.out.println("Time: "+currentTime);
		}
		Collections.sort(waitingTimes);
		System.out.println(waitingTimes.get(waitingTimes.size()-1));
		long endingTime=System.currentTimeMillis();
		System.out.println("Program took "+(endingTime-startingTime)+" ms");
		

	}

}
