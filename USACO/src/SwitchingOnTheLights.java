import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

public class SwitchingOnTheLights {
	private static boolean[][] lights;
	private static int n;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		int m=s.nextInt();
		lights=new boolean[n][n];
		lights[0][0]=true;
		HashMap<Vector,ArrayList<Vector>> switches=new HashMap<>();
		for(int i=0;i<m;i++) {
			Vector v=new Vector(s.nextInt(),s.nextInt());
			ArrayList<Vector> a=new ArrayList<>();
			if(switches.get(v)!=null) a=switches.get(v);
			a.add(new Vector(s.nextInt(),s.nextInt()));
			switches.put(v,a);
		}
		System.out.println(search(switches));
	}
	public static int search(HashMap<Vector,ArrayList<Vector>> switches) {
		Stack<Vector> stack=new Stack<>();
		Vector current=new Vector(1,1);
		stack.add(current);
		int count=1;
		HashSet<Vector> visited=new HashSet<>();
		while(!stack.empty()) {
			current=stack.pop();
			if(!visited.contains(current) && lights[current.y-1][current.x-1]==true) {
				visited.add(current);
				if(switches.get(current)!=null) {
					for(Vector light:switches.get(current)) {
						if(lights[light.y-1][light.x-1]==false) {
							lights[light.y-1][light.x-1]=true;
							count++;
						}
						
					}
				}
				Vector[] neighbors=new Vector[] {new Vector(current.x-1,current.y),new Vector(current.x+1,current.y),new Vector(current.x,current.y+1),new Vector(current.x,current.y-1)};
				for(Vector neighbor:neighbors) {
					if(neighbor.x>0 && neighbor.y>0 && neighbor.x<n && neighbor.y<n) {
						stack.add(neighbor);
						
					}
				}
			}
		}
		return count;
	}
}