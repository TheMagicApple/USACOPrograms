import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
public class BarnTree {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[] barns=new int[n];
		int average=0;
		for(int i=0;i<n;i++) {
			barns[i]=s.nextInt();
			average+=barns[i];
		}
		average=average/n;
		for(int i=0;i<n;i++) {
			barns[i]-=average;
		}
		HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
		for(int i=0;i<n-1;i++) {
			int barn1=s.nextInt();
			int barn2=s.nextInt();
			ArrayList<Integer> a1=new ArrayList<>();
			ArrayList<Integer> a2=new ArrayList<>();
			if(map.get(barn1)!=null) a1=map.get(barn1);
			if(map.get(barn2)!=null) a2=map.get(barn2);
			a1.add(barn2);
			a2.add(barn1);
			map.put(barn1, a1);
			map.put(barn2, a2);
		}
		int operations=0;
		ArrayList<int[]> op=new ArrayList<>();
		while(map.size()>1) {
			Set<Integer> keys=map.keySet();
			for(int i=0;i<keys.size();i++) {
				int key=(int) keys.toArray()[i];
				if(map.get(key).size()==1) {
					int child=barns[key-1];
					if(child!=0) {
						barns[map.get(key).get(0)-1]+=child;
						barns[key-1]=0;
						if(child<0) {
							op.add(new int[] {map.get(key).get(0),key,-1*child});
						}else {
							op.add(new int[] {key,map.get(key).get(0),child});
						}
						map.get(map.get(key).get(0)).remove(new Integer(key));
						map.remove(key);
						operations++;
					}else {
						map.get(map.get(key).get(0)).remove(new Integer(key));
						map.remove(key);
					}
				}
			}
		}
		System.out.println(operations);
		for(int[] o:op) {
			System.out.println(o[0]+" "+o[1]+" "+o[2]);
		}

	}
}