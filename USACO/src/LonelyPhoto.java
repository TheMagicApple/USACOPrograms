import java.util.Scanner;

public class LonelyPhoto {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		s.nextInt();
		String[] lineup=s.next().split("");
		int[] cows=new int[lineup.length];
		for(int i=0;i<lineup.length;i++) {
			if(lineup[i].equals("G")) {
				cows[i]=0;
			}else {
				cows[i]=1;
			}

		}
		int[] prefix=new int[cows.length+1];
		for(int i=1;i<cows.length+1;i++) {
			if(i==1) {
				prefix[i]=cows[i-1];
			}else {
				prefix[i]=prefix[i-1]+cows[i-1];
			}
		}
		int lonely=0;
		for(int i=0;i<cows.length;i++) {
			for(int j=i+2;j<cows.length;j++) {
				int sum=prefix[j+1]-prefix[i];
				if(sum==1 || sum==(j-i)) {
					lonely++;
				}
			}
		}
		System.out.println(lonely);
	

	}

}
