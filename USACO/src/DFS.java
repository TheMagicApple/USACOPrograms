import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class DFS {
	public static void main(String[] args) {
		HashMap<String,String[]> graph=new HashMap<>();
		graph.put("a",new String[] {"b","c"});
		graph.put("b",new String[] {"d"});
		graph.put("c",new String[] {"e"});
		graph.put("d",new String[] {"f"});
		graph.put("e",new String[] {});
		graph.put("f",new String[] {});
		search(graph);
	}
	public static void search(HashMap<String,String[]> graph) {
		Stack<String> stack=new Stack<>(); //STACK
		stack.push("a"); //arbitrary starting node
		while(!stack.empty()) {
			String current=stack.pop(); //the current node we are looking at is the top of the stack
			System.out.print(current+" "); //print the current node (used to display the whole graph)
			String[] neighbors=graph.get(current); //get the neighbors of the current node
			for(String neighbor:neighbors) { //go through each neighbor
				stack.push(neighbor); //add the neighbor to the stack
			}
		}
	}

}
