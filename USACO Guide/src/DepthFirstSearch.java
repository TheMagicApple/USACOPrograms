import java.util.ArrayList;
import java.util.Scanner;
// LOOK AT THE DIAGRAMS :O https://www.programiz.com/dsa/graph-dfs
public class DepthFirstSearch {
private static int cN;
	private static int gN;
	private static Point[] points;
	public static void main(String[] args) {
		// INPUT
		Scanner s=new Scanner(System.in);
		gN=s.nextInt();
		points=new Point[gN];
		for(int i=0;i<gN;i++) {
			points[i]=new Point(i);
		}
		cN=s.nextInt();
		for(int i=0;i<cN;i++) {
			int[] connection=new int[2];
			connection[0]=s.nextInt();
			connection[1]=s.nextInt();
			points[connection[0]].addConnection(connection[1]);
		}
		// DEPTH FIRST SEARCH
		Point current=points[0]; //set the vertex
		ArrayList<Point> visited=new ArrayList<>(); //list of points visited
		ArrayList<Point> stack=new ArrayList<>(); //list of points we need to visit (like a todo list)
		stack.add(current); //the first point we need to visit is the vertex
		while(stack.size()>0) { //we keep going until we have no more points we can visit
			current=stack.get(0); //current point we are looking at
			visited.add(current); //we are visiting the current point
			stack.remove(0); //we just visited the current point so remove it from the list of points we need to visit
			ArrayList<Integer> connections=current.getConnections(); //get the current point's connections
			for(int connection:connections) { //go through each connection
				if(!visited.contains(points[connection])){ //if we have not visited the current point's connection
					stack.add(0,points[connection]); //add it to the list of points we need to visit (bc it is visitable bc it is connected to a visited point so it must be visited eventually)
				}
			}
		}
		// OUTPUT
		for(int i=0;i<visited.size();i++) {
			System.out.println(visited.get(i).getID());
		}
	}
}
class Point{
	private ArrayList<Integer> connectedTo;
	private int id;
	public Point(int id) {
		connectedTo=new ArrayList<>();
		this.id=id;
	}
	public void addConnection(int connection) {
		connectedTo.add(connection);
	}
	public ArrayList<Integer> getConnections() {
		return connectedTo;
	}
	public int getID() {
		return id;
	}
}
