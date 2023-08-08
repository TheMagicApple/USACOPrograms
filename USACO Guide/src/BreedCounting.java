//DONE & CORRECT
import java.util.Scanner;

public class BreedCounting {
	private static int n;
	private static int q;
	private static int[] cows;
	private static int[][] queries;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		q=s.nextInt();
		cows=new int[n];
		queries=new int[q][2];
		for(int i=0;i<n;i++) {
			cows[i]=s.nextInt();
		}
		for(int i=0;i<q;i++) {
			int[] query=new int[2];
			query[0]=s.nextInt()-1;
			query[1]=s.nextInt()-1;
			queries[i]=query;
		}
		int[] prefix1=new int[n+1];
		int[] prefix2=new int[n+1];
		int[] prefix3=new int[n+1];
		prefix1[0]=0;
		prefix2[0]=0;
		prefix3[0]=0;
		for(int i=1;i<n+1;i++) {
			if(i==1) {
				prefix1[i]=((cows[i-1]==1) ? 1 : 0);
			}else {
				prefix1[i]=prefix1[i-1]+((cows[i-1]==1) ? 1 : 0);
			}
		}
		for(int i=1;i<n+1;i++) {
			if(i==1) {
				prefix2[i]=((cows[i-1]==2) ? 1 : 0);
			}else {
				prefix2[i]=prefix2[i-1]+((cows[i-1]==2) ? 1 : 0);
			}
		}
		for(int i=1;i<n+1;i++) {
			if(i==1) {
				prefix3[i]=((cows[i-1]==3) ? 1 : 0);
			}else {
				prefix3[i]=prefix3[i-1]+((cows[i-1]==3) ? 1 : 0);
			}
		}
		/*
		for(int[] query:queries) {
			System.out.println(query[0]);
		}
		*/
		for(int[] query:queries) {
			System.out.println((prefix1[query[1]+1]-prefix1[query[0]])+" "+(prefix2[query[1]+1]-prefix2[query[0]])+" "+(prefix3[query[1]+1]-prefix3[query[0]]));
		}
		//1 1 2 1 3 3 1 2 2 1
		//between 2 and 5

	}

}
