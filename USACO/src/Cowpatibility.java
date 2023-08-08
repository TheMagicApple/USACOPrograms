import java.util.ArrayList;
import java.util.Scanner;

public class Cowpatibility {
	private static int nCows;
	private static ArrayList<ArrayList<Integer>> iceCreamLists;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		nCows=s.nextInt();
		iceCreamLists=new ArrayList<>();
		for(int i=0;i<nCows;i++) {
			ArrayList<Integer> iceCreamList=new ArrayList<>();
			for(int a=0;a<5;a++) {
				iceCreamList.add(s.nextInt());
			}
			iceCreamLists.add(iceCreamList);
		}
		int badPairs=0;
		for(int a=0;a<nCows;a++) {
			for(int b=a+1;b<nCows;b++) {
				
				ArrayList<Integer> iceCreamList=iceCreamLists.get(a);
				ArrayList<Integer> iceCreamList2=iceCreamLists.get(b);
				boolean good=false;
				for(int i:iceCreamList) {
					if(iceCreamList2.contains(i)) {
						good=true;
						break;
					}
				}
				if(!good) {
					badPairs++;
				}
			}
		}
		System.out.println(badPairs);

	}

}
