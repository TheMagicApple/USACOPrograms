import java.util.ArrayList;
import java.util.Scanner;
public class MeasurementMilk {
	private static int nMeasurements;
	private static int doesNotMatter;
	private static int changes=0;
	private static int[][] measurements;
	private static ArrayList<Integer> bestOnes=new ArrayList<>();
	private static ArrayList<ArrayList<Integer>> positiveOnes=new ArrayList<>();
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		nMeasurements=s.nextInt();
		doesNotMatter=s.nextInt();
		measurements=new int[nMeasurements][3];
		for(int i=0;i<nMeasurements;i++) {
			measurements[i][0]=s.nextInt();
			measurements[i][1]=s.nextInt();
			measurements[i][2]=s.nextInt();
		}
		java.util.Arrays.sort(measurements, new java.util.Comparator<int[]>() {
		    public int compare(int[] a, int[] b) {
		        return Integer.compare(a[0], b[0]);
		    }
		});
		int highestMilk=0;
		
		for(int[] measurement:measurements) {
			boolean foundIt=false;
			for(int i=0;i<positiveOnes.size();i++) {
				if(positiveOnes.get(i).get(1)<=0) {
					positiveOnes.remove(i);
				}else {
					
				
				
				
				if(positiveOnes.get(i).get(0)==measurement[1] && foundIt==false) {
					positiveOnes.get(i).set(1, positiveOnes.get(i).get(1)+measurement[2]);
					
					foundIt=true;
					ArrayList<Integer> bestOnesBefore=(ArrayList<Integer>) bestOnes.clone();
					changeBestOnes();
					if(bestOnesBefore.equals(bestOnes)) {
						
					}else {
						changes++;
					}
				}
				}
			}
			
			if(!foundIt) {
				if(measurement[2]>0) {
					
					
					if(!foundIt){
						ArrayList<Integer> a=new ArrayList<>();
						a.add(measurement[1]);
						a.add(measurement[2]);
						positiveOnes.add(a);
					}
					ArrayList<Integer> bestOnesBefore=(ArrayList<Integer>) bestOnes.clone();
					changeBestOnes();
					if(bestOnesBefore.equals(bestOnes)) {
						
					}else {
						changes++;
					}
					
					
				}else if(positiveOnes.size()==0) {
					changes++;
				}
			}
			
		}
		//System.out.println(positiveOnes);
		System.out.println(changes);
		
		
		

	}
	public static void changeBestOnes() {
		bestOnes.clear();
		int highest=0;
		for(ArrayList<Integer> a:positiveOnes) {
			if(a.get(1)>highest) {
				highest=a.get(1);
			}
		}
		for(ArrayList<Integer> a:positiveOnes) {
			if(a.get(1)==highest) {
				bestOnes.add(a.get(0));
			}
		}
	}

}
