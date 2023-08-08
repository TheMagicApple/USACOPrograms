import java.util.ArrayList;
import java.util.Scanner;

public class RangeReconstruction {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[][] differences=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int k=i;k<n;k++) {
				differences[i][k]=s.nextInt();
			}
		}
		ArrayList<Integer> distinct=new ArrayList<>();
		distinct.add(0);
		for(int i=1;i<n;i++) {
			if(differences[i-1][i]!=0) {
				distinct.add(i);
			}
		}
		System.out.println(distinct);
		int[] answer=new int[n];
		if(distinct.size()>1) {
			answer[distinct.get(1)]=differences[0][distinct.get(1)];
			for(int i=2;i<distinct.size();i++) {
				int a=distinct.get(i-2);
				int b=distinct.get(i-1);
				int c=distinct.get(i);
				int sign=differences[a][c]==differences[a][b]+differences[b][c]?1:-1;
				answer[c]=answer[b]+(sign*Integer.signum(answer[b]-answer[a])*differences[b][c]);
			}
			for(int i=1;i<n;i++) {
				if(differences[i-1][i]==0) {
					answer[i]=answer[i-1];
				}
			}
		}
		for(int i=0;i<n;i++) {
			System.out.print(answer[i]+" ");
		}

	}

}
