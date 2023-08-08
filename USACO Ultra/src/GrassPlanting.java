import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class GrassPlanting {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		HashMap<Integer,ArrayList<Integer>> graph=new HashMap<>();
		for(int i=0;i<n-1;i++) {
			int field1=s.nextInt()-1;
			int field2=s.nextInt()-1;
			ArrayList<Integer> a1=new ArrayList<>();
			ArrayList<Integer> a2=new ArrayList<>();
			if(graph.get(field1)!=null) a1=graph.get(field1);
			if(graph.get(field2)!=null) a2=graph.get(field2);
			a2.add(field1);
			a1.add(field2);
			graph.put(field1, a1);
			graph.put(field2, a2);
		}
		int[] fields=new int[n];
		Stack<Integer> stack=new Stack<>();
		HashSet<Integer> visited=new HashSet<>();
		int current=graph.keySet().iterator().next();
		fields[current]=1;
		stack.add(current);
		int neighborCount=0;
		while(!stack.empty()) {
			current=stack.pop(); 
			if(!visited.contains(current)) {
				visited.add(current);
				ArrayList<Integer> neighbors=graph.get(current); 
				HashSet<Integer> typesUsed=new HashSet<>();
				typesUsed.add(fields[current]);
				for(int neighbor:neighbors) {
					typesUsed.add(fields[neighbor]);
				}
				for(int neighbor:neighbors) {
					//System.out.println(neighbor);
					if(!visited.contains(neighbor)) {
						neighborCount++;
						if(fields[neighbor]==0) {
							for(int i=1;i<n;i++) {
								//System.out.println(i);
								if(!typesUsed.contains(i)) {
									typesUsed.add(i);
									fields[neighbor]=i;
									break;
								}
							}
						}
						stack.push(neighbor);
					}
				}
			}
		}
		/*
		while(fieldsDone<n) {
			
		}
		*/
		//System.out.println(neighborCount);
		HashSet<Integer> unique=new HashSet<>();
		for(int type:fields) {
			unique.add(type);
		}
		System.out.println(unique.size());

	}

}
