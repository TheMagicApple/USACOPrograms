import java.util.Scanner;

public class MooBuzzReal {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		long x=n/8;
		n=n%8;
		long start=x*15+1;
		if(n==0) {
			System.out.println(start+13);
		}else {
			for(int i=1;i<n;i++) {
				if(i==1 || i==4 || i==7) {
					start++;
				}else if(i==2 || i==6) {
					start+=2;
				}else if(i==3 || i==5) {
					start+=3;
				}
			}
			System.out.println(start);
		}
	

	}

}
