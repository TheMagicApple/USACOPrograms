import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class MooParticle {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[][] particles=new int[n][2];
		for(int i=0;i<n;i++) {
			particles[i]=new int[] {s.nextInt(),s.nextInt()};
		}
		HashMap<Integer,ArrayList<Integer>> graph=new HashMap<>();
		for(int i=0;i<n;i++) {
			for(int k=i+1;k<n;k++) {
				if((particles[i][0]<=particles[k][0] && particles[i][1]<=particles[k][1]) || (particles[i][0]>=particles[k][0] && particles[i][1]>=particles[k][1])) {
					ArrayList<Integer> a1=new ArrayList<>();
					ArrayList<Integer> a2=new ArrayList<>();
					if(graph.get(i)!=null) a1=graph.get(i);
					if(graph.get(k)!=null) a2=graph.get(k);
					a1.add(k);
					a2.add(i);
					graph.put(i, a1);
					graph.put(k, a2);
				}
			}
		}
		for(int i=0;i<graph.size();i++) {
			for(int k=0;k<graph.size();k++) {
				if(graph.get(i).size()>graph.get(k).size()) {
					ArrayList<Integer> temp=graph.get(k);
					graph.put(k, graph.get(i));
					graph.put(i, temp);
				}
			}
		}
		Object[] o=graph.keySet().toArray();
		System.out.println(graph);
		for(int i=0;i<o.length;i++) {
			int ii=(int)o[i];
			if(graph.get(ii).size()>0) {
				ArrayList<Integer> a=graph.get(ii);
				graph.remove(ii);
				System.out.println("REMOVED "+ii);
				for(int iii:a) {
					graph.get(iii).remove(new Integer(ii));
				}
				
			}
		}
		System.out.println(graph);
		System.out.println(graph.size());
		

	}

}
