import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class BerryPickingReal {
	public static void main(String[] args) {
		//success? (watched video to get hint)
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int k=s.nextInt();
		int[] btrees=new int[n];
		for(int i=0;i<n;i++) {
			btrees[i]=s.nextInt();
		}
		long startTime=System.currentTimeMillis();
		Arrays.sort(btrees);
		int[] ttrees = new int[n]; //reverse array manually because arrays.sort is stupid and for some reason theres no arrays.reverse
        int j = n;
        for (int i = 0; i < n; i++) {
            ttrees[j - 1] = btrees[i];
            j = j - 1;
        }
		int maxBessie=0;
		for(int q=1;q<1000;q++) {
			int[] trees=ttrees.clone(); //reset the trees each time because bessie doesnt go the same orchard 1000 times in a row...that would be pretty useless
			int elsieBuckets=k/2; //elsie gets k/2 buckets with EXACTLY q berries in each
			for(int i=0;i<trees.length;i++) {
				int bucketsFromTree=trees[i]/q;
				if(bucketsFromTree>elsieBuckets) { //if the tree has more than enough berries for elsie
					trees[i]-=elsieBuckets*q; //remove the berries elsie took and leave the rest possibly for later
					elsieBuckets=0;
					break;
				}else { //if the tree has just the right amount or not enough, take all the berries you can fit into the baskets and then move on to the next ree
					elsieBuckets-=bucketsFromTree;
					trees[i]-=bucketsFromTree*q;
					if(elsieBuckets<=0) {
						break;
					}
				}
			}
			if(elsieBuckets>0) {
				//elsie didn't get her berries :(
			}else {
				ArrayList<Integer> bessieBuckets=new ArrayList<>();
				for(int tree:trees) { //bessie gets k/2 buckets with AT MOST q berries in each
					int bucketsFromTree=tree/q;
					int leftover=tree%q;
					for(int i=0;i<bucketsFromTree;i++) {
						bessieBuckets.add(q);
					}
					bessieBuckets.add(leftover);
				}
				Collections.sort(bessieBuckets);
				Collections.reverse(bessieBuckets);
				int bessieBerries=0;
				Iterator<Integer> buckets=bessieBuckets.iterator();
				for(int i=0;i<k/2;i++) {
					if(buckets.hasNext()) {
						bessieBerries+=buckets.next();
					}else {
						bessieBerries+=0;
					}
				}
				if(bessieBerries>maxBessie) {
					maxBessie=bessieBerries;
				}
			}		
		}
		System.out.println(maxBessie);
		//System.out.println("It took "+(System.currentTimeMillis()-startTime)+"ms");
	}
}