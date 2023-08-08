import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MyCowAteMyHomework {

	public static void main(String[] args) {
		//success!
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		ArrayList<Integer> scores=new ArrayList<>();
		for(int i=0;i<n;i++) {
			scores.add(s.nextInt());
		}
		Collections.reverse(scores);
		
		int currentMin=scores.get(0);
		if(scores.get(1)<scores.get(0)) currentMin=scores.get(1);
		double currentAvg=(scores.get(0)+scores.get(1)-currentMin)/1f;
		
		ArrayList<Integer> goodK=new ArrayList<>();
		double maxScore=currentAvg;
		goodK.add(n-2);
		for(int i=2;i<scores.size()-1;i++) { //bessie leaves 2 scores left...n-1 scores left
			int newScore=scores.get(i);
			if(currentMin<newScore) {
				currentAvg+=(newScore-currentAvg)/(i);
			}else {
				currentAvg+=(currentMin-currentAvg)/(i);
				currentMin=newScore;
			}
			if(currentAvg==maxScore) {
				goodK.add(scores.size()-i-1);
			}
			if(currentAvg>maxScore) {
				maxScore=currentAvg;
				goodK.clear();
				goodK.add(scores.size()-i-1);
			}
			
		}
		Collections.sort(goodK);
		for(int k:goodK) {
			System.out.println(k);
		}

	}

}
