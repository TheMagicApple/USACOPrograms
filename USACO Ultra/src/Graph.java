import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

public class Graph<E> {
	public HashMap<E,HashSet<E>> graph=new HashMap<>();
	public HashSet<E> keySet=new HashSet<>();
	public HashSet<E> get(E node){ //O(1)
		return graph.get(node);
	}
	public void connect(E node1,E node2) { //O(1)
		if(graph.get(node1)==null) {
			graph.put(node1, new HashSet<>());
			keySet.add(node1);
		}
		if(graph.get(node2)==null) {
			graph.put(node2, new HashSet<>());
			keySet.add(node2);
		}
		graph.get(node1).add(node2);
	}
	public void remove(E node) { //O(N)
		for(E key:keySet) {
			if(graph.get(key)!=null && graph.get(key).contains(node)) {
				graph.get(key).remove(node);
			}
		}
		graph.remove(node);
		keySet.remove(node);
	}
	public int inDeg(E node) { //O(N)
		int deg=0;
		for(E key:keySet) {
			if(graph.get(key)!=null && graph.get(key).contains(node)) {
				deg++;
			}
		}
		return deg;
	}
	public int outDeg(E node) { //O(1)
		return graph.get(node).size();
	}
	public boolean isCyclic() { //O(N)
		int nodes=graph.size();
		HashSet<SortedSet<E>> edges=new HashSet<>();
		for(E key:keySet) {
			if(graph.get(key)!=null) {
				for(E neighbor:graph.get(key)) {
					SortedSet<E> s=new TreeSet<>();
					s.add(key);
					s.add(neighbor);
					edges.add(s);
				}
			}
		}
		return !(nodes==edges.size()+1);
	}
	public boolean isCyclic(HashSet<E> limited) { //O(N)
		int nodes=limited.size();
		HashSet<SortedSet<E>> edges=new HashSet<>();
		for(E key:keySet) {
			if(limited.contains(key) && graph.get(key)!=null) {
				for(E neighbor:graph.get(key)) {
					if(limited.contains(neighbor)) {
						SortedSet<E> s=new TreeSet<>();
						s.add(key);
						s.add(neighbor);
						edges.add(s);
					}
				}
			}
		}
		return !(nodes==edges.size()+1);
	}
	public HashSet<E> cycle(HashSet<E> limited){ //O(N) DIRECTED ONLY
		Stack<E> stack=new Stack<>();
		HashSet<E> visited=new HashSet<>();
		Iterator<E> i=keySet.iterator();
		E current=i.next();
		while(!limited.contains(current)) {
			current=i.next();
		}
		stack.add(current);
		while(!stack.empty()) {
			current=stack.pop();
			if(visited.contains(current)) {
				HashSet<E> theCycle=new HashSet<>();
				boolean recording=false;
				for(E node:visited) {
					if(node.equals(current)) {
						recording=true;
					}
					if(recording) {
						theCycle.add(node);
					}
				}
				return theCycle;
			}else {
				visited.add(current);
				HashSet<E> neighbors=graph.get(current);
				if(neighbors!=null) {
					for(E neighbor:neighbors) {
						if(limited.contains(neighbor)) {
							stack.add(neighbor);
						}
					}
				}
			}
		}
		return null;
	}
	public int shortestPath(E start,E end) { //O(N)
		Queue<Pair<E,Integer>> queue=new LinkedList<>();
		HashSet<E> visited=new HashSet<>();
		Pair<E,Integer> current=new Pair<>(start,0);
		queue.add(current);
		while(!queue.isEmpty()) {
			current=queue.poll();
			E node=current.a;
			int path=current.b;
			if(!visited.contains(node)) {
				visited.add(node);
				if(node.equals(end)) {
					return path;
				}
				HashSet<E> neighbors=graph.get(node);
				if(neighbors!=null) {
					for(E neighbor:neighbors) {
						if(!visited.contains(neighbor)) {
							queue.add(new Pair<>(neighbor,path+1));
						}
					}
				}
			}
		}
		return -1;
	}
	public ArrayList<ArrayList<E>> connectedComponents(){ //O(N)
		HashMap<E,HashSet<E>> graphCopy=new HashMap<>();
		for(E key:keySet) {
			for(E value:graph.get(key)) {
				if(graphCopy.get(key)==null) {
					graphCopy.put(key, new HashSet<>());
				}
				if(graphCopy.get(value)==null) {
					graphCopy.put(value, new HashSet<>());
				}
				graphCopy.get(key).add(value);
				graphCopy.get(value).add(key);
				
			}
		}
		HashSet<E> visited=new HashSet<>();
		Iterator<E> i=graphCopy.keySet().iterator();
		ArrayList<ArrayList<E>> groups=new ArrayList<>();
		while(i.hasNext()) {
			E next=i.next();
			ArrayList<E> group=new ArrayList<>();
			if(!visited.contains(next)) {
				Stack<E> stack=new Stack<>();
				stack.push(next); 
				while(!stack.empty()) {
					E current=stack.pop();
					if(!visited.contains(current)) {
						visited.add(current);
						group.add(current);
					}
					HashSet<E> neighbors=graphCopy.get(current); 
					if(neighbors!=null) {
						for(E neighbor:neighbors) { 
							if(!visited.contains(neighbor)) {
								stack.push(neighbor); 
							}
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
	public String toString() {
		return graph.toString();
	}
	public int size() {
		return graph.size();
	}
	
}
class Pair<A,B>{
	public A a;
	public B b;
	public Pair(A a,B b) {
		this.a=a;
		this.b=b;
	}
	public int hashCode() {
		return ((int)a);
	}
	public String toString() {
		return a+" "+b;
	}
	@Override
	public boolean equals(Object other) {
		return other.hashCode()==hashCode();
	}
}