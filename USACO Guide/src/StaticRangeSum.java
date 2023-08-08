//DONE & CORRECT
import java.util.Scanner;

public class StaticRangeSum {
	private static int n;
	private static int q;
	private static int[] a;
	private static int[][] queries;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		q=s.nextInt();
		a=new int[n];
		
		queries=new int[q][2];
		for(int i=0;i<n;i++) {
			a[i]=s.nextInt();
		}
		for(int i=0;i<q;i++) {
			int[] query=new int[2];
			query[0]=s.nextInt();
			query[1]=s.nextInt();
			queries[i]=query;
		}
		long[] prefix=new long[n+1];
		prefix[0]=0;
		for(int i=1;i<n+1;i++) {
			if(i==1) {
				prefix[i]=a[i-1];
			}else {
				prefix[i]=prefix[i-1]+a[i-1];
			}
		}
		/*
		for(int i:prefix) {
			System.out.println(i);
		}
		*/
		for(int[] query:queries) {
			
			System.out.println(prefix[query[1]]-prefix[query[0]]);
		}
	}

}
