import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class PairedUp {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		SortedSet<CowCow> cows=new TreeSet<>();
		for(int i=0;i<n;i++) {
			cows.add(new CowCow(s.nextInt(),s.nextInt()));
		}
		
		int maxTime=0;
		while(cows.size()>0) {
			CowCow pair1=cows.first();
			CowCow pair2=cows.last();
			int time=pair1.milk+pair2.milk;
			if(time>maxTime) {
				maxTime=time;
			}
			if(pair1.n>pair2.n) {
				pair1.n-=pair2.n;
				cows.remove(pair2);
			}else if(pair2.n>pair1.n) {
				pair2.n-=pair1.n;
				cows.remove(pair1);
			}else {
				cows.remove(pair1);
				cows.remove(pair2);
			}
			if(cows.size()==1) {
				int lastTime=cows.first().milk*2;
				if(lastTime>maxTime) {
					maxTime=lastTime;
				}
			}
		}
		System.out.println(maxTime);
		
	}
}
class CowCow implements Comparable<CowCow>{
	public int n;
	public int milk;
	public CowCow(int n,int milk) {
		this.n=n;
		this.milk=milk;
	}
	@Override
	public int compareTo(CowCow o) {
		return milk-o.milk;
	}
	@Override
	public String toString() {
		return n+" "+milk;
	}
}