import java.util.ArrayList;
import java.util.Scanner;

public class LeftOut {
	private static int n;
	private static int[][] cows;
	private static int[][][] blocks;
	private static ArrayList<int[][]> badBlocks=new ArrayList<>(); 
	private static ArrayList<int[]> badPositions=new ArrayList<>();
	private static int perfectGrids=0;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		cows=new int[n][n];
		blocks=new int[(int) Math.pow(2,n-1)][2][2];
		for(int i=0;i<n;i++) {
			int[] cow=new int[n];
			
			String string=s.next();
			//System.out.println("string: "+string);
			String[] chars=string.split("");
			for(int a=0;a<n;a++) {
				if(chars[a].equals("R")) {
					cow[a]=0;
					//System.out.println("equals r");
				}else {
					cow[a]=1;
					//System.out.println("equals l");
				}
			}
			
				
			
			cows[i]=cow;
		}
		for(int b=0;b<100;b++) {
			int[][] cows2=cows.clone();
		
		for(int i=0;i<5;i++) {
			
		
			int a=(int)(Math.random()*n);
			int a2=(int)(Math.random()*n);
			flipR(a);
			flipC(a2);
			int cowLs=0;
			int cowRs=0;
			for(int[] row:cows2) {
				for(int cow:row) {
					cowLs+=cow;
				}
			}
			cowRs=(n*n)-cowLs;
			if(cowRs==0) {
				//System.out.println("-1");
				perfectGrids++;
				break;
			}else if(cowLs==0) {
				//System.out.println(-1);
				break;
			}else if(cowRs==1) {
				for(int k=0;k<cows2.length;k++) {
					for(int j=0;j<cows2.length;j++) {
						if(cows2[k][j]==0) {
							int[] position=new int[2];
							position[0]=k+1;
							position[1]=j+1;
							//System.out.println("position: "+position[0]+" "+position[1]);
							badPositions.add(position);
						}
					}
				}
				break;
			}else if(cowLs==1) {
				for(int k=0;k<cows2.length;k++) {
					for(int j=0;j<cows2.length;j++) {
						if(cows2[k][j]==1) {
							int[] position=new int[2];
							position[0]=k+1;
							position[1]=j+1;
							//System.out.println("position: "+position[0]+" "+position[1]);
							badPositions.add(position);
						}
					}
				}
				break;
			}
			
			
		
		}
		}
		/*
		for(int[] i:cows) {
			for(int ii:i) {
				System.out.print(ii);
			}
			System.out.println();
		}
		
		System.out.println("number of bad positions; "+badPositions.size());
		for(int[] position:badPositions) {
			for(int i:position) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
		*/
		if(perfectGrids==100) {
			System.out.println(-1);
		}else {
			
		
		int lowestX=Integer.MAX_VALUE;
		int lowestY=Integer.MAX_VALUE;
		for(int[] position:badPositions) {
			if(position[0]<lowestX) {
				lowestX=position[0];
			}
			if(position[1]<lowestY) {
				lowestY=position[1];
			}
		}
		System.out.println(lowestX+" "+lowestY);
		}
		/*
		int counter=0;
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<n-1;j++) {
				int[][] block=new int[2][2];
				block[0][0]=cows[i][j];
				block[0][1]=cows[i+1][j];
				block[1][0]=cows[i][j+1];
				block[1][1]=cows[i+1][j+1];
				blocks[counter]=block;
				counter++;
			}
		}
		/*
		for(int[][] block:blocks) {
			for(int[] i:block) {
				for(int ii:i) {
					//System.out.print(ii);
				}
				//System.out.println();
			}
			//System.out.println();
		}
		*/
		/*
		for(int[][] block:blocks) {
			int numL=0;
			int numR=0;
			numL+=block[0][0];
			numL+=block[0][1];
			numL+=block[1][0];
			numL+=block[1][1];
			numR=4-numL;
			if(numR==1 || numL==1) {
				//bad
				badBlocks.add(block);
			}else {
				//good
			}
			
		}
		for(int[][] badBlock:badBlocks) {
			
		}
		*/
		
	}
	public static void flipR(int row) {
		for(int i=0;i<n;i++) {
			if(cows[row][i]==0) {
				cows[row][i]=1;
				//System.out.println("making it 1");
			}
			else if(cows[row][i]==1) {
				cows[row][i]=0;
			}
		}
	}
	public static void flipC(int column) {
		for(int i=0;i<n;i++) {
			if(cows[i][column]==0) {
				cows[i][column]=1;
			}
			if(cows[i][column]==1) {
				cows[i][column]=0;
			}
		}
	}

}
