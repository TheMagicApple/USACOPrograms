import java.util.Scanner;
public class PaintingTheBarn {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int k=s.nextInt();
		int[][] rectangles=new int[n][4];
		for(int i=0;i<n;i++) {
			rectangles[i]=new int[] {s.nextInt(),s.nextInt(),s.nextInt(),s.nextInt()};
		}
		int[][] wall=new int[1001][1001];
		for(int[] rectangle:rectangles) {
			int startX=rectangle[0];
			int startY=rectangle[1];
			int endX=rectangle[2];
			int endY=rectangle[3];
			for(int i=startY;i<endY;i++) {
				wall[i][startX]++;
				wall[i][endX]--;
			}
		}
		int[][] realWall=new int[1001][1001];
		int change=0;
		for(int i=0;i<realWall.length;i++) {
			for(int j=0;j<realWall[i].length;j++) {
				change+=wall[i][j];
				realWall[i][j]+=change;
			}
		}
		int answer=0;
		for(int i=0;i<realWall.length;i++) {
			for(int j=0;j<realWall[i].length;j++) {
				if(realWall[i][j]==k) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}