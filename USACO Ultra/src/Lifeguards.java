import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Lifeguards {

	public static void main(String[] args) {
		//failed :(
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		ArrayList<int[]> lifeguards=new ArrayList<>();
		for(int i=0;i<n;i++) {
			lifeguards.add(new int[] {s.nextInt(),s.nextInt()});
		}
		Collections.sort(lifeguards, new Comparator<int[]>() {
		    public int compare(int[] a, int[] b) {
		        return Integer.compare(a[0], b[0]);
		    }
		});
		int leastBad=10000000;
		int leastIndex=-1;
		int currentTime=1;
		
		int currentLifeguard=0;
		int minAlone=100000000;
		int alone=0;
		int minutes=0;
		boolean waitingPeriod=false;
		ArrayList<Integer> lifeguardsServing=new ArrayList<>();
		int timer=0;
		for(int i=1;i<1000000;i++) {
			if(i==lifeguards.get(currentLifeguard)[0]) {
				timer=lifeguards.get(currentLifeguard)[1]-lifeguards.get(currentLifeguard)[0]+1;
				currentLifeguard++;
				if(currentLifeguard==lifeguards.size()) {
					minutes+=timer;
					break;
				}
			}
			timer--;
			if(timer>1) {
				minutes++;
			}
			
			
		}
		System.out.println(minutes);

	}


}
