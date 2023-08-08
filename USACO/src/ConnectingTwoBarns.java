import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConnectingTwoBarns {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int tt=0;tt<t;tt++) {
			int n=s.nextInt();
			int m=s.nextInt();
			Map<Integer,Integer> roads=new HashMap<>();
			for(int i=0;i<m;i++) {
				int point1=s.nextInt()-1;
				int point2=s.nextInt()-1;
				if(point1>point2) {
					int temp=point1;
					point1=point2;
					point2=temp;
				}
				roads.put(point1,point2);
				
				
				
				/*
				for(int a=0;a<n;a++) {
					if(roads.get(a)!=null && roads.get(a)==point1) {
						point1=a;
					}
				}
				/*
				if(roads.get(point2)!=null) {
					point2=roads.get(point2);
				}
				
				if(roads.get(point1)!=null) {
					int oldRoad=roads.get(point1);
					int newRoad=point2;
					if(newRoad>oldRoad) {
						roads.replace(point1, newRoad);
					}
				}else {
					roads.put(point1,point2);
				}
				*/
				
				
			}
			
			ArrayList<Integer> places=new ArrayList<>();
			for(int i=0;i<n;i++) {
				if(roads.get(i)!=null) {
					places.add(i);
					i=roads.get(i);
				}else {
					places.add(i);
				}
			}
			System.out.println(places);
			
			
			/*
			int counter=0;
			int startRoad=100000000;
			int endRoad=100000000;
			for(int i=0;i<n-1;i++) {
				if(roads.get(i)==null && (i<startRoad || i>endRoad)) {
					counter++;
					System.out.println(i+" IS A BLACK");
				}else if(roads.get(i)!=null){
					startRoad=i;
					endRoad=roads.get(i);
					counter++;
				}
			}
			counter++;
			System.out.println(counter);
			
			*/
			
			
			
			/*
			int startPosition=0;
			if(roads.get(0)!=null) {
				startPosition=roads.get(0);
			}
			int endPosition=n-1;
			
			for(int i=n-1;i>-1;i--) {
				if(roads.get(i)!=null && roads.get(i)==endPosition) {
					endPosition=i;
				}
			}
			
			//System.out.println(roads);
			ArrayList<Integer> costs=new ArrayList<>();
			//System.out.println((startPosition+1)+" "+(endPosition-1));
			
			for(int i=startPosition+1;i<=endPosition;i++) { //????????????
				int costRoad1=(i-startPosition)*(i-startPosition);
				int iReal=i;
				if(iReal>=endPosition-1) {
					
				}else {
					while(roads.get(iReal)!=null) {
						iReal=roads.get(iReal);
						//System.out.println("HELLO");
					}
				}
				
				int costRoad2=(endPosition-iReal)*(endPosition-iReal);
				costs.add(costRoad1+costRoad2);
			}
			Collections.sort(costs);
			System.out.println(costs.get(0));
			*/
		}
	}

}
