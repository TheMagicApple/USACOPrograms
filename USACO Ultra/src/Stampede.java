import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class Stampede {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[][] cows=new int[n][3];
		for(int i=0;i<n;i++) {
			int[] cow=new int[] {s.nextInt(),s.nextInt(),s.nextInt()};
			cows[i]=cow;
		}
		int[][] realCows=new int[n][4];
		for(int i=0;i<cows.length;i++) {
			int[] realCow=new int[] {cows[i][0],cows[i][1],(-1-cows[i][0])*cows[i][2],(-1-cows[i][0])*cows[i][2]+cows[i][2]};
			realCows[i]=realCow;
		}
		Arrays.sort(realCows, new Comparator<int[]>() {
		    public int compare(int[] a, int[] b) {
		        return Integer.compare(a[1], b[1]);
		    }
		});
		/*
		for(int[] realCow:realCows) {
			System.out.println(realCow[0]+" "+realCow[1]+" "+realCow[2]+" "+realCow[3]);
		}
		*/
		int cowsSee=0;
		HashSet<Integer> blocked=new HashSet<>();
		for(int i=0;i<realCows.length;i++) {
			int[] cow=realCows[i];
			boolean good=false;
			for(int a=cow[2];a<=cow[3];a++) {
				if(!blocked.contains(a)) {
					blocked.add(a);
					good=true;
				}
			}
			if(good) {
				cowsSee++;
			}
		}
		System.out.println(cowsSee);

	}

}
