import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class DiamondCollector {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int k=s.nextInt();
		ArrayList<Integer> diamonds=new ArrayList<>();
		for(int i=0;i<n;i++) {
			diamonds.add(s.nextInt());
		}
		Collections.sort(diamonds);
		int startStreak=0;
		int largestStreak=0;
		for(int i=0;i<diamonds.size();i++) {
			for(int j=i;j<diamonds.size();j++) {
				if(diamonds.get(j)-diamonds.get(i)<=k) {
					
					if((j-i)+1>largestStreak) {
						largestStreak=(j-i)+1;
						startStreak=i;
					}
				}
			}
		}
		for(int i=startStreak;i<startStreak+largestStreak;i++) {
			diamonds.remove(startStreak);
		}
		
		int largestStreak2=0;
		for(int i=0;i<diamonds.size();i++) {
			for(int j=i+1;j<diamonds.size();j++) {
				if(diamonds.get(j)-diamonds.get(i)<k) {
						if((j-i)+1>largestStreak2) {
						
						largestStreak2=(j-i)+1;
					}
				}
			}
		}
		System.out.println(largestStreak+largestStreak2);
		
		
		
		
		
		
		
		
		
		/*
		
		int streak=0;
		int startOfStreak=-1;
		int[] largestStreak=new int[2];
		for(int i=0;i<diamonds.size();i++) {
			if(streak==0) {
				startOfStreak=diamonds.get(i);
			}
			
			if(diamonds.get(i)-startOfStreak>k) {
				if(streak>largestStreak[1]) {
					//System.out.println(i+" "+streak);
					int[] info=new int[2];
					info[0]=i;
					info[1]=streak;
					largestStreak=info;
					
				}
				streak=0;
				
			}
			streak++;
		}
		//System.out.println(largestStreak[0]+" "+largestStreak[1]);
		for(int i=largestStreak[0];i<largestStreak[0]+largestStreak[1];i++) {
			diamonds.remove(largestStreak[0]);
		}
		
		streak=0;
		startOfStreak=-1;
		int[] largestStreak2=new int[2];
		for(int i=0;i<diamonds.size();i++) {
			if(streak==0) {
				startOfStreak=diamonds.get(i);
			}
			streak++;
			if(diamonds.get(i)-startOfStreak>k) {
				if(streak>largestStreak2[1]) {
					int[] info=new int[2];
					info[0]=i;
					info[1]=streak;
					largestStreak2=info;
					
				}
				streak=0;
				
			}
		}
		System.out.println(largestStreak[1]+largestStreak2[1]);
		*/
		
		
		
		
	}

}
