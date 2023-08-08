import java.util.ArrayList;
import java.util.Scanner;

public class FallingPortals {
	private static int nWorlds;
	private static int[] yCoords;
	private static int[] desiredWorlds;
	private static ArrayList<ArrayList<Double>> teleportations=new ArrayList<>();
	private static ArrayList<String> teleportationTimes=new ArrayList<>();
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		nWorlds=s.nextInt();
		yCoords=new int[nWorlds];
		desiredWorlds=new int[nWorlds];
		for(int i=0;i<nWorlds;i++) {
			yCoords[i]=s.nextInt();
		}
		for(int i=0;i<nWorlds;i++) {
			desiredWorlds[i]=s.nextInt();
		}
		
		for(int a=0;a<nWorlds-1;a++) {
			for(int b=a+1;b<nWorlds;b++) {
				if(yCoords[b]-yCoords[a]>0) {
					ArrayList<Double> teleportation=new ArrayList<>();
					teleportation.add((double)a);
					teleportation.add((double)b);
					teleportation.add((double)(yCoords[b]-yCoords[a])/(b-a));
					teleportations.add(teleportation);
					teleportationTimes.add((yCoords[b]-yCoords[a])+"/"+(b-a));
					//System.out.println("a:"+a);
					//System.out.println("b:"+b);
					if(b-a==0) {
						System.out.println("A AND B ARE THE SAME IDIOT");
					}
				}
				
			}
		}
		//System.out.println(teleportations);
		//go through each cow
		ArrayList<Double> realEnds=new ArrayList<>();
		for(int i=0;i<nWorlds;i++) {
			double desiredWorld=(double)desiredWorlds[i]-1;
			ArrayList<ArrayList<Double>> possibleEnds=new ArrayList<>();
			for(ArrayList<Double> teleportation:teleportations) {
				if(teleportation.get(0)==desiredWorld || teleportation.get(1)==desiredWorld) {
					possibleEnds.add(teleportation);
				}
			}
			//System.out.println(possibleEnds.size());
			
			boolean foundIt=false;
			while(!foundIt) {
				//find tele with lowest time
				//if it is legit, move on and add it to realEnds
				//if it is not, remove it from possibleEnds and run again
				if(possibleEnds.size()==0) {
					realEnds.add(-1.0);
					foundIt=true;
				}else {
					int smallestIndex=-1;
					double smallestTime=Integer.MAX_VALUE;
					for(int j=0;j<possibleEnds.size();j++) {
						if(possibleEnds.get(j).get(2)<smallestTime) {
							smallestTime=possibleEnds.get(j).get(2);
							smallestIndex=j;
						}
					}
					double end=-1;
					if(possibleEnds.get(smallestIndex).get(0)==(double)desiredWorld) {
						end=possibleEnds.get(smallestIndex).get(1);
					}else {
						end=possibleEnds.get(smallestIndex).get(0);
					}
					if(isLegit(end,i,possibleEnds.get(smallestIndex).get(2))) {
						foundIt=true;
						realEnds.add(possibleEnds.get(smallestIndex).get(2));
					}else {
						possibleEnds.remove(smallestIndex);
					}
				}
				
				
			}
			
			/*
			for(int p=0;p<possibleEnds.size();p++) {
				
				boolean foundIt=false;
				while(!foundIt) {
					//find tele with lowest time
					//if it is legit, move on and add it to realEnds
					//if it is not, remove it from possibleEnds and run again
					if(possibleEnds.size()==0) {
						realEnds.add(-1.0);
						foundIt=true;
					}else {
						int smallestIndex=-1;
						double smallestTime=9999999;
						for(int j=0;j<possibleEnds.size();j++) {
							if(possibleEnds.get(j).get(2)<smallestTime) {
								smallestTime=possibleEnds.get(j).get(2);
								smallestIndex=j;
							}
						}
						double end=-1;
						if(possibleEnds.get(smallestIndex).get(0)==(double)desiredWorld) {
							end=possibleEnds.get(smallestIndex).get(1);
						}else {
							end=possibleEnds.get(smallestIndex).get(0);
						}
						if(isLegit(end,i)) {
							foundIt=true;
							realEnds.add(possibleEnds.get(smallestIndex).get(2));
						}else {
							possibleEnds.remove(smallestIndex);
						}
					}
					
					
				}
				
			}
			*/
			//System.out.println("i:"+i);
			//System.out.println(realEnds);
		}
		//System.out.println("tele:"+teleportationTimes);
		//System.out.println(realEnds);
		for(Double end:realEnds) {
			
			if(end==-1) {
				System.out.println("-1");
			}else {
				
				for(String teleportationTime:teleportationTimes) {
					String[] t=teleportationTime.split("");
					double epsilon=0.000001d;
					System.out.println("numerator: "+(double)Integer.parseInt(t[0]));
					System.out.println("denominator: "+(double)Integer.parseInt(t[2]));
					System.out.println("decimal1:"+(double)Integer.parseInt(t[0])/Integer.parseInt(t[2]));
					//System.out.println("decimal2:"+end);
					//System.out.println(Math.abs((double)Integer.parseInt(t[0])/Integer.parseInt(t[2])-(double)(end)));
					if(Math.abs((double)Integer.parseInt(t[0])/Integer.parseInt(t[2])-end)<epsilon) {
						System.out.println(teleportationTime);
						break;
					}
				}
				
				
				//System.out.println(convertDecimalToFraction(end));
			}
			
		}
		//System.out.println(realEnds);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*boolean done=false;
		while(yCoords[0]>-10) {
			for(int a=0;a<nWorlds-1;a++) {
				for(int b=a+1;b<nWorlds;b++) {
					int difference=(yCoords[b]-yCoords[a]);
					if(difference>0) {
						int speedDifference=(b+1)-(a+1);
						//System.out.println("difference:"+difference);
						//System.out.println("speeddifference"+speedDifference);
						if(difference==speedDifference) {
							System.out.println("teleport from world "+a+" to world "+b);
							ArrayList<Integer> teleportation=new ArrayList<>();
							teleportation.add(a);
							teleportation.add(b);
							teleportations.add(teleportation);
						}else if(difference<speedDifference) {
							System.out.println("intermediate teleport from world "+a+" to world "+b);
							ArrayList<Integer> teleportation=new ArrayList<>();
							teleportation.add(a);
							teleportation.add(b);
							teleportations.add(teleportation);
						}
					}
					
				}
			}
			for(int i=0;i<nWorlds;i++) {
				yCoords[i]-=i+1;
			}
			for(int yCoord:yCoords) {
				//System.out.print(yCoord+" ");
			}
			//System.out.println();
			
			
			
		}
		for(int i=0;i<nWorlds;i++) {
			ArrayList<Integer>
		}
		*/
	}
	static private String convertDecimalToFraction(double x){
	    if (x < 0){
	        return "-" + convertDecimalToFraction(-x);
	    }
	    double tolerance = 1.0E-6;
	    double h1=1; double h2=0;
	    double k1=0; double k2=1;
	    double b = x;
	    do {
	        double a = Math.floor(b);
	        double aux = h1; h1 = a*h1+h2; h2 = aux;
	        aux = k1; k1 = a*k1+k2; k2 = aux;
	        b = 1/(b-a);
	    } while (Math.abs(x-h1/k1) > x*tolerance);

	    return h1+"/"+k1;
	}
	public static boolean isLegit(double end,int startingPoint,double time) {
		ArrayList<Double> placesToGo=new ArrayList<>();
		placesToGo.add((double)startingPoint);
		boolean finished=false;
		while(!finished) {
			int numChanges=0;
			for(ArrayList<Double> teleportation:teleportations) {
				if(placesToGo.contains(teleportation.get(0)) && teleportation.get(2)<=time) {
					if(placesToGo.contains(teleportation.get(1))) {
						
					}else {
						placesToGo.add(teleportation.get(1));
						numChanges++;
					}
					
				}else if(placesToGo.contains(teleportation.get(1)) && teleportation.get(2)<=time) {
					if(placesToGo.contains(teleportation.get(0))) {
						
					}else {
						placesToGo.add(teleportation.get(0));
						numChanges++;
					}
				}
			}
			if(numChanges==0) {
				finished=true;
			}
		}
		if(placesToGo.contains(end)) {
			return true;
		}else {
			return false;
		}
		
			
	}

}
