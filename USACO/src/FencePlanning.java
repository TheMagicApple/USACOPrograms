import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FencePlanning {
	private static int n;
	private static int m;
	private static int[][] cows;
	public static void main(String[] args) throws IOException {
		
		File f=new File("fenceplan.in");
		BufferedReader br=new BufferedReader(new FileReader(f));
		String ss=br.readLine();
		String[] numbers=ss.split(" ");
		n=Integer.parseInt(numbers[0]);
		m=Integer.parseInt(numbers[1]);
		cows=new int[n][2];
		for(int i=0;i<n;i++) {
			int[] cow=new int[2];
			String[] s=br.readLine().split(" ");
			cow[0]=Integer.parseInt(s[0]);
			cow[1]=Integer.parseInt(s[1]);
			cows[i]=cow;
		}
		Map<Integer,ArrayList<Integer>> cowConnections=new HashMap<>();
		for(int i=0;i<m;i++) {
			String[] s=br.readLine().split(" ");
			int first=Integer.parseInt(s[0]);
			int second=Integer.parseInt(s[1]);
			if(cowConnections.get(first)==null) {
				ArrayList<Integer> a=new ArrayList<>();
				a.add(second);
				cowConnections.put(first,a);
			}else {
				cowConnections.get(first).add(second);
			}
			if(cowConnections.get(second)==null) {
				ArrayList<Integer> a=new ArrayList<>();
				a.add(first);
				cowConnections.put(second,a);
			}else {
				cowConnections.get(second).add(first);
			}
			
		}
		
		/*
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		m=s.nextInt();
		cows=new int[n][2];
		for(int i=0;i<n;i++) {
			int[] cow=new int[2];
			cow[0]=s.nextInt();
			cow[1]=s.nextInt();
			cows[i]=cow;
		}
		long startTime=System.currentTimeMillis();
		int pass=0;
		Map<Integer,ArrayList<Integer>> cowConnections=new HashMap<>();
		for(int i=0;i<m;i++) {
			int first=s.nextInt();
			int second=s.nextInt();
			if(cowConnections.get(first)==null) {
				ArrayList<Integer> a=new ArrayList<>();
				a.add(second);
				cowConnections.put(first,a);
			}else {
				cowConnections.get(first).add(second);
			}
			if(cowConnections.get(second)==null) {
				ArrayList<Integer> a=new ArrayList<>();
				a.add(first);
				cowConnections.put(second,a);
			}else {
				cowConnections.get(second).add(first);
			}
			
		}
		*/
		long checkpoint1=System.currentTimeMillis();
		//System.out.println("PART 1 COMPLETE IN "+(checkpoint1-startTime));
		ArrayList<ArrayList<Integer>> groups=new ArrayList<>();
		
		while(cowConnections.size()>0) {
			ArrayList<Integer> keys=new ArrayList<>();
			keys.add((int) cowConnections.keySet().toArray()[0]);
			ArrayList<Integer> group=new ArrayList<>();
			
			while(keys.size()>0) {
				ArrayList<Integer> newKeys=new ArrayList<>();
				for(int myKey:keys) {
					ArrayList<Integer> result=cowConnections.get(myKey);
					if(result!=null) {
						/*
						if(!group.contains(myKey)) {
							group.add(myKey);
						}
						*/
						group.add(myKey);
						for(int i:result) {
							/*
							if(!group.contains(i)) {
								group.add(i);
							}
							*/
							if(cowConnections.get(i)!=null) {
								newKeys.add(i);
							}
							
							
						}
						cowConnections.remove(myKey);
					}
					//System.out.println("NEXT ITERATION");
				}
				//System.out.println("NEXT ITERATION!");
				keys=newKeys;
			//	System.out.println("NEW KEYS "+newKeys);
			}
			groups.add(group);
			//System.out.println("ADDED GROUP"+groups.size());
		}
		long checkpoint2=System.currentTimeMillis();
		//System.out.println("PART 2 COMPLETE IN "+(checkpoint2-checkpoint1));
		ArrayList<Integer> perimeters=new ArrayList<>();
		for(ArrayList<Integer> group:groups) {
			int lX=Integer.MAX_VALUE;
			int hX=0;
			int lY=Integer.MAX_VALUE;
			int hY=0;
			for(int cow:group) {
				int[] coords=cows[cow-1];
				int x=coords[0];
				int y=coords[1];
				if(x<lX) {
					lX=x;
				}
				if(x>hX) {
					hX=x;
				}
				if(y<lY) {
					lY=y;
				}
				if(y>hY) {
					hY=y;
				}
				
			}
			int width=hX-lX;
			int height=hY-lY;
			int perimeter=2*width+2*height;
			perimeters.add(perimeter);
		}
		//System.out.println("PART 3 COMPLETE IN "+(System.currentTimeMillis()-checkpoint2));
		Collections.sort(perimeters);
		//System.out.println(pass);
		
		BufferedWriter output = new BufferedWriter(new FileWriter("fenceplan.out"));
		output.append(""+perimeters.get(0));
		output.close();
		
		
		

	}

}
