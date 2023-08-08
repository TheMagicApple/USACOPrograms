import java.util.Scanner;
import java.util.ArrayList;
public class Photoshoot {
	private static int nCows;
	private static int[] b;
	private static int[] a;
	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		nCows=s.nextInt();
		b=new int[nCows-1];
		for(int i=0;i<nCows-1;i++) {
			b[i]=s.nextInt();
		}
		long startTime=System.currentTimeMillis();
		a=new int[nCows];
		for(int i=0;i<a.length;i++) {
			a[i]=i+1;
		}
		
		int sum=0;
		for(int i:b) {
			sum+=i;
		}
		int biggerSum=0;
		for(int i:a) {
			biggerSum+=2*i;
		}
		ArrayList<ArrayList<Integer>> pairs=new ArrayList<>();
		int difference=biggerSum-sum;
		for(int i=0;i<a.length-1;i++) {
			for(int k=i+1;k<a.length;k++) {
				if(a[i]+a[k]==difference) {
					ArrayList<Integer> pair=new ArrayList<>();
					pair.add(a[i]);
					pair.add(a[k]);
					pairs.add(pair);
					ArrayList<Integer> pair2=new ArrayList<>();
					pair2.add(a[k]);
					pair2.add(a[i]);
					pairs.add(pair2);
				}
			}
		}
		
		for(ArrayList<Integer> pair:pairs) {
			int[] thing=solve(pair);
			if(thing!=null) {
				for(int i:thing) {
					System.out.print(i+" ");
				}
			}
		}
		long endTime=System.currentTimeMillis();
		System.out.println("Took: "+(endTime-startTime));
		//System.out.println(pairs);

	}
	public static int[] solve(ArrayList<Integer> pair) {
		ArrayList<Integer> numbersLeft=new ArrayList<>();
		int[] solution=new int[b.length+1];
		for(int i:a) {
			if(pair.contains(i)) {
				
			}else {
				numbersLeft.add(i);
			}
		}
		int leftNumber=pair.get(0);
		solution[0]=leftNumber;
		int rightNumber=pair.get(1);
		solution[b.length]=rightNumber;
		for(int i=1;i<b.length;i++) {
			solution[i]=b[i-1]-solution[i-1];
			if(numbersLeft.contains(solution[i])) {
				numbersLeft.remove(numbersLeft.indexOf(solution[i]));
			}else {
				return null;
			}
		}
		return solution;
	}
	public static boolean check(int[] a) {
		for(int i=0;i<a.length-1;i++) {
			if(a[i]+a[i+1]!=b[i]) {
				return false;
			}
		}
		return true;
	}

}
