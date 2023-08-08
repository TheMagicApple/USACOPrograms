import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class YearOfTheCowSilver {
	private static int n;
	private static int k;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		k=s.nextInt();
		ArrayList<Integer> numberTargets=new ArrayList<>();
		for(int i=0;i<n;i++) {
			int target=s.nextInt()/12;
			if(!numberTargets.contains(target)) {
				numberTargets.add(target);
			}
		}
		numberTargets.add(0);
		Collections.sort(numberTargets);
		int steps=0;
		
		//System.out.println(numberTargets);
		int youIndex=numberTargets.size()-1;
		int you=numberTargets.get(numberTargets.size()-1);
		while(numberTargets.size()>1) {
			//System.out.println(youIndex);
			int target=numberTargets.get(youIndex-1);
			ArrayList<Integer> targetDistances=new ArrayList<>();
			for(int i=0;i<numberTargets.size()-1;i++) {
				targetDistances.add(numberTargets.get(i+1)-numberTargets.get(i));
			}
			Collections.sort(targetDistances);
			Collections.reverse(targetDistances);
			if(k==0) {
				you=target;
				numberTargets.remove(numberTargets.get(numberTargets.size()-1));
				youIndex--;
				steps+=you-target-1;
			}else {
				
			
			int distance=targetDistances.get(k-1);
			int losing=distance-1;
			int gaining=you-target-1;
			if(gaining>=losing && k>0) {
				you=target;
				numberTargets.remove(numberTargets.get(numberTargets.size()-1));
				k--;
				youIndex--;
				steps++;
			}else {
				you=target;
				numberTargets.remove(numberTargets.get(numberTargets.size()-1));
				youIndex--;
				steps+=gaining;
			}
			}
		}
		System.out.println(steps*12);
		

	}

}
