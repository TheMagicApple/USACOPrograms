import java.util.ArrayList;
import java.util.Scanner;

public class BucketList {
	private static int nCows;
	private static int[][] times;
	private static int[] buckets;
	private static ArrayList<Integer> startedMilking=new ArrayList<>();
	private static int[] activeBuckets=new int[100000];
	private static int bucketsUsed=0;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		nCows=s.nextInt();
		times=new int[nCows][2];
		buckets=new int[nCows];
		for(int i=0;i<nCows;i++) {
			int[] time=new int[2];
			time[0]=s.nextInt();
			time[1]=s.nextInt();
			times[i]=time;
			buckets[i]=s.nextInt();
		}
		int day=1;
		while(!done()) {
			for(int i=0;i<times.length;i++) {
				if(times[i][0]==day) {
					//bucketsUsed+=buckets[i];
					//System.out.println("FLAG 1");
					int bucketsNeeded=buckets[i];
					//System.out.println("day: "+day+" buckets added: "+bucketsNeeded);
					for(int k=0;k<activeBuckets.length;k++) {
						if(activeBuckets[k]==0 || activeBuckets[k]==2) {
							bucketsNeeded--;
							activeBuckets[k]=1;
							if(bucketsNeeded==0) {
								k=activeBuckets.length;
							}
						}
					}
					//System.out.println("FLAG 2")
					//System.out.println("FLAG 3");
					startedMilking.add(times[i][0]);
					//System.out.println("NEW MILKING");
					//System.out.println(startedMilking);
				}
				if(times[i][1]==day) {
					//bucketsUsed-=buckets[i];
					int bucketsNeedReturned=buckets[i];
					//System.out.println("day: "+day+" buckets removed: "+bucketsNeedReturned);
					
					
					int k=0;
					while(bucketsNeedReturned>0) {
						
						if(activeBuckets[k]==1) {
							activeBuckets[k]=2;
							bucketsNeedReturned--;
							k++;
						}else {
							
							k++;
						}
						
					}
				}
					
			}
			//System.out.println(activeBuckets);
			
			day++;
			
		}
		int total=0;
		for(int i:activeBuckets) {
			if(i!=0) {
				total++;
			}
		}
		System.out.println(total);
		
		
		
		

	}
	public static boolean done() {
		for(int[] i:times) {
			if(startedMilking.contains(i[0])) {
				
			}else {
				return false;
			}
		}
		return true;
	}

}
