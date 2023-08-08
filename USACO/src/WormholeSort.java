import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class WormholeSort {
	private static int[] cows;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int m=s.nextInt();
		cows=new int[n];
		for(int i=0;i<n;i++) {
			cows[i]=s.nextInt();
		}
		HashMap<Integer,ArrayList<Vector>> graph=new HashMap<>();
		for(int i=0;i<m;i++) {
			int cow1=s.nextInt();
			int cow2=s.nextInt();
			int cost=s.nextInt();
			ArrayList<Vector> a1=new ArrayList<>();
			ArrayList<Vector> a2=new ArrayList<>();
			if(graph.get(cow1)!=null) a1=graph.get(cow1);
			if(graph.get(cow2)!=null) a2=graph.get(cow2);
			a1.add(new Vector(cow2,cost));
			a2.add(new Vector(cow1,cost));
			graph.put(cow1, a1);
			graph.put(cow2, a2);
		}
		System.out.println("!"+dfs(graph));

	}
	public static int dfs(HashMap<Integer,ArrayList<Vector>> graph) {
		int maxminWidth=-1;
		Iterator<Integer> i=graph.keySet().iterator();
		while(i.hasNext()) {
			int current=i.next();
			Stack<Vector[]> stack=new Stack<>();
			stack.add(new Vector[] {new Vector(-1,-1),new Vector(current,-1)});
			int minWidth=100;
			int[] moo=cows.clone();
			while(!stack.empty()) {
				boolean bad=false;
				for(int k=0;k<moo.length-1;k++) {
					if(moo[k]>moo[k+1]) {
						bad=true;
						break;
					}
				}
				if(!bad) {
					System.out.println("?"+minWidth);
					if(minWidth>maxminWidth) {
						maxminWidth=minWidth;
					}
					break;
				}
				Vector[] info=stack.pop();
				Vector previous=info[0];
				current=info[1].x;
				if(previous.x!=-1) {
					int swap=cows[previous.x-1];
					moo[previous.x-1]=moo[current-1];
					moo[current-1]=swap;
					System.out.println(info[1].y);
					if(info[1].y<minWidth) {
						minWidth=info[1].y;
					}
				}
				ArrayList<Vector> neighbors=graph.get(current);
				for(Vector neighbor:neighbors) {
					if((neighbor.x-current>0 && moo[neighbor.x-1]-moo[current-1]<0) || (neighbor.x-current<0 && moo[neighbor.x-1]-moo[current-1]>0)) {
						stack.add(new Vector[] {info[1],neighbor});
					}
				}
			}
			
			
		}
		return maxminWidth;
		
	}

}
