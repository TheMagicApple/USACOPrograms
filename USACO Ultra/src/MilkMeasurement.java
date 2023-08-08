import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class MilkMeasurement {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int g=s.nextInt();
		Coww[] hash=new Coww[10000000];
		int[][] entries=new int[n][3];
		for(int i=0;i<n;i++) {
			entries[i]=new int[] {s.nextInt(),s.nextInt(),Integer.parseInt(s.next())};
		}
		Arrays.sort(entries, new Comparator<int[]>() {
		    public int compare(int[] a, int[] b) {
		        return Double.compare(a[0], b[0]);
		    }
		});
		ArrayList<Coww> moo=new ArrayList<>();
		int currentMax=0;
		int nMax=-1;
		int changes=0;
		Coww normal=new Coww();
		normal.milk=0;
		moo.add(normal);
		for(int[] entry:entries) {
			
			
			int cow=entry[1];
			int change=entry[2];
			if(hash[cow]==null) {
				Coww coww=new Coww();
				coww.milk=change;
				hash[cow]=coww;
				moo.add(coww);
			}else {
				hash[cow].milk+=change;
			}
			Collections.sort(moo);
			Collections.reverse(moo);
			if(moo.get(0).milk!=currentMax) {
				
				
				currentMax=moo.get(0).milk;
				changes++;
				nMax=1;
			}else{
				//System.out.println(moo.first().milk);
				//System.out.println("currentmax:"+currentMax);
				int currentNMax=0;
				Iterator<Coww> i=moo.iterator();
				Coww c=i.next();
				while(c.milk==currentMax) {
					currentNMax++;
					c=i.next();
				}
				//System.out.println(currentNMax);
				//System.out.println(currentMax);
				if(currentNMax!=nMax) {
					nMax=currentNMax;
					changes++;
				}
			}
			
			
			//System.out.println(moo);
			
			
		}
		System.out.println(changes);
		

	}
	

}
class Coww implements Comparable<Coww>{
	public int milk;
	@Override
	public int compareTo(Coww other) {
		return milk-other.milk;
		//return Integer.compare(other.milk,milk);
	}
	public String toString() {
		return milk+"";
	}
}
