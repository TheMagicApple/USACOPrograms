import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Hoofball {
	private static int nCows;
	private static int[] cows;
	private static int[] passes;
	private static boolean[] passedTo;
	public static int pass(int cow) {
		int right=0;
		int left=0;
		if(cow!=0) {
			left=cow-1;
		}else {
			return cow+1;
		}
		if(cow!=nCows-1) {
			right=cow+1;
		}else {
			return cow-1;
		}
		if(cows[cow]-cows[left]>Math.abs(cows[cow]-cows[right])) {
			return right;
		}
		if(cows[cow]-cows[left]<Math.abs(cows[cow]-cows[right])) {
			return left;
		}
		if(cows[cow]-cows[left]==Math.abs(cows[cow]-cows[right])) {
			return left;
		}
		return Integer.MIN_VALUE;
	}
	public static int giveBallTo(int cow) {
		boolean done=false;
		int a=cow;
		ArrayList<Integer> goodCows=new ArrayList<>();
		while(!done) {
			if(goodCows.contains(a)) {
				done=true;
				return goodCows.size()-1;
			}else {
				goodCows.add(a);
			}
			a=pass(a);
		}
		return Integer.MIN_VALUE;
	}
	public static boolean check() {
		for(boolean passed:passedTo) {
			if(!passed) {
				//System.out.println("not done yet");
				return false;
			}
		}
		return true;
	}
	public static void passTo(int cow) {
		boolean done=false;
		int a=cow;
		ArrayList<Integer> goodCows=new ArrayList<>();
		while(!done) {
			//if(passedTo[a]==true) {
				//return;
			//}
			if(goodCows.contains(a)) {
				done=true;
				
			}else {
				goodCows.add(a);
				passedTo[a]=true;
			}
			a=pass(a);
		}
		//return Integer.MIN_VALUE;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		nCows=s.nextInt();
		cows=new int[nCows];
		passes=new int[nCows];
		passedTo=new boolean[nCows];
		for(int i=0;i<nCows;i++) {
			cows[i]=s.nextInt();
		}
		Arrays.sort(cows);
		for(int i=0;i<nCows;i++) {
			passes[i]=giveBallTo(i);
		}
		for(int pass:passes) {
			//System.out.println(pass);
		}
		int numberOfPasses=0;
		while(!check()) {
			int maximum=0;
			int maximumIndex=0;
			for(int i=0;i<nCows;i++) {
				if(passes[i]>maximum) {
					maximum=passes[i];
					maximumIndex=i;
				}
			}
			//System.out.println("index:"+maximumIndex);
			passTo(maximumIndex);
			passes[maximumIndex]=0;
			numberOfPasses++;
			
		}
		System.out.println(numberOfPasses);
		
		
		
		
	}
	
	

}
