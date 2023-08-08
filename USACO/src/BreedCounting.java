import java.util.Scanner;
public class BreedCounting {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int q=s.nextInt();
		int[] cows=new int[n];
		for(int i=0;i<n;i++) {
			cows[i]=s.nextInt();
		}
		int[][] cowSums=new int[n+1][3];
		for(int i=1;i<=n;i++) {
			int[] prev=cowSums[i-1].clone();
			prev[cows[i-1]-1]++;
			cowSums[i]=prev;
		}
		for(int i=0;i<q;i++) {
			int[] query=new int[2];
			query[0]=s.nextInt();
			query[1]=s.nextInt();
			int[] first=cowSums[query[1]];
			int[] second=cowSums[query[0]-1];
			System.out.println((first[0]-second[0])+" "+(first[1]-second[1])+" "+(first[2]-second[2]));
		}
	}
}