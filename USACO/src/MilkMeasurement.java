import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
public class MilkMeasurement {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int numberOfDays=s.nextInt();
		int timesChanged=0;
		int mildredmilk=7;
		int elsiemilk=7;
		int bessiemilk=7;
		String currentLeader="Mildred Elsie Bessie";
		//alternative: currentLeader=0b111 (binary)(each cow is either on the leaderboard (1) or off (0))
		ArrayList<Integer> days=new ArrayList<>();
		ArrayList<String> names=new ArrayList<>();
		ArrayList<Integer> changes=new ArrayList<>();
		for(int i=0;i<numberOfDays;i++) {
			days.add(i,s.nextInt());
			names.add(i,s.next());
			changes.add(i,s.nextInt());
		}
		for(int i=0;i<days.size();i++) {
			for(int j=0;j<days.size()-1;j++) {
				if(days.get(j)>days.get(j+1)) {
					int temp=days.get(j);
					days.set(j, days.get(j+1));
					days.set(j+1,temp);
					String temp2=names.get(j);
					names.set(j, names.get(j+1));
					names.set(j+1,temp2);
					int temp3=changes.get(j);
					changes.set(j, changes.get(j+1));
					changes.set(j+1,temp3);
				}
			}
		}
		int change=0;
		for(int i=0;i<days.get(days.size()-1)+1;i++) {
			if(days.get(change)==i) {
				
				if(names.get(change).equals("Mildred")) {
					mildredmilk+=changes.get(change);
				}
				if(names.get(change).equals("Elsie")) {
					elsiemilk+=changes.get(change);
				}
				if(names.get(change).equals("Bessie")) {
					bessiemilk+=changes.get(change);
				}
				change+=1;
			}
			if(mildredmilk==elsiemilk && mildredmilk==bessiemilk && bessiemilk==elsiemilk) {
				if(currentLeader!="Mildred Elsie Bessie") {
					timesChanged++;
				}
				currentLeader="Mildred Elsie Bessie";
			}
			if(mildredmilk==elsiemilk && mildredmilk>bessiemilk) {
				if(currentLeader!="Mildred Elsie") {
					timesChanged++;
				}
				currentLeader="Mildred Elsie";
			}
			if(elsiemilk==bessiemilk && elsiemilk>mildredmilk) {
				if(currentLeader!="Elsie Bessie") {
					timesChanged++;
				}
				currentLeader="Elsie Bessie";
			}
			if(mildredmilk==bessiemilk && bessiemilk>elsiemilk) {
				if(currentLeader!="Mildred Bessie") {
					timesChanged++;
				}
				currentLeader="Mildred Bessie";
			}
			if(mildredmilk>bessiemilk && mildredmilk>elsiemilk) {
				if(currentLeader!="Mildred") {
					timesChanged++;
				}
				currentLeader="Mildred";
			}
			if(bessiemilk>mildredmilk && bessiemilk>elsiemilk) {
				if(currentLeader!="Bessie") {
					timesChanged++;
				}
				currentLeader="Bessie";
			}
			if(elsiemilk>bessiemilk && elsiemilk>mildredmilk) {
				if(currentLeader!="Elsie") {
					timesChanged++;
				}
				currentLeader="Elsie";
			}
			
		}
		
		System.out.println(timesChanged);
		
	}

}
