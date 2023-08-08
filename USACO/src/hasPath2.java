import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class hasPath2 {

	public static void main(String[] args) {
		//undirected graph with cycles
		HashMap<String,String[]> graph=new HashMap<>();
		graph.put("a",new String[] {"b","c"});
		graph.put("b",new String[] {"d","e","a","c"});
		graph.put("c",new String[] {"a","b"});
		graph.put("d",new String[] {"b"});
		graph.put("e",new String[] {"b"});
		graph.put("f", new String[] {"g"});
		graph.put("g", new String[] {"f"});
		Scanner s=new Scanner(System.in);
		System.out.println("Starting node: ");
		String start=s.next();
		System.out.println("Ending node: ");
		String end=s.next();
		if(search(graph,start,end)) {
			System.out.println("It is possible to get from "+start+" to "+end);
		}else {
			System.out.println("It is not possible to get from "+start+" to "+end);
		}

	}
	public static boolean search(HashMap<String,String[]> graph,String start,String end) {
		HashSet<String> visited=new HashSet<>();
		Stack<String> stack=new Stack<>();
		stack.push(start); 
		while(!stack.empty()) {
			String current=stack.pop();
			if(!visited.contains(current)) {
				visited.add(current);
			}
			if(current.equals(end)) {
				return true;
			}
			String[] neighbors=graph.get(current); 
			for(String neighbor:neighbors) { 
				if(!visited.contains(neighbor)) {
					stack.push(neighbor); 
				}
				
			}
		}
		return false;
	}

}
