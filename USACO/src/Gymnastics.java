import java.util.ArrayList;
import java.util.Scanner;

public class Gymnastics {
	private static int k;
	private static int n;
	private static ArrayList<ArrayList<Integer>> practices=new ArrayList<>();
	private static ArrayList<ArrayList<Integer>> pairs=new ArrayList<>();
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		k=s.nextInt();
		n=s.nextInt();
		
		for(int i=0;i<k;i++) {
			ArrayList<Integer> practice=new ArrayList<>();
			for(int a=0;a<n;a++) {
				practice.add(s.nextInt());
			}
			practices.add(practice);
		}
		ArrayList<Integer> practice1=practices.get(0);
		for(int i=0;i<practice1.size()-1;i++) {
			for(int j=i+1;j<practice1.size();j++) {
				ArrayList<Integer> pair=new ArrayList<>();
				pair.add(practice1.get(i));
				pair.add(practice1.get(j));
				pairs.add(pair);
			}
		}
		//System.out.println(pairs);
		for(int i=1;i<practices.size();i++) {
			//System.out.println("i:"+i);
			int a=pairs.size();
			ArrayList<Integer> bad=new ArrayList<>();
			for(k=0;k<pairs.size();k++) {
				if(pairs.get(k)!=null) {
					int higher=pairs.get(k).get(0);
					int lower=pairs.get(k).get(1);
					if(goodIndexOf(i,higher)<goodIndexOf(i,lower)) {
						//System.out.println("higher:"+goodIndexOf(i,higher));
						//System.out.println("lower:"+goodIndexOf(i,lower));
					}else {
						//System.out.println(pairs.get(k));
						bad.add(k);
						
					}
				}
				
			}
			//System.out.println(bad);
			for(int iii:bad) {
				pairs.set(iii,null);
			}
		}
		//System.out.println(pairs);
		int counter=0;
		for(ArrayList<Integer> pair:pairs) {
			if(pair!=null) {
				counter++;
			}
		}
		System.out.println(counter);
		

	}
	public static int goodIndexOf(int i,int a) {
		ArrayList<Integer> aa=practices.get(i);
		for(int ii=0;i<aa.size();ii++) {
			if(aa.get(ii)==a) {
				return ii;
			}
		}
		return -1;
	}

}
