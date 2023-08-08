import java.util.Scanner;

public class LoanRepaymentSol {
	static long n;
	static long k;
	static long m;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		n=s.nextLong();
		k=s.nextLong();
		m=s.nextLong();
		int left=0;
		int right=1000000000;
		int mid=(left+right)/2;
		while(left<right) {
			mid=(left+right+1)/2;
			if(simulate(mid,k)) {
				left=mid;
			}else {
				right=mid-1;
			}
		}
		System.out.println(left);

	}
	public static boolean simulate(int x,long kk) {
		long given=0;
		while(kk>0 && given<n) {
			long y=(n-given)/x;
			if(y<m) {
				long leftover=(n-given+m-1)/m;
				return leftover<=k;
			}
			long maxmatch=n-x*y;
			long numdays=(maxmatch-given)/y+1;
			if(numdays>k) {
				numdays=k;
			}
			given+=y*numdays;
			kk-=numdays;
		}
		return given>=n;
	}
	

}
