import java.util.ArrayList;
import java.util.Scanner;

public class BackAndForth {
	private static ArrayList<Integer> farm1OG=new ArrayList<>();
	private static ArrayList<Integer> farm2OG=new ArrayList<>();
	private static int[][] possibilities=new int[14520][4];
	private static int tank1=1000;
	private static int tank2=1000;
	private static ArrayList<Integer> possibleFirstTanks=new ArrayList<>();
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		for(int i=0;i<10;i++) {
			farm1OG.add(s.nextInt());
		}
		for(int i=0;i<10;i++) {
			farm2OG.add(s.nextInt());
		}
		long startTime=System.currentTimeMillis();
		generatePossibilities();
		
		for(int[] possibility:possibilities) {
			int firstTank=simulate(possibility);
			if(possibleFirstTanks.contains(firstTank)) {
				
			}else {
				possibleFirstTanks.add(firstTank);
			}
		}
		
		System.out.println(possibleFirstTanks.size());
		long endTime=System.currentTimeMillis();
		System.out.println("program took: "+(endTime-startTime));
		
		
		
		
		
		
		
		/*
		for(int i=0;i<10;i++) {
			ArrayList<Integer> farm1=(ArrayList<Integer>) farm1OG.clone();
			ArrayList<Integer> farm2=(ArrayList<Integer>) farm2OG.clone();
			int tempTank1=1000;
			farm2.add(farm1.get(i));
			tempTank1-=farm1.get(i);
			farm1.remove(i);
			
			for(int k=0;k<11;k++) {
				ArrayList<Integer> farm1Save1=(ArrayList<Integer>) farm1.clone();
				ArrayList<Integer> farm2Save1=(ArrayList<Integer>) farm2.clone();
				int tempTank1Save1=tempTank1;
				farm1Save1.add(farm2Save1.get(k));
				tempTank1Save1+=farm2Save1.get(k);
				farm2Save1.remove(k);
				
				for(int j=0;j<10;j++) {
					ArrayList<Integer> farm1Save2=(ArrayList<Integer>) farm1Save1.clone();
					ArrayList<Integer> farm2Save2=(ArrayList<Integer>) farm2Save1.clone();
					int tempTank1Save2=tempTank1Save1;
					farm2Save2.add(farm1Save2.get(j));
					tempTank1Save2-=farm1Save2.get(i);
					farm1Save2.remove(j);
					
					for(int q=0;q<11;q++) {
						ArrayList<Integer> farm1Save3=(ArrayList<Integer>) farm1Save2.clone();
						ArrayList<Integer> farm2Save3=(ArrayList<Integer>) farm2Save2.clone();
						int tempTank1Save3=tempTank1Save2;
						farm1Save3.add(farm2Save3.get(q));
						tempTank1Save3+=farm2Save3.get(q);
						farm2Save3.remove(q);
						
						if(possibleFirstTanks.contains(tempTank1Save3)) {
							
						}else {
							possibleFirstTanks.add(tempTank1Save3);
						}
					}
					
				}
			}
			
		}
		*/
		/*
		for(int[] i:possibilities) {
			for(int ii:i) {
				System.out.print(ii+" ");
			}
			System.out.println();
		}
		*/
		
		

	}
	public static int simulate(int[] possibility) {
		int tank1=1000;
		ArrayList<Integer> farm1=(ArrayList<Integer>) farm1OG.clone();
		ArrayList<Integer> farm2=(ArrayList<Integer>) farm2OG.clone();
		//TUESDAY
		farm2.add(farm1.get(possibility[0]));
		tank1-=farm1.get(possibility[0]);
		farm1.remove(possibility[0]);
		//WEDNESDAY
		farm1.add(farm2.get(possibility[1]));
		tank1+=farm2.get(possibility[1]);
		farm2.remove(possibility[1]);
		//THURSDAY
		farm2.add(farm1.get(possibility[2]));
		tank1-=farm1.get(possibility[2]);
		farm1.remove(possibility[2]);
		//FRIDAY
		farm1.add(farm2.get(possibility[3]));
		tank1+=farm2.get(possibility[3]);
		farm2.remove(possibility[3]);
		return tank1;
	}
	public static void generatePossibilities() {
		int x=0;
		for(int i=0;i<10;i++) {
			for(int j=0;j<11;j++) {
				for(int k=0;k<10;k++) {
					for(int q=0;q<11;q++) {
						int[] possibility=new int[4];
						possibility[0]=i;
						possibility[1]=j;
						possibility[2]=k;
						possibility[3]=q;
						possibilities[x]=possibility;
						x++;
					}
					
				}
			}
		}
	}

}
