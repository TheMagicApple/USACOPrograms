import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class WhyDidTheCowCrossTheRoad {
	public static void main(String[] args) {
		//5 out of 9??
		Scanner s=new Scanner(System.in);
		int c=s.nextInt();
		int n=s.nextInt();
		int[] chickens=new int[c];
		int[][] cows=new int[n][2];
		for(int i=0;i<c;i++) {
			chickens[i]=s.nextInt();
		}
		for(int i=0;i<n;i++) {
			cows[i]=new int[] {s.nextInt(),s.nextInt()};
		}
		Arrays.sort(chickens);
		Arrays.sort(cows, new Comparator<int[]>() {
		    public int compare(int[] a, int[] b) {
		       return Integer.compare(a[0], b[0]);
		    }
		});
		int currentChicken=0;
		int currentCow=0;
		int pairs=0;
		while(currentCow<cows.length && currentChicken<chickens.length) {
			int chicken=chickens[currentChicken];
			int[] cow=cows[currentCow];
			if(chicken>=cow[0] && chicken<=cow[1]) { //its a match!
				pairs++;
				currentChicken++;
				currentCow++;
			}else {
				if(chicken<cow[0]) { //the cow is too late for the chicken
					currentChicken++;
				}
				else if(chicken>cow[1]) { //the chicken is too late for the cow
					currentCow++;
				}
			}
		}
		System.out.println(pairs);
		
	}

}
