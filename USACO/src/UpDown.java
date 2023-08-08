import java.util.ArrayList;
import java.util.Scanner;

public class UpDown {
	private static int n;
	private static int[] cows;
	private static ArrayList<String> pattern;
	private static ArrayList<String> newPattern;
	private static ArrayList<String> currentPattern=new ArrayList<>();
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		cows=new int[n];
		for(int i=0;i<n;i++) {
			cows[i]=s.nextInt();
		}
		String[] thing=s.next().split("");
		pattern=new ArrayList<>();
		for(String str:thing) {
			pattern.add(str);
		}
		for(int i=0;i<cows.length-1;i++) {
			if(cows[i]>cows[i+1]) {
				currentPattern.add("D");
			}else {
				currentPattern.add("U");
			}
		}
		//System.out.println(currentPattern);
		newPattern=(ArrayList<String>) pattern.clone();
		boolean done=false;
		int k=n;
		while(!done) {
			
			if(patternPossible()) {
				//done=true;
				if(patternReallyPossible()) {
					done=true;
				}
			}
			newPattern.remove(newPattern.size()-1);
			k--;
		}
		System.out.println(k);
	}
	private static boolean patternReallyPossible() {
		int i=0;
		int j=1;
		System.out.println(newPattern);
		for(int a=0;a<newPattern.size();a++) {
			System.out.println("i:"+i);
			System.out.println("j:"+j);
			System.out.println("a:"+a);
			if(newPattern.get(a).equals("U")) {
				if(cows[i]<cows[j]) {
					int largest=cows[j];
					int smallest=cows[j];
					boolean bigProblem=true;
					boolean smallProblem=true;
					for(int b=j+1;b<cows.length;b++) {
						if(cows[b]>largest) {
							bigProblem=false;
						}
						if(cows[b]<smallest) {
							smallProblem=false;
						}
					}
					if(bigProblem && (j==newPattern.size() || newPattern.subList(j-1, newPattern.size()).contains("U"))) {
						//System.out.println("problem: "+j);
						j++;
						a--;
						
					}else if(smallProblem && (j==newPattern.size() || newPattern.subList(j-1, newPattern.size()).contains("D"))){
						j++;
						a--;
						
					}else {
						j++;
						i=j-1;
					}
					//find the largest item from cows[j] to end
					//if cows[j] is the largest item and there is at least one up
					//no
					//find the smallest item from cows[j] to end
					//if cows[j] is the smallest item and theere is at least one down
					//no
					
				}else {
					j++;
					a--;
				}
			}else {
				if(cows[i]>cows[j]) {
					int largest=cows[j];
					int smallest=cows[j];
					boolean bigProblem=true;
					boolean smallProblem=true;
					for(int b=j+1;b<cows.length;b++) {
						if(cows[b]>largest) {
							bigProblem=false;
						}
						if(cows[b]<smallest) {
							smallProblem=false;
						}
					}
					if(bigProblem && (j==newPattern.size() || newPattern.subList(j-1, newPattern.size()).contains("U"))) {
						//System.out.println("problem: "+j);
						j++;
						a--;
						
					}else if(smallProblem && (j==newPattern.size() || newPattern.subList(j-1, newPattern.size()).contains("D"))){
						j++;
						a--;
						
					}else {
						j++;
						i=j-1;
					}
				}else {
					j++;
					a--;
				}
			}
			
			if(j>=cows.length) {
				return false;
			}
		}
		return true;
	}
	
	/*
	private static ArrayList<Integer> patternReallyPossible(){
		int i=0;
		boolean finished=false;
		ArrayList<Integer> badIndexes=new ArrayList<>();
		for(int a=0;a<currentPattern.size();a++) {
			if(finished==false && currentPattern.get(a).equals(newPattern.get(i))) {
				i++;
				finished=true;
			}else {
				badIndexes.add(a);
			}
		}
		ArrayList<Integer> realBadIndexes=new ArrayList<>();
		for(int badIndex:badIndexes) {
			int indexToRemoveLeft=badIndex;
			int indexToRemoveRight=badIndex+1;
			String leftCommand="";
			String rightCommand="";
			if(badIndex!=0) {
				leftCommand=currentPattern.get(badIndex-1);
			}
			if(badIndex!=currentPattern.size()-1) {
				rightCommand=currentPattern.get(badIndex+1);
			}
			if(leftCommand.equals("U")) {
				if(rightCommand.equals("U")) {
					if(cows[indexToRemoveLeft-1]<cows[indexToRemoveLeft+1] && cows[indexToRemoveLeft+1]<cows[indexToRemoveLeft+2]) {
						realBadIndexes.add(indexToRemoveLeft);
					}else {
						realBadIndexes.add(indexToRemoveRight);
					}
				}else {
					if(cows[indexToRemoveLeft-1]<cows[indexToRemoveLeft+1] && cows[indexToRemoveLeft+1]>cows[indexToRemoveLeft+2]) {
						realBadIndexes.add(indexToRemoveLeft);
					}else {
						realBadIndexes.add(indexToRemoveRight);
					}
				}
			}else {
				if(rightCommand.equals("U")) {
					if(cows[indexToRemoveLeft-1]>cows[indexToRemoveLeft+1] && cows[indexToRemoveLeft+1]<cows[indexToRemoveLeft+2]) {
						realBadIndexes.add(indexToRemoveLeft);
					}else {
						realBadIndexes.add(indexToRemoveRight);
					}
				}else {
					if(cows[indexToRemoveLeft-1]>cows[indexToRemoveLeft+1] && cows[indexToRemoveLeft+1]>cows[indexToRemoveLeft+2]) {
						realBadIndexes.add(indexToRemoveLeft);
					}else {
						realBadIndexes.add(indexToRemoveRight);
					}
				}
			}
		}
		return realBadIndexes;
		
	}
	*/
	private static boolean patternPossible() {
		int i=0;
		for(String str:currentPattern) {
			if(str.equals(newPattern.get(i))) {
				i++;
				if(i>=newPattern.size()) {
					return true;
				}
			}
		}
		if(i>=newPattern.size()) {
			return true;
		}else {
			return false;
		}
	}

}
