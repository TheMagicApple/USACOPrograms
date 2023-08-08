//DONE & CORRECT
import java.util.Scanner;

public class SubsequencesSummingSevens {
	private static int n;
	private static int[] cows;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		cows=new int[n];
		for(int i=0;i<n;i++) {
			cows[i]=s.nextInt();
		}
		long[] prefix=new long[n+1];
		prefix[0]=0;
		for(int i=1;i<n+1;i++) {
			if(i==1) {
				prefix[i]=cows[i-1];
			}else {
				prefix[i]=prefix[i-1]+cows[i-1];
			}
		}
		int range=n;
		boolean done=false;
		while(!done) {
			for(int i=0;i<n;i+=1) {
				if(i+range<=n) {
					long sum=prefix[i+range]-prefix[i];
					if(sum%7==0) {
						done=true;
						
					}
				}
				
			}
			range--;
		}
		System.out.println(range+1);
	}

}
