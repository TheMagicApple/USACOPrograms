import java.util.Scanner;

public class SpacedOut {

	public static void main(String[] args) {
		//watched a video
		Scanner s=new Scanner(System.in);
		int[][] matrix=new int[10][10];
		int[][] rowsum=new int[10][2];
		int[][] colsum=new int[10][2];
		int n=s.nextInt();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				matrix[i][j]=s.nextInt();
				rowsum[i][j%2]+=matrix[i][j];
				colsum[j][i%2]+=matrix[i][j];
			}
		}
		for(int[] row:rowsum) {
			System.out.print(row[0]+" "+row[1]+" - ");
			
		}
		System.out.println();
		for(int[] row:colsum) {
			System.out.print(row[0]+" "+row[1]+" - ");
			
		}
		System.out.println();
		int maxrowsum=0;
		int maxcolsum=0;
		for(int i=0;i<n;i++) {
			maxrowsum+=Math.max(rowsum[i][0], rowsum[i][1]);
			maxcolsum+=Math.max(colsum[i][0], colsum[i][1]);
		}
		System.out.println(Math.max(maxrowsum, maxcolsum));

	}

}
