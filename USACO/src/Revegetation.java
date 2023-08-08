import java.util.ArrayList;
import java.util.Scanner;

public class Revegetation {
	private static int mCows;
	private static int nPastures;
	private static ArrayList<ArrayList<Integer>> pairs=new ArrayList<>();
	private static int[] pastures;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		nPastures=s.nextInt();
		mCows=s.nextInt();
		pastures=new int[nPastures];
		for(int i=0;i<mCows;i++) {
			ArrayList<Integer> pair=new ArrayList<>();
			pair.add(s.nextInt());
			pair.add(s.nextInt());
			pairs.add(pair);
		}
		ArrayList<ArrayList<Integer>> sR=new ArrayList<>();
		for(int i=1;i<mCows;i++) {
			ArrayList<Integer> r=new ArrayList<Integer>();
			for(ArrayList<Integer> pair:pairs) {
				if(pair.contains(i)) {
					for(int a:pair) {
						if(a!=i) {
							r.add(a);
						}
					}
				}
			}
			sR.add(r);
		}
		//System.out.println(sR);
		//System.out.println(pastures.length);
		pastures[0]=1;
		
		for(int i=1;i<pastures.length;i++) {
			if(i>=sR.size()) {
				pastures[i]=3;
			}else {
				ArrayList<Integer> restrictions=sR.get(i);
				ArrayList<Integer> cannotEqual=new ArrayList<>();
				for(int a=0;a<restrictions.size();a++) {
					cannotEqual.add(pastures[restrictions.get(a)-1]);
				}
				if(cannotEqual.contains(1)) {
					if(cannotEqual.contains(2)) {
						if(cannotEqual.contains(3)) {
							pastures[i]=4;
						}else {
							pastures[i]=3;
						}
					}else {
						pastures[i]=2;
					}
				}else {
					pastures[i]=1;
				}
			}
			
		
			
		
		}
		for(int i:pastures) {
			System.out.print(i);
		}
		
		

	}

}
