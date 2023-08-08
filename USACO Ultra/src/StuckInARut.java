import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class StuckInARut {

	public static void main(String[] args) {
		//fail :(
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		ArrayList<Vector> total=new ArrayList<>();
		ArrayList<Vector> moveRight=new ArrayList<>();
		ArrayList<Vector> moveUp=new ArrayList<>();
		HashMap<Vector,ArrayList<Vector>> collisions=new HashMap<>();
		for(int i=0;i<n;i++) {
			String string=s.next();
			Vector v=new Vector(s.nextInt(),s.nextInt());
			if(string.equals("E")) {
				moveRight.add(v);
			}else {
				moveUp.add(v);
			}
			total.add(v);
		}
		Collections.sort(moveRight, new Comparator<Vector>() {
		    public int compare(Vector a, Vector b) {
		        return Integer.compare(a.y,b.y);
		    }
		});
	
		Collections.sort(moveUp, new Comparator<Vector>() {
		    public int compare(Vector a, Vector b) {
		        return Integer.compare(a.x,b.x);
		    }
		});
		for(int i=0;i<moveRight.size();i++) {
			for(int k=0;k<moveUp.size();k++) {
				Vector cowRight=moveRight.get(i);
				Vector cowUp=moveUp.get(k);
				if(cowUp.x>=cowRight.x && cowUp.y<=cowRight.y) { // -__|
					int rightTime=cowUp.x-cowRight.x;
					int upTime=cowRight.y-cowUp.y;
					//System.out.println("COLLISION "+rightTime+" "+upTime);
					if(rightTime==upTime) { //if they collide exactly, nothing happens
						
					}else {
						if(rightTime>upTime) { //cow moving up is going to get there first, cow moving up causes collision for cow moving right, cow moving right is now irrelevant and no need to check rest of cows moving up
							ArrayList<Vector> a=new ArrayList<>();
							if(collisions.get(cowUp)!=null)a=collisions.get(cowUp);
							a.add(cowRight);
							collisions.put(cowUp, a);
							moveRight.remove(cowRight);
							i--;
							break;
						}
						if(rightTime<upTime) { //cow moving right is going to get there first, cow moving right causes collision for cow moving up, cow moving up is now irrelevant
							ArrayList<Vector> a=new ArrayList<>();
							if(collisions.get(cowRight)!=null)a=collisions.get(cowRight);
							a.add(cowUp);
							collisions.put(cowRight, a);
							moveUp.remove(cowUp);
							k--;
						}
					}
				}
			}
		}
		//System.out.println(collisions);
		for(int i=0;i<n;i++) {
			System.out.println(blame(total.get(i),collisions));
		}
	}
	public static int blame(Vector cow,HashMap<Vector,ArrayList<Vector>> collisions) {
		if(collisions.get(cow)==null) return 0;
		int blame=collisions.get(cow).size();
		for(Vector collided:collisions.get(cow)) {
			blame+=blame(collided,collisions);
		}
		return blame;
	}
}
