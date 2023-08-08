import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ConvolutedIntervals {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int m=s.nextInt();
		int[][] pairs=new int[n][2];
		for(int i=0;i<n;i++) {
			pairs[i]=new int[] {s.nextInt()-1,s.nextInt()-1};
		}
		Arrays.sort(pairs, new Comparator<int[]>() {
		    public int compare(int[] a, int[] b) {
		        return Integer.compare(a[0], b[0]);
		    }
		});
		int[] changes=new int[2*m];
		int index=0;
		for(int i=0;i<2*m;i++) {
			if(pairs[index][0]==i) {
				changes[i]++;
				changes[pairs[index][1]]--;
				index++;
				i--;
				if(index==n) {
					break;
				}
			}
		}
		for(int change:changes) {
			System.out.println(change);
		}
		int[] realChanges=new int[2*m+2];
		for(int i=0;i<2*m;i++) {
			for(int k=0;k<2*m;k++) {
				if(changes[i]>0 && changes[k]>0) {
					realChanges[i+k+2]+=changes[i]*changes[k];
					System.out.println("added "+(changes[i]*changes[k])+" to "+(i+k+2));
				}
				if(changes[i]<0 && changes[k]<0) {
					realChanges[i+k+3]-=changes[i]*changes[k];
					System.out.println("subed "+(changes[i]*changes[k])+" to "+(i+k+2));
				}
			}
		}
		int count=0;
		for(int i=0;i<realChanges.length-1;i++) {
			count+=realChanges[i];
			System.out.println(count);
		}
		
		

	}

}

