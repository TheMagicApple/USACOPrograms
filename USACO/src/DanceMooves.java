import java.util.ArrayList;
import java.util.Scanner;

public class DanceMooves {
	private static int nCows;
	private static int kDanceMooves;
	private static int[][] mooves;
	private static int[] cows;
	private static ArrayList<ArrayList<Integer>> positions;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		nCows=s.nextInt();
		kDanceMooves=s.nextInt();
		mooves=new int[kDanceMooves][2];
		cows=new int[nCows];
		positions=new ArrayList<>();
		for(int i=0;i<kDanceMooves;i++) {
			int[] moove=new int[2];
			moove[0]=s.nextInt();
			moove[1]=s.nextInt();
			mooves[i]=moove;
		}
		for(int i=0;i<cows.length;i++) {
			cows[i]=i+1;
		}
		/*
		for(int[] i:mooves) {
			for(int ii:i) {
				System.out.print(ii+" ");
			}
			System.out.println();
		}
		*/
		for(int i=0;i<cows.length;i++) {
			ArrayList<Integer> a=new ArrayList<>();
			a.add(i+1);
			positions.add(a);
		}
		//System.out.println(positions);
		for(int a=0;a<100;a++) {
			
		
		for(int[] i:mooves) {
			swap(i[0],i[1]);
			//swap2(i[0],i[1]);
			/*
			for(int iii:cows) {
				//System.out.print(iii+" ");
			}
			*/
			//System.out.println();
			addPositions();
			//System.out.println(positions);
		}
		}
		for(ArrayList<Integer> position:positions) {
			System.out.println(position.size());
		}
		//System.out.println(positions);
		

	}
	public static void swap(int a,int b) {
		int temp=cows[a-1];
		cows[a-1]=cows[b-1];
		cows[b-1]=temp;
	}
	public static void swap2(int a,int b) {
		ArrayList<Integer> temp=positions.get(a-1);
		positions.set(a-1, positions.get(b-1));
		positions.set(b-1, temp);
	}
	public static void addPositions() {
		for(int i=0;i<cows.length;i++) {
			int cow=cows[i];
			ArrayList<Integer> a=positions.get(cow-1);
			//int currentPosition=cows[i];
			if(a.contains(i+1)) {
				
			}else {
				a.add(i+1);
			}
			positions.set(cow-1, a);
			
			
			
		}
	}
	

}
