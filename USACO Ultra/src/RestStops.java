import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class RestStops {

	public static void main(String[] args) {
		//success!
		Scanner s=new Scanner(System.in);
		int l=s.nextInt();
		int n=s.nextInt();
		int farmerSpeed=s.nextInt();
		int bessieSpeed=s.nextInt();
		ArrayList<Vector> restStops=new ArrayList<>();
		for(int i=0;i<n;i++) {
			restStops.add(new Vector(s.nextInt(),s.nextInt()));
		}
		System.out.println(run(l,n,farmerSpeed,bessieSpeed,restStops));
	}
	public static long run(int l,int n,int farmerSpeed,int bessieSpeed,ArrayList<Vector> restStops) {
		Collections.sort(restStops, new Comparator<Vector>() {
		    public int compare(Vector a, Vector b) {
		        return Integer.compare(b.x, a.x);
		    }
		});
		ArrayList<Vector> sortedStops=(ArrayList<Vector>) restStops.clone();
		Collections.sort(sortedStops, new Comparator<Vector>() {
		    public int compare(Vector a, Vector b) {
		        return Integer.compare(b.y, a.y);
		    }
		});
		int currentPosition=0;
		long tasty=0;
		int index=0;
		while(true) {
			Vector maxStop=null;
			for(int a=index;a<sortedStops.size();a++) {
				if(sortedStops.get(a).x>currentPosition) {
					maxStop=sortedStops.get(a);
					index=a+1;
					break;
				}
			}
			if(maxStop==null || index>sortedStops.size()) {
				break;
			}
			long distanceTraveled=maxStop.x-currentPosition;
			currentPosition=maxStop.x;
			long bessieTime=distanceTraveled*bessieSpeed;
			long farmerTime=distanceTraveled*farmerSpeed;
			tasty+=(long)(farmerTime-bessieTime)*maxStop.y;
		}
		return tasty;
	}
}
