import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GraphUtils {

	public static void main(String[] args) {
		/*
		HashMap<Integer,ArrayList<int[]>> graph=new HashMap<>(); //undirected weighted graph
		graph.put(1, new ArrayList<int[]>(Arrays.asList(new int[]{2,5},new int[]{5,1},new int[]{4,9})));
		graph.put(2, new ArrayList<int[]>(Arrays.asList(new int[]{1,5},new int[]{3,2})));
		graph.put(3, new ArrayList<int[]>(Arrays.asList(new int[]{2,2},new int[]{4,6})));
		graph.put(4, new ArrayList<int[]>(Arrays.asList(new int[]{3,6},new int[]{5,2},new int[]{1,9})));
		graph.put(5, new ArrayList<int[]>(Arrays.asList(new int[]{4,2},new int[]{1,1})));
		//HashMap<Integer,Integer> shortestPaths=dijkstra(graph,1);
		//System.out.println(shortestPaths);
		
		int[][] shortestPaths=floydwarshall(graph);
		for(int[] a:shortestPaths) {
			for(int i:a) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
		*/
		//HashMap<Integer,ArrayList<Integer>> graph=new HashMap<>();
		Graph<Integer> graph=new Graph<>();
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		for(int i=0;i<n;i++) {
			int field1=s.nextInt();
			int field2=s.nextInt();
			graph.connect(field1, field2);
			
		}
		HashSet<Integer> h=new HashSet<>();
		//h.add(5);
		h.add(3);
		h.add(4);
		h.add(1);
		h.add(2);
		//System.out.println(graph.graph);
		
		System.out.println(graph.cycle(h));
	}
	public static void dfs(HashMap<Integer,ArrayList<Integer>> graph) { //traverses graph, time complexity: O(N)
		Stack<Integer> stack=new Stack<>();
		HashSet<Integer> visited=new HashSet<>();
		int current=graph.keySet().iterator().next();
		stack.add(current);
		while(!stack.empty()) {
			current=stack.pop(); 
			if(!visited.contains(current)) {
				visited.add(current);
				System.out.print(current+" "); 
				ArrayList<Integer> neighbors=graph.get(current); 
				for(int neighbor:neighbors) {
					if(!visited.contains(neighbor)) {
						stack.push(neighbor);
					}
				}
			}
		}
	}
	public static void bfs(HashMap<Integer,ArrayList<Integer>> graph) { //traverses graph, time complexity: O(N)
		Queue<Integer> queue=new LinkedList<>();
		HashSet<Integer> visited=new HashSet<>();
		int current=graph.keySet().iterator().next();
		queue.add(current);
		while(!queue.isEmpty()) {
			current=queue.poll();
			if(!visited.contains(current)) {
				visited.add(current);
				System.out.print(current+" "); 
				ArrayList<Integer> neighbors=graph.get(current); 
				for(int neighbor:neighbors) {
					if(!visited.contains(neighbor)) {
						queue.add(neighbor);
					}
				}
			}
		}
	}
	public static int shortestPath(HashMap<Integer,ArrayList<Integer>> graph,int start,int end) { //finds shortest path between start and end, time complexity: O(N)
		Queue<String> queue=new LinkedList<>();
		HashSet<Integer> visited=new HashSet<>();
		String current=start+" 0";
		queue.add(current);
		while(!queue.isEmpty()) {
			current=queue.poll();
			int node=Integer.parseInt(current.split(" ")[0]);
			int path=Integer.parseInt(current.split(" ")[1]);
			if(!visited.contains(node)) {
				visited.add(node);
				if(node==end) {
					return path;
				}
				ArrayList<Integer> neighbors=graph.get(node); 
				for(int neighbor:neighbors) {
					if(!visited.contains(neighbor)) {
						queue.add(neighbor+" "+(path+1));
					}
				}
			}
		}
		return -1;
	}
	public static ArrayList<SortedSet<Integer>> connectedcomponents(HashMap<Integer,ArrayList<Integer>> graph) { //returns list of connected components, time complexity: O(N)
		HashSet<Integer> visited=new HashSet<>();
		Iterator<Integer> i=graph.keySet().iterator();
		ArrayList<SortedSet<Integer>> groups=new ArrayList<>();
		while(i.hasNext()) {
			int next=i.next();
			SortedSet<Integer> group=new TreeSet<>();
			if(!visited.contains(next)) {
				Stack<Integer> stack=new Stack<>();
				stack.push(next); 
				while(!stack.empty()) {
					int current=stack.pop();
					if(!visited.contains(current)) {
						visited.add(current);
						group.add(current);
					}
					ArrayList<Integer> neighbors=graph.get(current); 
					for(int neighbor:neighbors) { 
						if(!visited.contains(neighbor)) {
							stack.push(neighbor); 
						}
						
					}
				}
			}
			if(group.size()>0) {
				groups.add(group);
			}
		}
		return groups;
	}
	public static int[][] floydwarshall(HashMap<Integer,ArrayList<int[]>> graph){ //returns shortest path from all pairs of nodes, time complexity: O(N*N*N)
		int[][] paths=new int[graph.size()][graph.size()];
		for(int i=0;i<graph.size();i++) {
			for(int k=0;k<graph.size();k++) {
				if(i==k) {
					paths[i][k]=0;
				}else {
					boolean foundPath=false;
					for(int[] key:graph.get(i+1)) {
						if(key[0]-1==k) {
							paths[i][k]=key[1];
							foundPath=true;
							break;
						}
					}
					if(!foundPath) {
						paths[i][k]=999999999;
					}
				}
				
			}
		}
		for(int i=0;i<graph.size();i++) {
			for(int k=0;k<graph.size();k++) {
				for(int j=0;j<graph.size();j++) {
					paths[k][j]=Math.min(paths[k][j], paths[k][i]+paths[i][j]);
				}
			}
		}
		return paths;
	
	}
	public static HashMap<Integer,Integer> dijkstra(HashMap<Integer,ArrayList<int[]>> graph,int start){ //returns shortest path from start to all other nodes, time complexity: O(N*NlogN) 
		HashMap<Integer,Integer> paths=new HashMap<>();
		for(int key:graph.keySet()) {
			paths.put(key,999999999);
		}
		paths.put(start,0);
		HashSet<Integer> visited=new HashSet<>();
		while(visited.size()<graph.size()) {
			paths = paths.entrySet().stream().sorted(Entry.comparingByValue()).collect(Collectors.toMap(Entry::getKey, Entry::getValue,(e1, e2) -> e1, LinkedHashMap::new));
			for(int key:paths.keySet()) {
				if(!visited.contains(key)) {
					visited.add(key);
					int currentDistance=paths.get(key);
					for(int[] neighbor:graph.get(key)) {
						if(currentDistance+neighbor[1]<paths.get(neighbor[0])) {
							paths.put(neighbor[0], currentDistance+neighbor[1]);
						}
					}
					break;
				}
			}
		}
		return paths;
	}
}