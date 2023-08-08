import java.util.Scanner;

public class CowDanceShow {
	static int[] cows;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int t=s.nextInt();
		cows=new int[n];
		for(int i=0;i<n;i++) cows[i]=s.nextInt();
		int left=0;
		int right=1000000;
		int mid=(left+right)/2;
		
		while(left<right) {
			mid=left+(right-left)/2;
			
			if(calculate(mid)<=t) {
				right=mid;
			}else {
				left=mid+1;
			}
			
			
		}
		System.out.println(calculate(6));
		System.out.println((left+right)/2);
		
		//System.out.println(calculate(3));

	}
	static int calculate(int k) {
		int[] stage=new int[k];
		int onStage=0;
		for(int i=0;i<cows.length;i++) {
			if(onStage<k) {
				stage[onStage]+=cows[i];
				onStage++;
			}else {
				onStage=0;
				i--;
			}
		}
		
		int maxTime=0;
		for(int cow:stage) {
			if(cow>maxTime) {
				maxTime=cow;
			}
		}
		return maxTime;
	}

}
