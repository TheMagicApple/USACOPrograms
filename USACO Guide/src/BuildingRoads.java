//INCOMPLETE
import java.util.ArrayList;
import java.util.Scanner;

public class BuildingRoads {
	private static int n;
	private static int m;
	private static int[][] roads;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		m=s.nextInt();
		roads=new int[m][2];
		for(int i=0;i<m;i++) {
			int[] road=new int[2];
			road[0]=s.nextInt();
			road[1]=s.nextInt();
			roads[i]=road;
		}
		Civilization[] civilizations=new Civilization[n];
		for(int i=0;i<n;i++) {
			civilizations[i]=new Civilization(i+1);
		}
		for(int i=1;i<n+1;i++) {
			for(int[] road:roads) {
				if(road[0]==i) {
					civilizations[road[0]-1].sendHorse(civilizations[road[1]-1]);
				}
			}
		}
		Civilization chosen=civilizations[0];
		for(Civilization civilization:civilizations) {
			if(civilization.gotMessage()) {
				chosen=civilization;
				break;
			}
		}
		ArrayList<int[]> newRoads=new ArrayList<>();
		for(Civilization civilization:civilizations) {
			if(!civilization.gotMessage()) {
				int[] newRoad=new int[2];
				newRoad[0]=chosen.getID();
				newRoad[1]=civilization.getID();
				newRoads.add(newRoad);
				
			}
		}
		System.out.println(newRoads.size());
		for(int[] newRoad:newRoads) {
			System.out.println(newRoad[0]+" "+newRoad[1]);
		}
		

	}

}
class Civilization{
	private boolean hasMessage=false;
	private int id;
	public Civilization(int id) {
		this.id=id;
	}
	public int getID() {
		return id;
	}
	public void sendHorse(Civilization other) {
		other.receiveHorse();
	}
	public void receiveHorse() {
		hasMessage=true;
	}
	public boolean gotMessage() {
		return hasMessage;
	}
}
