//DONE & CORRECT
import java.util.Scanner;
public class CowCrossRoad2 {
	private static int n;
	private static int[] roads;
	private static int k;
	private static int b;
	private static int[] brokenRoads;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		k=s.nextInt();
		b=s.nextInt();
		roads=new int[n];
		brokenRoads=new int[b];
		for(int i=0;i<n;i++) {
			roads[i]=1;
		}
		for(int i=0;i<b;i++) {
			brokenRoads[i]=s.nextInt()-1;
			roads[brokenRoads[i]]=0;
		}
		int[] prefix=new int[n+1];
		for(int i=1;i<n+1;i++) {
			prefix[i]=prefix[i-1]+roads[i-1];
		}
		int leastDifference=Integer.MAX_VALUE;
		for(int i=0;i<=n-k;i++) {
			int diff=k-(prefix[i+k]-prefix[i]);
			if(diff<leastDifference) {
				leastDifference=diff;
			}
		}
		System.out.println(leastDifference);
	}
}