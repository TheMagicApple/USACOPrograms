import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class MooTube {

	public static void main(String[] args) {
		//success? (5/9 initially but then got hint from solution and now works)???
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
		/*
		ArrayList<ArrayList<Integer>>[] a=new ArrayList[n];
		for(int i=1;i<n+1;i++) {
			ArrayList<ArrayList<Integer>> paths=getPaths(graph,i);
			//System.out.println(i);
			//System.out.println(paths);
			a[i-1]=paths;
		}
		*/
		//System.out.println("PRECALC DONE");
		Vector[] queries=new Vector[q];
		for(int i=0;i<q;i++) {
			queries[i]=new Vector(s.nextInt(),s.nextInt());
		}
		for(Vector query:queries) {
			System.out.println(canGetTo(graph,query.y,query.x));
		}

	}
	public static int canGetTo(HashMap<Integer,ArrayList<Vector>> graph,int start,int k) {
		HashSet<Integer> visited=new HashSet<>();
		Queue<Integer> stack=new LinkedList<>();
		stack.add(start); 
		while(stack.size()>0) {
			int current=stack.poll();
			if(!visited.contains(current)) {
				visited.add(current);
			}
			ArrayList<Vector> neighbors=graph.get(current); 
			for(Vector neighbor:neighbors) { 
				if(!visited.contains(neighbor.x) && neighbor.y>=k) {
					stack.add(neighbor.x);
				}
			}
		}
		return visited.size()-1;
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
			if(!visited.contains(current)) {
				visited.add(current);
			}
			ArrayList<Vector> neighbors=graph.get(current); 
			ArrayList<Integer> g=good.remove(0);
			for(Vector neighbor:neighbors) { 
				if(!visited.contains(neighbor.x)) {
					stack.add(neighbor.x);
						ArrayList<Integer> p=(ArrayList<Integer>) g.clone();
						p.add(neighbor.x);
						if(neighbor.y<p.get(0)) {
							p.set(0, neighbor.y);
						}
						paths.add(p);
						good.add(p);
				}
			}
		}
		paths.remove(0);
		return paths;
		
		
	}

}
