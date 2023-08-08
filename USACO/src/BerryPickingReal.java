import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BerryPickingReal {
	private static int n;
	private static int kBuckets;
	private static int[] orchard;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		kBuckets=s.nextInt();
		orchard=new int[n];
		int sumOfTree=0;
		for(int i=0;i<n;i++) {
			orchard[i]=s.nextInt();
			sumOfTree+=orchard[i];
		}
		Arrays.sort(orchard);
		
        for (int i = 0; i < n / 2; i++) {
            int t = orchard[i];
            orchard[i] = orchard[n - i - 1];
            orchard[n - i - 1] = t;
        }
		//Collections.reverse(Arrays.asList(orchard));
		for(int i:orchard) {
			//System.out.print(i+" ");
		}
		//sumOfTree/=n;
		int BBB=0;
		while(sumOfTree>0) {
			ArrayList<Integer> berry=new ArrayList<>();
			for(int i=0;i<n;i++) {
				int bucketsFilled=orchard[i]/sumOfTree;
				if(bucketsFilled==0) {
					berry.add(0,orchard[i]);
				}else {
					for(int k=0;k<bucketsFilled;k++) {
						berry.add(0,sumOfTree);
					}
				}
				if(berry.size()>=kBuckets) {
					break;
				}
			}
			int BB=0;
			for(int i=0;i<berry.size()/2;i++) {
				BB+=berry.get(i);
			}
			if(BB>BBB) {
				BBB=BB;
			}
			sumOfTree--;
		}
		System.out.println(BBB);
		
	}

}
