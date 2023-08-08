import java.util.Scanner;

public class TheGreatRevegetation {
	private static int nPastures;
	private static int mCows;
	private static int[][] cows;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		nPastures=s.nextInt();
		mCows=s.nextInt();
		cows=new int[mCows][3];
		for(int i=0;i<mCows;i++) {
			String type=s.next();
			if(type.equals("S")) {
				cows[i][0]=0;
			}else {
				cows[i][0]=1;
			}
			cows[i][1]=s.nextInt();
			cows[i][2]=s.nextInt();
		}
		int totalWays=(int) Math.pow(2, nPastures);
		
	}

}
