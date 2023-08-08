import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

public class largestComponent {

	public static void main(String[] args) {
		HashMap<String,String[]> graph=new HashMap<>();
		graph.put("1",new String[] {"2"});
		graph.put("2",new String[] {"1"});
		graph.put("3",new String[] {"7"});
		graph.put("4",new String[] {"6"});
		graph.put("5",new String[] {"6"});
		graph.put("6", new String[] {"4","5","7","8"});
		graph.put("7", new String[] {"6"});
		graph.put("8", new String[] {"6"});
		System.out.println(largest(graph));

	}
	public static int largest(HashMap<String,String[]> graph) {
		//basically, you dfs starting from each node that has not been visited yet (in total) and go until you cant go anymore and thats one connected component, 
		//and then you count each new node you visited in this dfs and thats the number of nodes in the component, and you find the largest of that. (VERY SIMLAR TO connectedComponents)
		int largestComponent=-1;
		HashSet<String> visited=new HashSet<>();
		Iterator<String> i=graph.keySet().iterator();
		while(i.hasNext()) {
			String next=i.next();
			if(!visited.contains(next)) {
				//-------- DFS -----------
				int nNodes=0;
				Stack<String> stack=new Stack<>();
				stack.push(next); 
				while(!stack.empty()) {
					String current=stack.pop();
					if(!visited.contains(current)) {
						visited.add(current);
						nNodes++;
					}
					String[] neighbors=graph.get(current); 
					for(String neighbor:neighbors) { 
						if(!visited.contains(neighbor)) {
							stack.push(neighbor); 
						}
						
					}
				}
				// -------------------------
				if(nNodes>largestComponent) {
					largestComponent=nNodes;
				}
				
			}
			
		}
		return largestComponent;
	}

}
