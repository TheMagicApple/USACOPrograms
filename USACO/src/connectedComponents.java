import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;



public class connectedComponents {

	public static void main(String[] args) {
		//count number of connected components on undirected graph
		HashMap<String,String[]> graph=new HashMap<>();
		graph.put("1",new String[] {"2"});
		graph.put("2",new String[] {"1"});
		graph.put("3",new String[] {});
		graph.put("4",new String[] {});
		graph.put("5",new String[] {"6"});
		graph.put("6", new String[] {"4","5","7","8"});
		graph.put("7", new String[] {"6"});
		graph.put("8", new String[] {"6"});
		System.out.println(count(graph));

	}
	public static int count(HashMap<String,String[]> graph) {
		//basically, you dfs starting from each node that has not been visited yet (in total) and go until you cant go anymore and thats one connected component
		int count=0;
		HashSet<String> visited=new HashSet<>();
		Iterator<String> i=graph.keySet().iterator();
		while(i.hasNext()) {
			String next=i.next();
			if(!visited.contains(next)) {
				//-------- DFS -----------
				Stack<String> stack=new Stack<>();
				stack.push(next); 
				while(!stack.empty()) {
					String current=stack.pop();
					if(!visited.contains(current)) {
						visited.add(current);
					}
					String[] neighbors=graph.get(current); 
					for(String neighbor:neighbors) { 
						if(!visited.contains(neighbor)) {
							stack.push(neighbor); 
						}
						
					}
				}
				// -------------------------
				count++;
				
			}
			
		}
		return count;
	}
	/*
	public static boolean search(HashMap<String,String[]> graph,String start) {
		HashSet<String> visited=new HashSet<>();
		Stack<String> stack=new Stack<>();
		stack.push(start); 
		while(!stack.empty()) {
			String current=stack.pop();
			if(!visited.contains(current)) {
				visited.add(current);
			}
			String[] neighbors=graph.get(current); 
			for(String neighbor:neighbors) { 
				if(!visited.contains(neighbor)) {
					stack.push(neighbor); 
				}
				
			}
		}
	}
	*/

}
