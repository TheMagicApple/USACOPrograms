import java.util.Scanner;

public class Springboards {
	private static int n;
	private static int pSpringboards;
	private static int[][][] springboards;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		pSpringboards=s.nextInt();
		springboards=new int[pSpringboards][2][2];
		for(int i=0;i<pSpringboards;i++) {
			int[] coord1=new int[2];
			coord1[0]=s.nextInt();
			coord1[1]=s.nextInt();
			int[] coord2=new int[2];
			coord2[0]=s.nextInt();
			coord2[1]=s.nextInt();
			int[][] springboard=new int[2][2];
			springboard[0]=coord1;
			springboard[1]=coord2;
			springboards[i]=springboard;
		}
		int currentX=0;
		int currentY=0;
		int stepsTaken=0;
		while(currentX!=n || currentY!=n) {
			int minimumDist=99999;
			int springX=-2;
			int springY=-2;
			for(int[][] springboard:springboards) {
				int dist=(springboard[0][0]-currentX)+(springboard[0][1]-currentY);
				if(springboard[0][0]<=n && springboard[0][1]<=n && springboard[1][0]<=n && springboard[1][1]<=n) {
					if(dist>=0) {
						if(dist<minimumDist) {
							minimumDist=dist;
							springX=springboard[1][0];
							springY=springboard[1][1];
						}
					}
				}
				
				
			}
			if(minimumDist==99999) {
				stepsTaken+=(n-currentX)+(n-currentY);
				currentX=n;
				currentY=n;
			}else {
				stepsTaken+=minimumDist;
				currentX=springX;
				currentY=springY;
			}
			
			
		}
		System.out.println(stepsTaken);
		
		

	}

}
