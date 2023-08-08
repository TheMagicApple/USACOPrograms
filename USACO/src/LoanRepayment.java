import java.util.Scanner;

public class LoanRepayment {
	private static long nGallons;
	private static long kDays;
	private static long mMinimum;
	private static long alreadyPayed;
	private static long x;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		nGallons=s.nextLong();
		kDays=s.nextLong();
		mMinimum=s.nextLong();
		x=1;
		boolean done=false;
		while(!done) {
			alreadyPayed=0;
			
			for(int i=0;i<kDays;i++) {
				long y=(int) Math.floor((nGallons-alreadyPayed)/x);
				if(y<mMinimum) {
					y=mMinimum;
				}
				alreadyPayed+=y;
			}
			System.out.println("paid: "+alreadyPayed);
			if(alreadyPayed<nGallons) {
				done=true;
			}else {
				x++;
			}
			
		}
		System.out.println(x-1);
		
		

	}

}
