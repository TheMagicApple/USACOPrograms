import java.util.Arrays;
import java.util.Scanner;

public class LemonadeLine {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[] cows=new int[n];
		for(int i=0;i<n;i++) {
			cows[i]=s.nextInt();
		}
		Arrays.sort(cows);
		int cowsInLine=0;
		for(int i=cows.length-1;i>=0;i--) {
			if(cows[i]>=cowsInLine) {
				cowsInLine++;
			}else {
				break;
			}
		}
		System.out.println(cowsInLine);
	}
}
