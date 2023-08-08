import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class MilkVisits {
	static int[] farms;
	public static void main(String[] args) throws IOException {
		BufferedReader r=new BufferedReader(new FileReader("milkvisits.in"));
		//Scanner s=new Scanner(System.in);
		String numbers=r.readLine();
		
		int n=Integer.parseInt(numbers.split(" ")[0]);
		int m=Integer.parseInt(numbers.split(" ")[1]);
		String[] temp=r.readLine().split("");
		farms=new int[n];
		for(int i=0;i<n;i++) {
			if(temp[i].equals("G")) {
				farms[i]=1;
			}
		}
		HashMap<Integer,ArrayList<Integer>> graph=new HashMap<>();
		for(int i=0;i<n-1;i++) {
			String[] read=r.readLine().split(" ");
			int farm1=Integer.parseInt(read[0]);
			int farm2=Integer.parseInt(read[1]);
			ArrayList<Integer> a1=new ArrayList<>();
			ArrayList<Integer> a2=new ArrayList<>();
			if(graph.get(farm1)!=null)a1=graph.get(farm1);
			if(graph.get(farm2)!=null)a2=graph.get(farm2);
			a1.add(farm2);
			a2.add(farm1);
			graph.put(farm1,a1);
			graph.put(farm2, a2);
		}
		int[][] farmers=new int[m][3];
		for(int i=0;i<m;i++) {
			String[] read=r.readLine().split(" ");
			int farm1=Integer.parseInt(read[0]);
			int farm2=Integer.parseInt(read[1]);
			String type=read[2];
			int realType=0;
			if(type.equals("G")) {
				realType=1;
			}
			farmers[i]=new int[] {farm1,farm2,realType};
		}
		
		HashMap<Integer,String> groups=components(graph);
		String output="";
		for(int[] farmer:farmers) {
			String group1=groups.get(farmer[0]);
			String group2=groups.get(farmer[1]);
			if(group1.equals(group2)) {
				String groupType=group1.split("-")[1];
				if(Integer.parseInt(groupType)==farmer[2]) {
					output+="1";
				}else {
					output+="0";
				}
			}else {
				output+="1";
			}
		}
		BufferedWriter b=new BufferedWriter(new FileWriter("milkvisits.out"));
		b.write(output);
		b.close();
	
	}
	public static HashMap<Integer,String> components(HashMap<Integer,ArrayList<Integer>> graph){
		int count=0;
		HashSet<Integer> visited=new HashSet<>();
		Iterator<Integer> i=graph.keySet().iterator();
		HashMap<Integer,String> groups=new HashMap<>();
		int counter=0;
		while(i.hasNext()) {
			int next=i.next();
			if(!visited.contains(next)) {
				//-------- DFS -----------
				Stack<Integer> stack=new Stack<>();
				stack.push(next); 
				int type=farms[next-1];
				while(!stack.empty()) {
					int current=stack.pop();
					if(!visited.contains(current)) {
						visited.add(current);
						//group.add(current);
						groups.put(current,counter+"-"+type);
					}
					ArrayList<Integer> neighbors=graph.get(current); 
					for(int neighbor:neighbors) { 
						if(!visited.contains(neighbor) && farms[neighbor-1]==type) {
							stack.push(neighbor); 
						}
						
					}
				}
				// -------------------------
				counter++;
			}
		}
		return groups;
	}
}
