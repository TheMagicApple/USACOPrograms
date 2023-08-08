import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Cereal2 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int m=s.nextInt();
		HashMap<Integer,ArrayList<Integer>> graph=new HashMap<>();
		ArrayList<Vector> edges=new ArrayList<>();
		for(int i=0;i<n;i++) {
			int prim=s.nextInt();
			int alt=s.nextInt();
			edges.add(new Vector(prim,alt));
			ArrayList<Integer> primA=new ArrayList<>();
			ArrayList<Integer> altA=new ArrayList<>();
			if(graph.get(prim)!=null) {
				primA=graph.get(prim);
			}
			if(graph.get(alt)!=null) {
				altA=graph.get(alt);
			}
			primA.add(alt);
			altA.add(prim);
			graph.put(prim, primA);
			graph.put(alt, altA);
		}
		//System.out.println(graph);
		//System.out.println(edges);
		int eat=0;
		for(int i=0;i<edges.size();i++) {
			Vector edge=edges.get(i);
			int deg1=-1;
			int deg2=-1;
			if(graph.get(edge.x)!=null) {
				deg1=graph.get(edge.x).size();
			}
			if(graph.get(edge.y)!=null) {
				deg2=graph.get(edge.y).size();
			}
			if(deg1==-1 && deg2==-1) {
				//goes hungry :(
			}else {
				eat++;
				if(deg1==-1) {
					graph.remove(edge.y);
				}else if(deg2==-1) {
					graph.remove(edge.x);
				}else {
					if(deg1>deg2) {
						graph.remove(edge.y);
					}else if(deg2>deg1) {
						graph.remove(edge.x);
					}else {
						graph.remove(edge.y);
					}
				}
			}
			
			edges.remove(i);
			i--;
		}
		System.out.println(n-eat);
	}

}
