import java.util.Scanner;

public class AirCownditioning {
	private static int nCows;
	private static int[] good;
	private static int[] bad;
	private static int[] neutral;
	private static int[] best;
	private static int changes;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		nCows=s.nextInt();
		good=new int[nCows];
		bad=new int[nCows];
		neutral=new int[nCows];
		best=new int[nCows];
		for(int i=0;i<good.length;i++) {
			good[i]=s.nextInt();
		}
		for(int i=0;i<bad.length;i++) {
			bad[i]=s.nextInt();
		}
		for(int i=0;i<neutral.length;i++) {
			neutral[i]=bad[i]-good[i];
		}
		for(int i=0;i<best.length;i++) {
			best[i]=0;
		}
		/*
		while(neutral!=best) {
			changes++;
			
		}
		*/
		int previousChange=0;
		int lowestPositiveChange=Integer.MAX_VALUE;
		int lowestNegativeChange=Integer.MIN_VALUE;
		for(int i=0;i<neutral.length;i++) {
			//System.out.println("neutrali:"+neutral[i]);
			if(neutral[i]==0) {
				previousChange=0;
			}else {
				//System.out.println("neutrali:"+neutral[i]);
				if(previousChange>0 && neutral[i]*-1>0) {
					//System.out.println("neutrali:"+neutral[i]);
					if(neutral[i]*-1<lowestPositiveChange) {
						lowestPositiveChange=neutral[i]*-1;
					}
					//System.out.println("neutrali:"+neutral[i]);
					if(previousChange!=0) {
						//System.out.println("neutrali:"+neutral[i]);
						
						changes+=Math.abs(neutral[i])-lowestPositiveChange;
					}else {
						changes+=Math.abs(neutral[i]);
						
					}
				}else if(previousChange<0 && neutral[i]*-1<0) {
					if(neutral[i]*-1>lowestNegativeChange) {
						lowestNegativeChange=neutral[i]*-1;
					}
					if(previousChange!=0) {
						//System.out.println("FLAG 2");
						changes+=Math.abs(neutral[i])+lowestNegativeChange;
					}else {
						changes+=Math.abs(neutral[i]);
					}
				}else {
					changes+=Math.abs(neutral[i]);
					
				}
				//System.out.println("neutrali:"+neutral[i]);
				previousChange=neutral[i]*-1;
				neutral[i]+=neutral[i]*-1;
				
				
			}
			//System.out.println("changes:"+changes);
			//System.out.println("previous change"+previousChange);
			
		}
		System.out.println(changes);

	}
	

}
