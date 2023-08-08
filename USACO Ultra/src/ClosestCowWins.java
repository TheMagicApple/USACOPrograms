import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ClosestCowWins {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int kPatches=s.nextInt();
		int mNhoj=s.nextInt();
		int nJohn=s.nextInt();
		int[][] patches=new int[kPatches][2];
		for(int i=0;i<kPatches;i++) {
			patches[i]=new int[] {s.nextInt(),s.nextInt()};
		}
		int[] nhoj=new int[mNhoj];
		for(int i=0;i<mNhoj;i++) {
			nhoj[i]=s.nextInt();
		}
		Arrays.sort(nhoj);
		Arrays.sort(patches, new Comparator<int[]>() {
		    public int compare(int[] a, int[] b) {
		        return Integer.compare(a[0], b[0]);
		    }
		});
		int currentPatch=0;
		ArrayList<Long> tasty=new ArrayList<>();
		for(int i=0;i<=nhoj.length;i++) {
			if(i==nhoj.length) {
				long totalTasty=0;
				while(currentPatch<patches.length) {
					totalTasty+=patches[currentPatch][1];
					currentPatch++;
				}
				tasty.add(totalTasty);
			}else {
				long nhojCow=nhoj[i];
				long totalTasty=0;
				long maxHalfTasty=0;
				if(i==0) {
					while(patches[currentPatch][0]<nhojCow) {
						totalTasty+=patches[currentPatch][1];
						currentPatch++;
					}
					tasty.add(totalTasty);
				}else {
					int tempPatch=currentPatch;
					int range=nhoj[i]-nhoj[i-1];
					while(patches[currentPatch][0]<nhojCow) {
						totalTasty+=patches[currentPatch][1];
						currentPatch++;
					}
					//we need maximum tastiness we can get in an l/2 range
					for(double a=nhoj[i-1];a<nhoj[i-1]+range/2.0d;a+=1d) {
						int halfTasty=0;
						while(patches[tempPatch][0]<nhojCow-range/2.00d-0.01d) {
							halfTasty+=patches[tempPatch][1];
							tempPatch++;
						}
						if(halfTasty>maxHalfTasty) {
							maxHalfTasty=halfTasty;
						}
					}
					tasty.add(maxHalfTasty);
					tasty.add(totalTasty-maxHalfTasty);
				}
			}
		}
		long answer=0;
		Collections.sort(tasty);
		for(int i=tasty.size()-1;i>=tasty.size()-nJohn;i--) {
			answer+=tasty.get(i);
			//System.out.println(tasty.get(i));
		}
		System.out.println(answer);
	}
}