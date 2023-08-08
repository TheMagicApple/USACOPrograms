import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class CowHomework {
	private static int nScores;
	private static ArrayList<Integer> scores;
	private static double highestAverage=-1;
	private static ArrayList<Integer> bestKs=new ArrayList<>();
	private static int bestK=0;
	private static double[][] averages;
	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		nScores=s.nextInt();
		//scores=new int[nScores];
		
		scores=new ArrayList<>();
		for(int i=0;i<nScores;i++) {
			//scores[i]=s.nextInt();
			
			scores.add(s.nextInt());
			
			
		}
		ArrayList<Integer> yesKs=new ArrayList<>();
		int smallest=scores.get(scores.size()-1);
		int total=scores.get(scores.size()-1);;
		for(int i=nScores-2;i>=1;i--) {
			total+=scores.get(i);
			//System.out.println("total:"+total);
			if(scores.get(i)<smallest) {
				smallest=scores.get(i);
			}
			
			//System.out.println("average:"+((total-smallest)/(scores.size()-1-i)));
			double average=((double)total-smallest)/(scores.size()-1-i);
			if(average>highestAverage) {
				highestAverage=average;
				yesKs.clear();
				yesKs.add(i);
			}else if(average==highestAverage){
				yesKs.add(i);
			}
			
		}
		Collections.sort(yesKs);
		for(int i:yesKs) {
			System.out.println(i);
		}
			
		/*
		for(int i=1;i<scores.size()-2;i++) {
			double a=findAverageReal(i);
			//System.out.println(a);
			if(a>highestAverage) {
				bestKs.clear();
				bestKs.add(i);
				highestAverage=a;
			}else if(a==highestAverage) {
				bestKs.add(i);
			}
			//System.out.println("i:"+i);
			//System.out.println(scores.size());
		}
		for(int i:bestKs) {
			System.out.println(i);
		}
		*/
		
		/*
		averages=new double[nScores-2][2];
		for(int i=1;i<nScores-2;i++) {
			averages[i-1][0]=i;
			averages[i-1][1]=findAverage(i);
		}
		
		/*
		for(int a:averages) {
			System.out.println(a);
		}
		*/
		/*
		double maximum=averages[0][1];
		for(double[] a:averages) {
			if(a[1]>maximum) {
				maximum=a[1];
			}
		}
		ArrayList<Integer> best=new ArrayList<>();
		for(double[] a:averages) {
			if(a[1]==maximum) {
				best.add((int)a[0]);
			}
		}
		Collections.sort(best);
		for(int b:best) {
			System.out.println(b);
		}
		*/
		/* New idea...
		 * Create new ordered list to see all of the biggest
		 * Check:
		 * Last 2 have 1 biggest
		 * Last 3 have 2 biggest
		 * Last 4 have 3 biggest
		 * So on...
		 * If any are met then best k is total-last #
		 * 
		 */
		
		
		
		

	}
	public static double findAverageReal(int k) {
		ArrayList<Integer> newScores=new ArrayList<>();
		for(int i=k;i<scores.size();i++) {
			newScores.add(scores.get(i));
		}
		Collections.sort(newScores);
		newScores.remove(0);
		double average=0;
		for(int i:newScores) {
			average+=i;
		}
		average=average/newScores.size();
		return average;
	}
	/*
	public static double findAverage(int k) {
		
		int[] newScores=new int[nScores-k];
		for(int i=k;i<nScores;i++) {
			newScores[i-k]=scores[i];
		}
		
		
		/*
		for(int score:newScores) {
			System.out.println("s:"+score);
		}
		*/
		/*
		int minimum=newScores[0];
		for(int score:newScores) {
			if(score<minimum) {
				minimum=score;
			}
		}
		
		
		//System.out.println("m:"+minimum);
		
		boolean removedScore=false;
		int[] realScores=new int[newScores.length-1];
		int j=0;
		for(int i=0;i<realScores.length;i++) {
			if(newScores[i]==minimum && removedScore==false) {
				removedScore=true;
				j--;
			}else {
				realScores[j]=newScores[i];
			}
			j++;
		}
		
		/*
		for(int score:realScores) {
			System.out.println("r:"+score);
		}
		*/
		/*
		double average=0;
		for(int score:realScores) {
			average+=score;
		}
		average=average/(double)(realScores.length);
		
		
		return average;
	}
	*/

}
