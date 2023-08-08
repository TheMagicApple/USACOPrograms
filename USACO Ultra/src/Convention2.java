import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Convention2 {

	public static void main(String[] args) {
		//2/9 (close)?????
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		Cow[] cows=new Cow[n];
		for(int i=0;i<n;i++) {
			Cow cow=new Cow(s.nextInt(),s.nextInt(),i,-1);
			cows[i]=cow;
		}
		long startTime=System.currentTimeMillis();
		Arrays.sort(cows, new Comparator<Cow>() {
		    public int compare(Cow a, Cow b) {
		        return Integer.compare(a.startTime,b.startTime);
		    }
		});
		for(int i=0;i<n;i++) {
			cows[i].index=i;
		}
		SortedSet<Cow> line=new TreeSet<>();
		line.add(cows[0]); //earlybird gets the worm!
		Cow currentGrazer=cows[0];
		int time=cows[0].startTime;
		int maxWaitingTime=0;
		HashSet<Cow> cowsGone=new HashSet<>();
		while(true) {
			//System.out.println(currentGrazer);
			int waitingTime=time-currentGrazer.startTime;
			if(waitingTime>maxWaitingTime) {
				maxWaitingTime=waitingTime;
			}
			time+=currentGrazer.grazingTime;
			
			line.remove(currentGrazer);
			cowsGone.add(currentGrazer);
			
			for(int i=0;i<cows.length;i++) {
				if(cows[i].startTime<=time) {
					if(!cowsGone.contains(cows[i]))
					line.add(cows[i]);
				}else {
					break;
				}
			}
			
			//System.out.println(line);
			if(cowsGone.size()==cows.length) {
				break;
			}
			if(line.size()==0) {
				//currentGrazer=cows[currentGrazer.index+1];
				Cow nextCow=cows[currentGrazer.index+1];
				line.add(nextCow);
				for(int i=currentGrazer.index+1;i<cows.length;i++) {
					if(cows[i].startTime==nextCow.startTime) {
						line.add(cows[i]);
					}
				}
				currentGrazer=line.first();
				time=currentGrazer.startTime;
			}else
			currentGrazer=line.first();
			
		}
		System.out.println(maxWaitingTime);
		long endTime=System.currentTimeMillis();
		System.out.println(endTime-startTime);
	}
}
class Cow implements Comparable<Cow>{
	public int startTime;
	public int grazingTime;
	public int seniority;
	public int index;
	public Cow(int startTime,int grazingTime,int seniority,int index) {
		this.startTime=startTime;
		this.grazingTime=grazingTime;
		this.seniority=seniority;
		this.index=index;
	}
	@Override
	public int compareTo(Cow other) {
		return Integer.compare(seniority, other.seniority);
	}
	@Override
	public String toString() {
		return startTime+" "+grazingTime+" "+seniority;
	}
	@Override
	public int hashCode() {
		return seniority;
	}
	@Override
	public boolean equals(Object other) {
		return other.hashCode()==hashCode();
	}
}
