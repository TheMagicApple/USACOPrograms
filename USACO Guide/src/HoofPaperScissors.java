//DONE & 8/10
import java.util.ArrayList;
import java.util.Scanner;

public class HoofPaperScissors {
	private static int n;
	private static String[] moves;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		moves=new String[n];
		for(int i=0;i<n;i++) {
			moves[i]=s.next();
		}
		int[] prefix1=new int[n+1]; //WIN WITH ROCK
		int[] prefix2=new int[n+1]; //WIN WITH PAPER
		int[] prefix3=new int[n+1]; //WIN WITH SCISSORS
		prefix1[0]=0;
		prefix2[0]=0;
		prefix3[0]=0;
		for(int i=1;i<n+1;i++) {
			if(i==1) {
				prefix1[i]=((moves[i-1].equals("S")) ? 1 : 0);
			}else {
				prefix1[i]=prefix1[i-1]+((moves[i-1].equals("S")) ? 1 : 0);
			}
		}
		for(int i=1;i<n+1;i++) {
			if(i==1) {
				prefix2[i]=((moves[i-1].equals("H")) ? 1 : 0);
			}else {
				prefix2[i]=prefix2[i-1]+((moves[i-1].equals("H")) ? 1 : 0);
			}
		}
		for(int i=1;i<n+1;i++) {
			if(i==1) {
				prefix3[i]=((moves[i-1].equals("P")) ? 1 : 0);
			}else {
				prefix3[i]=prefix3[i-1]+((moves[i-1].equals("P")) ? 1 : 0);
			}
		}
		for(int i:prefix1) {
			//System.out.println(i);
		}
		
		//first, lets say you go rock then paper
		ArrayList<Integer> winners=new ArrayList<>();
		double[] percentages=new double[n];
		for(int i=0;i<n;i++) {
			double percWon=(double)(prefix1[i+1])/(prefix1[n]);
			double percLeft=(double)(prefix2[n]-prefix2[i+1])/(prefix2[n]);
			//percWon*=100;
			//percLeft*=100;
			percentages[i]=percWon+percLeft;
		}
		int maxIndex=1;
		double maxPerc=0;
		for(int i=0;i<n;i++) {
			if(percentages[i]>maxPerc) {
				maxPerc=percentages[i];
				maxIndex=i+1;
			}
		}
		int wonRounds=(prefix1[maxIndex])+(prefix2[n]-prefix2[maxIndex-1]);
		winners.add(wonRounds);
		
		percentages=new double[n];
		for(int i=0;i<n;i++) {
			double percWon=(double)(prefix1[i+1])/(prefix1[n]);
			double percLeft=(double)(prefix3[n]-prefix3[i+1])/(prefix3[n]);
			//percWon*=100;
			//percLeft*=100;
			percentages[i]=percWon+percLeft;
		}
		maxIndex=1;
		 maxPerc=0;
		for(int i=0;i<n;i++) {
			if(percentages[i]>maxPerc) {
				maxPerc=percentages[i];
				maxIndex=i+1;
			}
		}
		wonRounds=(prefix1[maxIndex])+(prefix3[n]-prefix3[maxIndex-1]);
		winners.add(wonRounds);
		
		percentages=new double[n];
		for(int i=0;i<n;i++) {
			double percWon=(double)(prefix2[i+1])/(prefix2[n]);
			double percLeft=(double)(prefix3[n]-prefix3[i+1])/(prefix3[n]);
			//percWon*=100;
			//percLeft*=100;
			percentages[i]=percWon+percLeft;
		}
		maxIndex=1;
		 maxPerc=0;
		for(int i=0;i<n;i++) {
			if(percentages[i]>maxPerc) {
				maxPerc=percentages[i];
				maxIndex=i+1;
			}
		}
		wonRounds=(prefix2[maxIndex])+(prefix3[n]-prefix3[maxIndex-1]);
		winners.add(wonRounds);
		
		percentages=new double[n];
		for(int i=0;i<n;i++) {
			double percWon=(double)(prefix2[i+1])/(prefix2[n]);
			double percLeft=(double)(prefix1[n]-prefix1[i+1])/(prefix1[n]);
			//percWon*=100;
			//percLeft*=100;
			percentages[i]=percWon+percLeft;
		}
		maxIndex=1;
		 maxPerc=0;
		for(int i=0;i<n;i++) {
			if(percentages[i]>maxPerc) {
				maxPerc=percentages[i];
				maxIndex=i+1;
			}
		}
		wonRounds=(prefix2[maxIndex])+(prefix1[n]-prefix1[maxIndex-1]);
		winners.add(wonRounds);
		
		percentages=new double[n];
		for(int i=0;i<n;i++) {
			double percWon=(double)(prefix3[i+1])/(prefix3[n]);
			double percLeft=(double)(prefix1[n]-prefix1[i+1])/(prefix1[n]);
			//percWon*=100;
			//percLeft*=100;
			percentages[i]=percWon+percLeft;
		}
		maxIndex=1;
		 maxPerc=0;
		for(int i=0;i<n;i++) {
			if(percentages[i]>maxPerc) {
				maxPerc=percentages[i];
				maxIndex=i+1;
			}
		}
		wonRounds=(prefix3[maxIndex])+(prefix1[n]-prefix1[maxIndex-1]);
		winners.add(wonRounds);
		
		percentages=new double[n];
		for(int i=0;i<n;i++) {
			double percWon=(double)(prefix3[i+1])/(prefix3[n]);
			double percLeft=(double)(prefix2[n]-prefix2[i+1])/(prefix2[n]);
			//percWon*=100;
			//percLeft*=100;
			percentages[i]=percWon+percLeft;
		}
		maxIndex=1;
		 maxPerc=0;
		for(int i=0;i<n;i++) {
			if(percentages[i]>maxPerc) {
				maxPerc=percentages[i];
				maxIndex=i+1;
			}
		}
		wonRounds=(prefix3[maxIndex])+(prefix2[n]-prefix2[maxIndex-1]);
		winners.add(wonRounds);
		
		int maxWin=0;
		for(int i:winners) {
			if(i>maxWin) {
				maxWin=i;
			}
		}
		System.out.println(maxWin);
		//System.out.println(wonRounds);
		/*
		for(int i=0;i<prefix1.length;i++) {
			System.out.println(prefix1[i]+" "+prefix2[i]+" "+prefix3[i]);
		}
		*/

	}

}
