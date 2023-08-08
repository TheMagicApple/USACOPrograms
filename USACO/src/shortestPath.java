import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class shortestPath {

	public static void main(String[] args) {
		HashMap<String,String[]> graph=new HashMap<>();
		graph.put("a",new String[] {"b","c"});
		graph.put("b",new String[] {"d","a"});
		graph.put("c",new String[] {"a"});
		graph.put("d",new String[] {"e","b"});
		graph.put("e",new String[] {"d","c"});
		
		Scanner s=new Scanner(System.in);
		System.out.println("Starting node: ");
		String start=s.next();
		System.out.println("Ending node: ");
		String end=s.next();
		System.out.println(search(graph,start,end));

	}
	public static int search(HashMap<String,String[]> graph,String start,String end) {
		//basically run bfs and track the distance of each node from start and when you hit target return that distance
		HashSet<String> visited=new HashSet<>();
		Queue<String> stack=new LinkedList<>();
		stack.add(start+"0"); 
		while(stack.size()>0) {
			String current=stack.poll();
			int distance=Integer.parseInt(current.substring(current.length()-1));
			current=current.substring(0,current.length()-1);
			if(!visited.contains(current)) {
				visited.add(current);
			}
			if(current.equals(end)) {
				return distance;
			}
			String[] neighbors=graph.get(current); 
			
			for(String neighbor:neighbors) { 
				if(!visited.contains(neighbor)) {
					stack.add(neighbor+(distance+1));
				}
				
			}
		}
		return -1;
	}

}
