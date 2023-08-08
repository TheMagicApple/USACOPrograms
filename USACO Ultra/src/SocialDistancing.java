import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SocialDistancing {
	static int n;
	static int m;
	static int[][] grass;
	public static void main(String[] args) {
		//success!
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		m=s.nextInt();
		grass=new int[m][2];
		for(int i=0;i<m;i++) {
			grass[i]=new int[] {s.nextInt(),s.nextInt()};
		}
		Arrays.sort(grass, new Comparator<int[]>() {
		    public int compare(int[] a, int[] b) {
		        return Integer.compare(a[0], b[0]);
		    }
		});
		int left=0;
		int right=1000000000;
		int mid=(left+right)/2;
		while(left<right) {
			mid=left+(right-left+1)/2;
			if(placeCows(mid)) {
				left=mid;
			}else {
				right=mid-1;
			}
		}
		System.out.println((left+right)/2);
	}
	public static boolean placeCows(int distance) {
		int cowsPlaced=0;
		int currentPosition=grass[0][0];
		int lastPlacedCow=-1000000000;
		for(int[] interval:grass) {
			currentPosition=interval[0];
			if(currentPosition-lastPlacedCow<distance) {
				currentPosition=lastPlacedCow+distance;
			}
			while(currentPosition<=interval[1]) {
				lastPlacedCow=currentPosition;
				cowsPlaced++;
				currentPosition=lastPlacedCow+distance;
				
			}		
		}
		return cowsPlaced>=n;
	}
}