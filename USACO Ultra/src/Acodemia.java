import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Acodemia {
	static int n;
	static int k;
	static int l;
	static int[] papers;
	public static void main(String[] args) {
		//success!
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		k=s.nextInt();
		l=s.nextInt();
		papers=new int[n];
		for(int i=0;i<n;i++) {
			papers[i]=s.nextInt();
		}
		Arrays.sort(papers);
		int left=0;
		int right=1000000000;
		int mid=(left+right)/2;
		while(left<right) {
			mid=left+(right-left+1)/2;
			if(hIndex(mid)) {
				left=mid;
			}else {
				right=mid-1;
			}
		}
		int currentIndex=(left+right)/2;
		
	    left=0;
		right=1000000000;
		mid=(left+right)/2;
		while(left<right) {
			mid=left+(right-left+1)/2;
			if(boostIndex(currentIndex,mid)) {
				left=mid;
			}else {
				right=mid-1;
			}
		}
		System.out.println((left+right)/2);
	}
	static boolean boostIndex(int currentIndex,int newIndex) {
		ArrayList<Integer> papersBoosted=new ArrayList<>();
		int counter=0;
		for(int i=papers.length-1;i>=0;i--) {
			if(papers[i]<newIndex) {
				papersBoosted.add(newIndex-papers[i]);
				
			}
			counter++;
			if(counter==newIndex) {
				break;
			}
		}
		Collections.sort(papersBoosted);
		if(papersBoosted.size()==0)return true;
		int maxBoost=papersBoosted.get(papersBoosted.size()-1);
		int sum=0;
		for(int i:papersBoosted) {
			sum+=i;
		}
		if(maxBoost<=k && sum<=l*k) return true;
		return false;
	}
	static boolean hIndex(int index) {
		int counter=0;
		for(int i=papers.length-1;i>=0;i--) {
			if(papers[i]>=index) {
				counter++;
			}else {
				return false;
			}
			if(counter==index) {
				return true;
			}
		}
		return false;
	}
	
	
	

}
