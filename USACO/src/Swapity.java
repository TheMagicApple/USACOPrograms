import java.util.ArrayList;
import java.util.Scanner;

public class Swapity {
	private static int n;
	private static int k;
	private static int a1;
	private static int a2;
	private static int b1;
	private static int b2;
	private static int[] cows;
	private static int[] ogCows;
	private static ArrayList<int[]> cowCombos=new ArrayList<>();
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		k=s.nextInt();
		a1=s.nextInt();
		a2=s.nextInt();
		b1=s.nextInt();
		b2=s.nextInt();
		cows=new int[n];
		for(int i=0;i<cows.length;i++) {
			cows[i]=i+1;
		}
		ogCows=(int[])cows.clone();
		int counter=0;
		do {
			
			counter+=1;
			reverse(a1,a2);
			
			reverse(b1,b2);
			cowCombos.add(cows.clone());
			
		}while(!repeat());
		
		int[] chosenOne;
		while(k>cowCombos.size()) {
			k-=counter;
		}
		chosenOne=cowCombos.get(k-1);
		/*
		if(k%counter==0) {
			chosenOne=cowCombos.get(counter-1);
		}else {
			chosenOne=cowCombos.get((k%counter)-1);
		}
		*/
		for(int i:chosenOne) {
			System.out.println(i);
		}

	}
	public static void reverse(int a1, int a2) {
		int counter2=0;
		for(int i=a1-1;i<Math.ceil(((double)a2/2.0));i++) {
			counter2++;
			int temp=cows[i];
			cows[i]=cows[a2-counter2];
			cows[a2-counter2]=temp;
					
		}
	}
	public static void reverse2(int b1,int b2) {
		
	}
	public static boolean repeat() {
		for(int i=0;i<cows.length;i++) {
			if(cows[i]!=i+1) {
				return false;
			}
		}
		return true;
	}
	

}
