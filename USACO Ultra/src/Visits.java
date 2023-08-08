import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Visits {

	public static void main(String[] args) {
		//ac? (6/10 but extremely close on the 4 that are wrong)
		Scanner s=new Scanner(System.in);
		WGraph<Integer> graph=new WGraph<>();
		int n=s.nextInt();
		for(int i=1;i<=n;i++) {
			graph.connect(i, s.nextInt(), s.nextInt());
			//graph.connect(i, s.nextInt());
		}
		
		ArrayList<ArrayList<Integer>> components=graph.connectedComponents();
		//System.out.println(components);
		long total=0;
		for(ArrayList<Integer> component:components) {
			int min=1000000000;
			HashSet<Integer> h=new HashSet<>();
			for(int i:component) {
				h.add(i);
			}
			HashSet<Integer> cycle=graph.cycle(h);
			//System.out.println(cycle);
			//System.out.println(cycle);
			for(int key:graph.keySet) {
				if(h.contains(key)) {
					if(cycle.contains(key)) {
						if(graph.get(key).iterator().next().b<min) {
							min=graph.get(key).iterator().next().b;
						}
					}
					total+=graph.get(key).iterator().next().b;
				}
				
			}
			total-=min;
			//System.out.println("mion"+min);
		}
		
		System.out.println(total);
		
		
		
		//System.out.println(graph.graph);
		/*
		long total=0;
		boolean foundLeaf=true;
		while(foundLeaf) {
			foundLeaf=false;
			ArrayList<Integer> rem=new ArrayList<>();
			for(int key:graph.keySet) {
				//System.out.println("PASS");
				if(graph.inDeg(key)==0) {
					//System.out.println(key);
					//System.out.println(key);
					total+=graph.graph.get(key).iterator().next().b;
					System.out.println(total);
					//graph.remove(key);
					rem.add(key);
					foundLeaf=true;
				}
			}
			for(int i:rem) {
				graph.remove(i);
			}
			//System.out.println("PASS DONE");
		}
		int min=100000000;
		long sum=0;
		for(int key:graph.keySet) {
			int weight=graph.graph.get(key).iterator().next().b;
			sum+=weight;
			if(weight<min) {
				min=weight;
			}
		}
		total+=sum;
		total-=min;
		System.out.println(min);
		System.out.println(total);
		*/
		
		

	}

}
