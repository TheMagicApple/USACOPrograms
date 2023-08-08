import java.util.Arrays;
import java.util.Scanner;

public class Convention {
	private static int n;
	private static int m;
	private static int c;
	private static int[] cows;
	public static void main(String[] args) {
		//success!
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		m=s.nextInt();
		c=s.nextInt();
		cows=new int[n];
		for(int i=0;i<n;i++) {
			cows[i]=s.nextInt();
		}
		Arrays.sort(cows);
		int left=0;
		int right=1000000000;
		int mid=(left+right)/2;
		while(left<right) {
			mid=(left+right)/2;
			if(simulate(mid)) {
				right=mid;
			}else {
				left=mid+1;
			}
		}
		System.out.println((left+right)/2);
	}
	public static boolean simulate(int waitingTime) {
		int busesLeft=m;
		int nextDeparture=cows[0]+waitingTime;
		int currentCapacity=0;
		for(int i=0;i<cows.length;i++) {
			if(nextDeparture<cows[i]) {
				if(i==cows.length-1) busesLeft--;
				else nextDeparture=cows[i]+waitingTime;
				currentCapacity=1;
				busesLeft--;
			}else {
				currentCapacity++;
				if(currentCapacity==c) {
					if(i==cows.length-1) {
						break;
					}
					nextDeparture=cows[i+1]+waitingTime;
					currentCapacity=0;
					busesLeft--;
				}
			}
		}
		return busesLeft>0;
	}
}