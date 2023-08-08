import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

public class ConnectingTwoBarns {
	static int n;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int a=0;a<t;a++) {
			n=s.nextInt();
			int m=s.nextInt();
			HashMap<Integer,ArrayList<Integer>> graph=new HashMap<>();
			for(int i=0;i<m;i++) {
				int field1=s.nextInt();
				int field2=s.nextInt();
				
				if(a==4)System.out.println(field1+" "+field2);
				ArrayList<Integer> a1=new ArrayList<>();
				ArrayList<Integer> a2=new ArrayList<>();
				if(graph.get(field1)!=null) a1=graph.get(field1);
				if(graph.get(field2)!=null) a2=graph.get(field2);
				a1.add(field2);
				a2.add(field1);
				graph.put(field1, a1);
				graph.put(field2, a2);
			}
			//System.out.println(graph);
			ArrayList<SortedSet<Integer>> groups=count(graph);
			if(a==4)System.out.println(groups);
			SortedSet<Integer> firstGroup=new TreeSet<>();
			SortedSet<Integer> lastGroup=new TreeSet<>();
			boolean bad=false;
			for(int i=0;i<groups.size();i++) {
				if(groups.get(i).contains(1) && groups.get(i).contains(n)) {
					firstGroup=groups.get(i);
					lastGroup=groups.get(i);
					System.out.println(0);
					bad=true;
					break;
					//groups.remove(i);
					//i--;
				}else {
					if(groups.get(i).contains(1)) {
						firstGroup=groups.get(i);
						groups.remove(i);
						i--;
					}
					else if(groups.get(i).contains(n)) {
						lastGroup=groups.get(i);
						groups.remove(i);
						i--;
					}
				}
				
			}
			SortedSet<Integer> costs=new TreeSet<>();
			costs.add((int) Math.pow(lastGroup.first()-firstGroup.last(),2));
			for(SortedSet<Integer> group:groups) {
				int cost=0;
				if(lastGroup.first()<group.last()) {
					cost=(int) Math.pow(group.first()-firstGroup.last(),2) + (int) Math.pow(lastGroup.last()-group.last(),2);
				}else if(firstGroup.last()>group.first()){
					cost=(int) Math.pow(lastGroup.first()-group.last(),2);
				}else {
					cost=(int) Math.pow(group.first()-firstGroup.last(),2) + (int) Math.pow(lastGroup.first()-group.last(),2);
				}
				//int cost=(int) Math.pow(group.first()-firstGroup.last(),2) + (int) Math.pow(lastGroup.first()-group.last(),2);
				
				costs.add(cost);
			}
			if(!bad)System.out.println(costs.first());
			System.out.println("_________________________________________________");
		}
		

	}
	public static ArrayList<SortedSet<Integer>> count(HashMap<Integer,ArrayList<Integer>> graph) {
		int count=0;
		HashSet<Integer> visited=new HashSet<>();
		Iterator<Integer> i=graph.keySet().iterator();
		ArrayList<SortedSet<Integer>> groups=new ArrayList<>();
		while(i.hasNext()) {
			int next=i.next();
			SortedSet<Integer> group=new TreeSet<>();
			if(!visited.contains(next)) {
				//-------- DFS -----------
				Stack<Integer> stack=new Stack<>();
				stack.push(next); 
				while(!stack.empty()) {
					int current=stack.pop();
					if(!visited.contains(current)) {
						visited.add(current);
						group.add(current);
					}
					ArrayList<Integer> neighbors=graph.get(current); 
					for(int neighbor:neighbors) { 
						if(!visited.contains(neighbor)) {
							stack.push(neighbor); 
						}
						
					}
				}
				// -------------------------
			}
			if(group.size()>0) {
				groups.add(group);
			}
		}
		for(int ii=1;ii<=n;ii++) {
			if(!visited.contains(ii)) {
				SortedSet<Integer> alone=new TreeSet<>();
				alone.add(ii);
				groups.add(alone);
			}
		}
		return groups;
	}

}
