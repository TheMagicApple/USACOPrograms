import java.util.Scanner;

public class Meetings {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int secondBarn=s.nextInt()*2;
		long[][] cows=new long[n][3];
		int totalWeight=0;
		for(int i=0;i<n;i++) {
			long[] cow=new long[3];
			cow[0]=s.nextInt();
			cow[1]=s.nextInt()*2;
			cow[2]=s.nextInt();
			totalWeight+=cow[0];
			cows[i]=cow;
		}
		int meetings=0;
		int weightStopped=0;
		while(weightStopped<=totalWeight/2) {
			
			for(long[] cow:cows) {
				//System.out.print(cow[1]+" ");
			}
			//System.out.println();
			
			for(int i=0;i<cows.length;i++) {
				cows[i][1]+=cows[i][2];
				if(cows[i][1]==0 || cows[i][1]==secondBarn) {
					weightStopped+=cows[i][0];
					System.out.println(i+" COW STOPPED");
				}
			}
			for(int i=0;i<cows.length;i++) {
				for(int k=i+1;k<cows.length;k++) {
					if(cows[i][1]==cows[k][1]) {
						long temp=cows[i][2];
						cows[i][2]=cows[k][2];
						cows[k][2]=temp;
						meetings++;
					}
				}
			}
			
		}
		System.out.println(meetings);

	}

}
