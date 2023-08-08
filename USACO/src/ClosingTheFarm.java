import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class ClosingTheFarm {

	public static void main(String[] args) {
		//10/10 :) dfs
		HashMap<Integer,ArrayList<Integer>> graph=new HashMap<>();
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int m=s.nextInt();
		for(int i=0;i<m;i++) {
			int farm1=s.nextInt();
			int farm2=s.nextInt();
			ArrayList<Integer> a1;
			if(graph.get(farm1)==null) {
				a1=new ArrayList<>();
			}else {
				a1=graph.get(farm1);
			}
			a1.add(farm2);
			graph.put(farm1,a1);
			ArrayList<Integer> a2;
			if(graph.get(farm2)==null) {
				a2=new ArrayList<>();
			}else {
				a2=graph.get(farm2);
			}
			a2.add(farm1);
			graph.put(farm2,a2);
		}
		int[] removals=new int[n];
		for(int i=0;i<n;i++) {
			removals[i]=s.nextInt();
		}
		
		System.out.println(dfs(graph));
		
		for(int i=0;i<n-1;i++) {		
			for(int connectedFarm:graph.get(removals[i])) {
				graph.get(connectedFarm).remove(new Integer(removals[i]));
			}
			graph.remove(removals[i]);
			System.out.println(dfs(graph));
		}

	}
	public static String dfs(HashMap<Integer,ArrayList<Integer>> graph) {
		//basically, you run one dfs from the first node and then if after that you have visited every node in the graph, it is fully connected, if not, it is not fully connected
		HashSet<Integer> visited=new HashSet<>();
		Iterator<Integer> i=graph.keySet().iterator();
		int next=i.next();
		//-------- DFS -----------
		Stack<Integer> stack=new Stack<>();
		stack.push(next); 
		while(!stack.empty()) {
			Integer current=stack.pop();
			if(!visited.contains(current)) {
				visited.add(current);
			}
			ArrayList<Integer> neighbors=graph.get(current); 	
			for(Integer neighbor:neighbors) { 
				if(!visited.contains(neighbor)) {
					stack.push(neighbor); 
				}
							
			}		
		}
		// -------------------------
		if(visited.size()==graph.size()) {
			return "YES";
		}else
		return "NO";
	}
}