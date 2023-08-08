import java.util.Scanner;

public class FollowingDirections {

	public static void main(String[] args) {
		//ac :)
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[][] field=new int[n+1][n+1];
		for(int i=0;i<n;i++) {
			String[] directions=s.next().split("");
			for(int j=0;j<n;j++) {
				if(directions[j].equals("D")) {
					field[i][j]=1;
				}
			}
			field[i][n]=s.nextInt();
		}
		for(int i=0;i<n;i++) {
			field[n][i]=s.nextInt();
		}
		int q=s.nextInt();
		int[][] queries=new int[q][2];
		for(int i=0;i<q;i++) {
			queries[i]=new int[] {s.nextInt(),s.nextInt()};
		}
		int[][] cows=new int[n+1][n+1];
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<n+1;j++) {
				if(i==n || j==n) {
					cows[i][j]=field[i][j];
				}else {
					cows[i][j]=1;
				}
			}
		}
		int ogCost=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!(i==n && j==n)) {
					if(field[i][j]==0) {
						if(j==n-1) {
							ogCost+=cows[i][j+1]*cows[i][j];
						}else {
							cows[i][j+1]+=cows[i][j];
						}
						
					}else {
						if(i==n-1) {
							ogCost+=cows[i+1][j]*cows[i][j];
						}else {
							cows[i+1][j]+=cows[i][j];
						}
						
					}
				}
				
			}
		}
		System.out.println(ogCost);
		for(int[] query:queries) {
				int i=query[0]-1;
				int j=query[1]-1;
				int cowsDiverted=cows[i][j];
				while(i<n && j<n) {
					if(field[i][j]==0) {
						
						if(j!=n-1)cows[i][j+1]-=cowsDiverted;
						j++;
					}else {
						if(i!=n-1)cows[i+1][j]-=cowsDiverted;
						i++;
					}
				}
				if(i==n) {
					ogCost-=cowsDiverted*cows[i][j];
				}else if(j==n) {
					ogCost-=cowsDiverted*cows[i][j];
				}
				
				if(field[query[0]-1][query[1]-1]==0) {
					field[query[0]-1][query[1]-1]=1;
				}else {
					field[query[0]-1][query[1]-1]=0;
				}
				i=query[0]-1;
				j=query[1]-1;
				while(i<n && j<n) {
					if(field[i][j]==0) {
						if(j!=n-1)cows[i][j+1]+=cowsDiverted;
						j++;
					}else {
						if(i!=n-1)cows[i+1][j]+=cowsDiverted;
						i++;
					}
				}
				if(i==n) {
					ogCost+=cowsDiverted*cows[i][j];
				}else if(j==n) {
					ogCost+=cowsDiverted*cows[i][j];
				}
				System.out.println(ogCost);
			
		}
	}

}
