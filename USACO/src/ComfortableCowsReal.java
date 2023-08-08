import java.util.Scanner;

public class ComfortableCowsReal {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[][] cows=new int[n][2];
		for(int i=0;i<n;i++) {
			int[] cow=new int[2];
			cow[0]=s.nextInt();
			cow[1]=s.nextInt();
			cows[i]=cow;
		}
		int[][] farm=new int[1005][1005];
		int addedCows=0;
		for(int i=0;i<n;i++) {
			if(i==n-1) {
				for(int a=0;a<10;a++) {
					for(int b=0;b<10;b++) {
						System.out.print(farm[b][a]+" ");
					}
					System.out.println();
				}
			}
			for(int k=0;k<5;k++) {
				
				int x;
				int y;
				if(k==0) {
					x=cows[i][0]+2;
					y=cows[i][1]+2;
				}else if(k==1) {
					x=cows[i][0]+3;
					y=cows[i][1]+2;
				}else if(k==2) {
					x=cows[i][0]+1;
					y=cows[i][1]+2;
				}else if(k==3) {
					x=cows[i][0]+2;
					y=cows[i][1]+3;
				}else {
					x=cows[i][0]+2;
					y=cows[i][1]+1;
				}
				
				if(k==0) {
					if(farm[y][x]==1) {
						addedCows--; //if occupied by added cow, remove added cow and replace with natural cow
						//System.out.println(x-2+" "+(y-2)+" "+k);
					}
					farm[y][x]=1; //add a cow
					
				}
				
				int adjacentCows=0;
				if(farm[y+1][x]==1) adjacentCows++; //count number of adjacent cows
				if(farm[y-1][x]==1) adjacentCows++;
				if(farm[y][x+1]==1) adjacentCows++;
				if(farm[y][x-1]==1) adjacentCows++;
				if(adjacentCows==3) {
					farm[y+1][x]=1; //fill in the missing gap with an added cow
					farm[y-1][x]=1;
					farm[y][x+1]=1;
					farm[y][x-1]=1;
					addedCows++;
				}
				
			}
			System.out.println(addedCows);
			
			
		}
	}

}
