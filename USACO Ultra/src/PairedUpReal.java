import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PairedUpReal {

	public static void main(String[] args) {
		//ac :)
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[][] cows=new int[n][2];
		for(int i=0;i<n;i++) {
			cows[i]=new int[] {s.nextInt(),s.nextInt()};
		}
		Arrays.sort(cows, new Comparator<int[]>() {
		    public int compare(int[] a, int[] b) {
		        return Integer.compare(a[1], b[1]);
		    }
		});
		int minTime=0;
		int left=0;
		int right=n-1;
		while(left!=right) {
			int time=cows[left][1]+cows[right][1];
			if(time>minTime) {
				minTime=time;
			}
			int leftCows=cows[left][0]-cows[right][0];
			int rightCows=cows[right][0]-cows[left][0];
			cows[left][0]=leftCows;
			cows[right][0]=rightCows;
			if(leftCows==0 && rightCows==0) {
				left++;
				right--;
			}else {
				if(leftCows>0) {
					right--;
				}
				if(rightCows>0) {
					left++;
				}
			}
		
		}
		for(int[] cow:cows) {
			if(cow[0]>0) {
				int time=2*cow[1];
				if(time>minTime) {
					minTime=time;
				}
			}
		}
		System.out.println(minTime);

	}

}
