import java.util.*;
import java.io.*;
public class TheBovineShuffle {

	
	static boolean[] visited=new boolean[100000],onStack=new boolean[100000];
	static int numberOfCycles=0;
	static int[] nextNode=new int[100];
	static ArrayList<Integer> cycles=new ArrayList<>();
	public static void main(String[] args) throws IOException{
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		for(int i=0;i<n;i++) {
			nextNode[i]=s.nextInt()-1;
		}
		for(int i:nextNode) {
			//System.out.print(i+" ");
		}
		for(int i=0;i!=n;++i)
			if(!visited[i])
				dfs(i);
		System.out.println(cycles.size());
		
	}
	public static void dfs(int n){
		visited[n]=onStack[n]=true;
		int u=nextNode[n];
		cycles.add(n);
		if(onStack[u]) {
			++numberOfCycles;
			System.out.println(cycles);
			cycles.clear();
		}
		else if(!visited[u]) {
			dfs(u);
			
		}
		onStack[n]=false;
	}
}
