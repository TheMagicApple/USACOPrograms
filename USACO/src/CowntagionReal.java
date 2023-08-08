import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CowntagionReal {
	private static int n;
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		ArrayList<Integer>[] connections=new ArrayList[n];
		for(int i=0;i<n;i++) {
			connections[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<n-1;i++) {
			connections[s.nextInt()-1].add(s.nextInt()-1);
		}
		Map<Integer,ArrayList<Integer>> map=new HashMap<>();
		for(int i=0;i<n;i++) {
			map.put(i, connections[i]);
		}
		//System.out.println(map);
		ArrayList<Integer> farms=new ArrayList<>();
		farms.add(0);
		int doubles=0;
		int trips=0;
		ArrayList<Integer> farmsVisited=new ArrayList<>();
		farmsVisited.add(0);
		while(farms.size()>0) {
			ArrayList<Integer> newFarms=new ArrayList<>();
			for(int i=0;i<farms.size();i++) {
				
				ArrayList<Integer> roads=map.get(farms.get(i));
				if(roads.size()>0) {
					
					for(int k=0;k<roads.size();k++) {
						if(farmsVisited.contains(roads.get(k))) {
							roads.remove(k);
							i--;
						}
					}
					double cowsNeeded=roads.size()+1;
					doubles+=Math.ceil(Math.log(cowsNeeded)/Math.log(2));
					trips+=roads.size();
					for(int road:roads) {
						newFarms.add(road);
						farmsVisited.add(road);
					}
				}
				
			}
			farms=newFarms;
		}
		System.out.println(doubles+trips);
	}

}
