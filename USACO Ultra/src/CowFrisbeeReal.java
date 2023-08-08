import java.util.ArrayList;
import java.util.Scanner;

public class CowFrisbeeReal {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[] cows=new int[n];
		for(int i=0;i<n;i++) {
			cows[i]=s.nextInt();
		}
		int sum=0;
		ArrayList<Vector> pairs=new ArrayList<>();
		for(int i=0;i<cows.length-1;i++) {
			int ogCow=cows[i];
			int currentMax=0;
			for(int j=i+1;j<cows.length;j++) {
				if(cows[j]>ogCow) {
					sum+=j-i+1;
					if(j!=i+1) {
						pairs.add(new Vector(i,j));
					}
					break;
				}else {
					if(cows[j]>currentMax) {
						sum+=j-i+1;
						if(j!=i+1) {
							pairs.add(new Vector(i,j));
						}
						
						currentMax=cows[j];
					}
				}
			}
		}
		System.out.println(sum);
		System.out.println(pairs);
			

	}

}
