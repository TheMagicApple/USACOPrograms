import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SocialDistancing {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int m=s.nextInt();
		int[][] grass=new int[m][2];
		ArrayList<Integer> grassPoints=new ArrayList<>();
		for(int i=0;i<m;i++) {
			int n1=s.nextInt();
			int n2=s.nextInt();
			for(int g=n1;g<=n2;g++) {
				grassPoints.add(g);
			}
			
		}
		ArrayList<ArrayList<Integer>> maxMin=new ArrayList<>();
		int maxMinDistance=0;
		for(int c=0;c<1000000;c++) {
			ArrayList<Integer> cows=new ArrayList<>();
			for(int i=0;i<n;i++) {
				int randomPos=grassPoints.get((int)(Math.random()*grassPoints.size()));
				while(cows.contains(randomPos)) {
					randomPos=grassPoints.get((int)(Math.random()*grassPoints.size()));
				}
				cows.add(randomPos);
				
			}
			Collections.sort(cows);
			int minDistance=100000000;
			for(int i=0;i<cows.size()-1;i++) {
				if(cows.get(i+1)-cows.get(i)<minDistance) {
					minDistance=cows.get(i+1)-cows.get(i);
				}
			}
			if(minDistance>maxMinDistance) {
				maxMinDistance=minDistance;
				maxMin.clear();
				maxMin.add(cows);
			}else if(minDistance==maxMinDistance) {
				if(!maxMin.contains(cows)) {
					maxMin.add(cows);
				}
				
			}
			
			
			
		}
		
		System.out.println(maxMinDistance);
		System.out.println(maxMin);

	}

}
