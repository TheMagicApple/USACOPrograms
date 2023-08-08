import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class YearOfTheCow {

	public static void main(String[] args) {
		//all clear:)
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int k=s.nextInt()-1;
		SortedMap<Integer,Integer> cows=new TreeMap<>(Collections.reverseOrder());
		for(int i=0;i<n;i++) {
			int index=s.nextInt()/12+1;
			if(cows.get(index)==null) {
				cows.put(index, 1);
			}else {
				cows.put(index, cows.get(index)+1);
			}
		}
		SortedMap<Integer,Integer> distances=new TreeMap<>();
		Iterator<Integer> i=cows.keySet().iterator();
		int cow=i.next();
		while(i.hasNext()) {
			int oldCow=cow;
			cow=i.next();
			distances.put(oldCow, oldCow-cow);
		}
		distances.put(cow,cow);
		int[][] sortedDistances=new int[distances.size()][2];
		int counter=0;
		for(int key:distances.keySet()) {
			sortedDistances[counter]=new int[] {key,distances.get(key)};
			counter++;
		}
		Arrays.sort(sortedDistances, new Comparator<int[]>() {
		    public int compare(int[] a, int[] b) {
		        return Double.compare(b[1], a[1]);
		    }
		});
		HashSet<Integer> teleportDistances=new HashSet<>();
		int found=0;
		for(int[] distance:sortedDistances) {
			teleportDistances.add(distance[0]);
			found++;
			if(found==k) {
				break;
			}
		}
		int time=0; //everything above is precalc, this is the actual process of going through time
		Object[] it=cows.keySet().toArray();
		for(int a=0;a<it.length;a++) {
			time+=12;
			if(teleportDistances.contains(it[a])) {
				
			}else {
				if(a==it.length-1) {
					time+=((int)it[a]-1)*12;
				}else {
					time+=((int)it[a]-(int)it[a+1]-1)*12;
				}
			}
		}
		System.out.println(time);
	}
}