import java.util.ArrayList;
import java.util.Scanner;
public class SleepyCows {
	private static int steps=0;
	private static int nCows;
	private static ArrayList<Integer> cows;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		nCows=s.nextInt();
		cows=new ArrayList<>();
		for(int i=0;i<nCows;i++) {
			cows.add(s.nextInt());
		}
		while(!done()) {
			//System.out.println("FLAG 1");
			swap();
		}
		//steps--;
		System.out.println(steps);

	}
	public static void swap() {
		int attention=cows.get(0);
		if(steps<=10) {
			//System.out.println("cow getting moved:"+attention);
		}
		//System.out.println("cow getting moved:"+attention);
		int correct=0;
		for(int i=0;i<nCows;i++) {
			if(cows.get(i)==i+1) {
				correct++;
				
			}else {
				break;
			}
		}
		//System.out.println(correct+"cows are correct");
		if(correct==1) {
			cows.remove(0);
			cows.add(1,attention);
			steps++;
			return;
		}else if(correct>0) {
			cows.remove(0);
			cows.add(correct,attention);
			steps++;
			for(int cow:cows) {
				//System.out.println(cow);
				
			}
			//System.out.println();
			return;
		}
		int indexToInsert=attention-1;
		cows.remove(0);
		if(attention>cows.size()) {
			cows.add(attention);
		}else if(attention==cows.size()){
			cows.add(indexToInsert,attention);
		}else {
			cows.add(indexToInsert,attention);
		}
		
		/*
		for(int i=indexToSwapTo-1;i>=0;i--) {
			
			
			
		}
		*/
		for(int cow:cows) {
			//System.out.println(cow);
			
		}
		//System.out.println();
		steps++;
	}
	public static boolean done() {
		int correct=0;
		for(int i=0;i<nCows;i++) {
			if(cows.get(i)!=i+1) {
				
				
			}else {
				correct++;
			}
		}
		if(correct<nCows) {
			//System.out.println("Correct: "+correct);
			return false;
		}else {
			return true;
		}
		
	}
	
	

}
