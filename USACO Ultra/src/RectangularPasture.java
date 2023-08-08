import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class RectangularPasture {

	public static void main(String[] args) {
		//fail:(
		//1. take input as an x and y list
		//2. sort both lists
		//3. coordinate compress both lists
		//4. generate 2 lists of all continuous segments from each list
		//5. sort each segment in each list
		//6. combine the two lists and remove duplicates (set?)
		//7. the answer is the size of this new list
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[] x=new int[n];
		int[] y=new int[n];
		HashMap<Integer,Integer> xMap=new HashMap<>();
		HashMap<Integer,Integer> yMap=new HashMap<>();
		for(int i=0;i<n;i++) {
			x[i]=s.nextInt();
			y[i]=s.nextInt();
			xMap.put(x[i], i);
			yMap.put(y[i], i);
		}
		Arrays.sort(x);
		Arrays.sort(y);
		int[] realX=new int[n];
		int[] realY=new int[n];
		for(int i=0;i<x.length;i++) {
			realX[i]=xMap.get(x[i]);
			realY[i]=yMap.get(y[i]);
		}
		ArrayList<SortedSet> xa=new ArrayList<>();
		ArrayList<SortedSet> ya=new ArrayList<>();
		for(int i=0;i<n;i++) {
			for(int k=i;k<n;k++) {
				SortedSet<Integer> set=new TreeSet<>();
				SortedSet<Integer> set2=new TreeSet<>();
				int[] subarray=Arrays.copyOfRange(realX, i, k + 1);
				int[] subarray2=Arrays.copyOfRange(realY, i, k + 1);
				for(int sub:subarray) {
					set.add(sub);
				}
				for(int sub2:subarray2) {
					set2.add(sub2);
				}
			
				xa.add(set);
				ya.add(set2);
			}
		}
		
		  
       
		 xa.addAll(ya);
        HashSet<SortedSet> set=new HashSet<>();
        for(SortedSet i:xa) {
        	set.add(i);
        	
        }
        //System.out.println(set);
        System.out.println(set.size()+1);
		
		
		

	}

}
