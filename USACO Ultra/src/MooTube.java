import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class MooTube {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int q=s.nextInt();
		HashMap<Integer,ArrayList<Vector>> graph=new HashMap<>();
		for(int i=0;i<n-1;i++) {
			int video1=s.nextInt();
			int video2=s.nextInt();
			int relevance=s.nextInt();
			ArrayList<Vector> a1=new ArrayList<>();
			ArrayList<Vector> a2=new ArrayList<>();
			if(graph.get(video1)!=null) a1=graph.get(video1);
			if(graph.get(video2)!=null) a2=graph.get(video2);
			a1.add(new Vector(video2,relevance));
			a2.add(new Vector(video1,relevance));
			graph.put(video1, a1);
			graph.put(video2, a2);
		}
		ArrayList<ArrayList<Integer>>[] a=new ArrayList[n];
		for(int i=1;i<n+1;i++) {
			ArrayList<ArrayList<Integer>> paths=getPaths(graph,i);
			//System.out.println(paths);
			a[i-1]=paths;
		}
		Vector[] queries=new Vector[q];
		for(int i=0;i<q;i++) {
			queries[i]=new Vector(s.nextInt(),s.nextInt());
		}
		for(Vector query:queries) {
			ArrayList<ArrayList<Integer>> recom=a[query.y-1];
			//System.out.println(recom);
			int count=0;
			for(ArrayList<Integer> path:recom) {
				if(path.get(0)>=query.x) {
					count++;
				}
			}
			System.out.println(count);
		}

	}
	public static ArrayList<ArrayList<Integer>> getPaths(HashMap<Integer,ArrayList<Vector>> graph,int start){
		HashSet<Integer> visited=new HashSet<>();
		Queue<Integer> stack=new LinkedList<>();
		ArrayList<ArrayList<Integer>> paths=new ArrayList<>();
		stack.add(start); 
		ArrayList<Integer> sstart=new ArrayList<>();
		sstart.add(10000000);
		sstart.add(start);
		paths.add(sstart);
		ArrayList<ArrayList<Integer>> good=new ArrayList<>();
		good.add(sstart);
		
		while(stack.size()>0) {
			int current=stack.poll();
			
			//System.out.println(current);
			if(!visited.contains(current)) {
				visited.add(current);
			}
			ArrayList<Vector> neighbors=graph.get(current); 
			ArrayList<Integer> g=good.remove(0);
			for(Vector neighbor:neighbors) { 
				if(!visited.contains(neighbor.x)) {
					stack.add(neighbor.x);
					
					int size=paths.size();
					//for(int i=0;i<size;i++) {
						ArrayList<Integer> p=(ArrayList<Integer>) g.clone();
						p.add(neighbor.x);
						if(neighbor.y<p.get(0)) {
							p.set(0, neighbor.y);
						}
						//System.out.println(p);
						paths.add(p);
						good.add(p);
					//}
					
				}
				
			}
		}
		paths.remove(0);
		return paths;
		
		
	}

}
