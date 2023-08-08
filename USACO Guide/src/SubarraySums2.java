//DONE & 6/23
import java.util.Scanner;

public class SubarraySums2 {
	private static int n;
	private static int x;
	private static int[] nmbs;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		x=s.nextInt();
		nmbs=new int[n];
		for(int i=0;i<n;i++) {
			nmbs[i]=s.nextInt();
		}
		long[] prefix=new long[n+1];
		prefix[0]=0;
		for(int i=1;i<n+1;i++) {
			if(i==1) {
				prefix[i]=nmbs[i-1];
			}else {
				prefix[i]=prefix[i-1]+nmbs[i-1];
			}
		}
		int range=n;
		int counter=0;
		boolean done=false;
		while(range>0) {
			for(int i=0;i<n;i+=1) {
				if(i+range<=n) {
					long sum=prefix[i+range]-prefix[i];
					if(sum==x) {
						counter++;
					}
				}
			}
			range--;
		}
		System.out.println(counter);

	}

}
