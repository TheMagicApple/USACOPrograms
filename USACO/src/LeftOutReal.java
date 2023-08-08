import java.util.Arrays;
import java.util.Scanner;

public class LeftOutReal {
	private static int n;
	private static String[][] cows;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		cows=new String[n][n];
		for(int i=0;i<n;i++) {
			cows[i]=s.next().split("");
		}
		int goodI=-1;
		int goodK=-1;
		int startI=0;
		int endI=1;
		int startK=0;
		int endK=1;
		gogo:
		for(int row=0;row<n-1;row++) {
			for(int col=0;col<n-1;col++) {
				String uL=cows[row][col];
				String uR=cows[row][col+1];
				String dL=cows[row+1][col];
				String dR=cows[row+1][col+1];
				
				int right=0;
				int left=0;
				if(uL.equals("R")) {
					right++;
				}else {
					left++;
				}
				if(uR.equals("R")) {
					right++;
				}else {
					left++;
				}
				if(dL.equals("R")) {
					right++;
				}else {
					left++;
				}
				if(dR.equals("R")) {
					right++;
				}else {
					left++;
				}
				if((right==3 && left==1) || (left==3 && right==1)) {
					startI=row;
					endI=row+1;
					startK=col;
					endK=col+1;
					break gogo;
				}
				
			}
		}
		
