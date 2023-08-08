import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;
public class FlightRoutesCheck {
	private static int failureFrom;
	private static int failureTo;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int m=s.nextInt();
		HashMap<Integer,ArrayList<Integer>> graph=new HashMap<>();
		for(int i=0;i<m;i++) {
			int city1=s.nextInt();
			int city2=s.nextInt();
			ArrayList<Integer> a=new ArrayList<>();
			if(graph.get(city1)!=null) a=graph.get(city1);
			a.add(city2);
			graph.put(city1, a);
		}
		boolean failed=false;
		for(int i=0;i<n;i++) {
			if(!dfs(graph,i+1)) {
				System.out.println("NO");
				System.out.println(failureFrom+" "+failureTo);
				failed=true;
				break;
			}
		}
		if(!failed) {
			System.out.println("YES");
		}
	}
	private static boolean dfs(HashMap<Integer,ArrayList<Integer>> graph,int start) {
		HashSet<Integer> visited=new HashSet<>();
		Stack<Integer> stack=new Stack<>();
		HashMap<Integer,ArrayList<Integer>> copy=(HashMap<Integer, ArrayList<Integer>>) graph.clone();
		int current=start;
		stack.add(start);
		while(!stack.empty()) {
			current=stack.pop();
			if(!visited.contains(current) && graph.get(current)!=null) {
				visited.add(current);
				copy.remove(current);
				for(int neighbor:graph.get(current)) {
					stack.add(neighbor);
				}
			}
		}
		if(visited.size()==graph.size()) {
			return true;
		}
		failureFrom=start;
		failureTo=copy.keySet().iterator().next();
		return false;
	}
}