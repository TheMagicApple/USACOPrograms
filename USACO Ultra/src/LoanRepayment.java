import java.util.HashSet;
import java.util.Scanner;

public class LoanRepayment {
	static long n;
	static long k;
	static double m;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		n=s.nextLong();
		k=s.nextLong();
		m=s.nextLong();
		int left=0;
		int right=1000000000;
		int mid=(left+right)/2;
		while(left<right) {
			mid=left+(right-left+1)/2;
			if(simulate(mid)) {
				left=mid;
			}else {
				right=mid-1;
			}
		}
		System.out.println((left+right)/2);

	}
	public static boolean simulate(int x) {
		int days=0;
		long gallonsGiven=0;
		while(gallonsGiven<n && days<=k) {
			long y=(n-gallonsGiven)/x;
			if(y<=m) {
				days+=Math.ceil((n-gallonsGiven)/m);
				gallonsGiven=n;
				
			}else {
				days++;
				gallonsGiven+=y;
			}
		}
		return days<=k;
	}
}