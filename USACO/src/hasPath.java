import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class hasPath {

	public static void main(String[] args) {
		//directed graph with no cycles
		HashMap<String,String[]> graph=new HashMap<>();
		graph.put("a",new String[] {"b","c"});
		graph.put("b",new String[] {"d"});
		graph.put("c",new String[] {"e"});
		graph.put("d",new String[] {"f"});
		graph.put("e",new String[] {});
		graph.put("f",new String[] {});
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
		Stack<String> stack=new Stack<>();
		stack.push(start); 
		while(!stack.empty()) {
			String current=stack.pop();
			if(current.equals(end)) {
				return true;
			}
			String[] neighbors=graph.get(current); 
			for(String neighbor:neighbors) { 
				stack.push(neighbor); 
			}
		}
		return false;
	}

}