		go:
		for(int i=startI;i<=endI;i++) {
			for(int k=startK;k<=endK;k++) {
				
				String cowToFlip=cows[i][k];
				if(cowToFlip.equals("R")) {
					cows[i][k]="L";
				}else {
					cows[i][k]="R";
				}
				
				boolean impossible=false;
				gogo:
				for(int row=0;row<n-1;row++) {
					for(int col=0;col<n-1;col++) {
						String uL=cows[row][col];
						String uR=cows[row][col+1];
						String dL=cows[row+1][col];
						String dR=cows[row+1][col+1];
						
						int right=0;
						int left=0;
						if(uL.equals("R")) {
							right++;
						}else {
							left++;
						}
						if(uR.equals("R")) {
							right++;
						}else {
							left++;
						}
						if(dL.equals("R")) {
							right++;
						}else {
							left++;
						}
						if(dR.equals("R")) {
							right++;
						}else {
							left++;
						}
						if((right==3 && left==1) || (left==3 && right==1)) {
							impossible=true;
							break gogo;
						}
						
					}
				}
				if(!impossible) {
					goodI=i+1;
					goodK=k+1;
					break go;
				}
				
				//GOOD BELOW
				if(cows[i][k].equals("R")) {
					cows[i][k]="L";
				}else {
					cows[i][k]="R";
				}
				
			}
		}
		if(goodI==-1) {
			System.out.println(-1);
		}else {
			System.out.println(goodI+" "+goodK);
		}
		/*
		go:
			for(int row=0;row<n-1;row++) {
				for(int col=0;col<n-1;col++) {
					String uL=cows[row][col];
					String uR=cows[row][col+1];
					String dL=cows[row+1][col];
					String dR=cows[row+1][col+1];
					
					int right=0;
					int left=0;
					if(uL.equals("R")) {
						right++;
					}else {
						left++;
					}
					if(uR.equals("R")) {
						right++;
					}else {
						left++;
					}
					if(dL.equals("R")) {
						right++;
					}else {
						left++;
					}
					if(dR.equals("R")) {
						right++;
					}else {
						left++;
					}
					if((right==3 && left==1) || (left==3 && right==1)) {
						String newUL;
						if(uL.equals("R")) {
							newUL="L";
						}else {
							newUL="R";
						}
						int[][][] neighborsAffected= {{{row,col-1},{row-1,col-1},{row-1,col}},{{row-1,col},{row-1,col+1},{row,col}},{{row,col-1},{row+1,col-1},{row+1,col}}};
						for(int[][] neighborGroup:neighborsAffected) {
							int count=0;
							if(cows[neighborGroup[0][0]][neighborGroup[0][1]].equals(newUL)) {
								count++;
							}
							if(cows[neighborGroup[1][0]][neighborGroup[1][1]].equals(newUL)) {
								count++;
							}
							if(cows[neighborGroup[2][0]][neighborGroup[2][1]].equals(newUL)) {
								count++;
							}
							if(count!=2) {
								goodI=row+1;
								goodK=col+1;
								break go;
							}
						}
						
						String newUR;
						if(uR.equals("R")) {
							newUR="L";
						}else {
							newUR="R";
						}
						int[][][] neighborsAffected2= {{{};
						for(int[][] neighborGroup:neighborsAffected2) {
							int count=0;
							if(cows[neighborGroup[0][0]][neighborGroup[0][1]].equals(newUL)) {
								count++;
							}
							if(cows[neighborGroup[1][0]][neighborGroup[1][1]].equals(newUL)) {
								count++;
							}
							if(cows[neighborGroup[2][0]][neighborGroup[2][1]].equals(newUL)) {
								count++;
							}
							if(count!=2) {
								goodI=row+1;
								goodK=col+1;
								break go;
							}
						}
						
						String newDL;
						if(dL.equals("R")) {
							newDL="L";
						}else {
							newDL="R";
						}
						int[][][] neighborsAffected3= {{{row,col-1},{row-1,col-1},{row-1,col}},{{row-1,col},{row-1,col+1},{row,col}},{{row,col-1},{row+1,col-1},{row+1,col}}};
						for(int[][] neighborGroup:neighborsAffected3) {
							int count=0;
							if(cows[neighborGroup[0][0]][neighborGroup[0][1]].equals(newUL)) {
								count++;
							}
							if(cows[neighborGroup[1][0]][neighborGroup[1][1]].equals(newUL)) {
								count++;
							}
							if(cows[neighborGroup[2][0]][neighborGroup[2][1]].equals(newUL)) {
								count++;
							}
							if(count!=2) {
								goodI=row+1;
								goodK=col+1;
								break go;
							}
						}
						
						String newDR;
						if(dR.equals("R")) {
							newDR="L";
						}else {
							newDR="R";
						}
						int[][][] neighborsAffected4= {{{row,col-1},{row-1,col-1},{row-1,col}},{{row-1,col},{row-1,col+1},{row,col}},{{row,col-1},{row+1,col-1},{row+1,col}}};
						for(int[][] neighborGroup:neighborsAffected4) {
							int count=0;
							if(cows[neighborGroup[0][0]][neighborGroup[0][1]].equals(newUL)) {
								count++;
							}
							if(cows[neighborGroup[1][0]][neighborGroup[1][1]].equals(newUL)) {
								count++;
							}
							if(cows[neighborGroup[2][0]][neighborGroup[2][1]].equals(newUL)) {
								count++;
							}
							if(count!=2) {
								goodI=row+1;
								goodK=col+1;
								break go;
							}
						}
					}
					
				}
			}
		/*
		for(int i=0;i<n;i++) {
			for(int k=0;k<n;k++) {
				
				String cowToFlip=cows[i][k];
				if(cowToFlip.equals("R")) {
					cows[i][k]="L";
				}else {
					cows[i][k]="R";
				}
				
				boolean impossible=false;
				gogo:
				for(int row=0;row<n-1;row++) {
					for(int col=0;col<n-1;col++) {
						String uL=cows[row][col];
						String uR=cows[row][col+1];
						String dL=cows[row+1][col];
						String dR=cows[row+1][col+1];
						
						int right=0;
						int left=0;
						if(uL.equals("R")) {
							right++;
						}else {
							left++;
						}
						if(uR.equals("R")) {
							right++;
						}else {
							left++;
						}
						if(dL.equals("R")) {
							right++;
						}else {
							left++;
						}
						if(dR.equals("R")) {
							right++;
						}else {
							left++;
						}
						if((right==3 && left==1) || (left==3 && right==1)) {
							impossible=true;
							break gogo;
						}
						
					}
				}
				if(!impossible) {
					goodI=i+1;
					goodK=k+1;
					break go;
				}
				
				//GOOD BELOW
				if(cows[i][k].equals("R")) {
					cows[i][k]="L";
				}else {
					cows[i][k]="R";
				}
				counter++;
			}
		}
		*/
		
		
	}

}
