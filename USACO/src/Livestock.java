import java.util.ArrayList;
import java.util.Scanner;

public class Livestock {
	private static int nConstraints;
	private static ArrayList<String> constraints=new ArrayList<>();
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		nConstraints=s.nextInt(); //between 1 and 7
		s.nextLine();
		for(int i=0;i<nConstraints;i++) {
			
			constraints.add(s.nextLine());
			
		}
		ArrayList<Integer> cows=new ArrayList<>();
		cows.add(4);
		cows.add(7);
		cows.add(2);
		cows.add(1);
		cows.add(3);
		cows.add(6);
		cows.add(5);
		cows.add(8);
		ArrayList<ArrayList<Integer>> pairs=new ArrayList<>();
		for(String constraint:constraints) {
			ArrayList<Integer> pair=new ArrayList<>();
			String[] words=constraint.split(" ");
			if(words[0].equals("Bessie") || words[5].equals("Bessie")) {
				pair.add(4);
			}
			if(words[0].equals("Buttercup") || words[5].equals("Buttercup")) {
				pair.add(7);
			}
			if(words[0].equals("Belinda") || words[5].equals("Belinda")) {
				pair.add(2);
			}
			if(words[0].equals("Beatrice") || words[5].equals("Beatrice")) {
				pair.add(1);
			}
			if(words[0].equals("Bella") || words[5].equals("Bella")) {
				pair.add(3);
			}
			if(words[0].equals("Blue") || words[5].equals("Blue")) {
				pair.add(6);
			}
			if(words[0].equals("Betsy") || words[5].equals("Betsy")) {
				pair.add(5);
			}
			if(words[0].equals("Sue") || words[5].equals("Sue")) {
				pair.add(8);
			}
			pairs.add(pair);
		}
		ArrayList<ArrayList<Integer>> groupings=new ArrayList<>();
		int beatrices=0;
		for(ArrayList<Integer> pair:pairs) {
			if(pair.contains(1)) {
				beatrices++;
			}
		}
		ArrayList<Integer> alphaOrder=new ArrayList<>();
		if(beatrices==0) {
			alphaOrder.add(1);
			cows.remove(new Integer(1));
		}else if(beatrices==1) {
			alphaOrder.add(1);
			cows.remove(new Integer(1));
			for(ArrayList<Integer> pair:pairs) {
				if(pair.contains(1)) {
					for(int i:pair) {
						if(i!=1) {
							alphaOrder.add(i);
							cows.remove(new Integer(i));
						}
					}
					pairs.set(pairs.indexOf(pair), null);
				}
			}
		}else {
			int betterOne=Integer.MAX_VALUE;
			int worseOne=Integer.MAX_VALUE;
			for(ArrayList<Integer> pair:pairs) {
				if(pair.contains(1)) {
					for(int i:pair) {
						if(i!=1) {
							if(i<betterOne) {
								worseOne=betterOne;
								betterOne=i;
							}else {
								worseOne=i;
							}
						}
					}
					pairs.set(pairs.indexOf(pair), null);
				}
			}
			alphaOrder.add(betterOne);
			alphaOrder.add(1);
			alphaOrder.add(worseOne);
			cows.remove(new Integer(betterOne));
			cows.remove(new Integer(1));
			cows.remove(new Integer(worseOne));
		}
		
		
		//System.out.println("constraints: "+pairs);
		while(alphaOrder.size()<8) {
			//System.out.println("current order: "+alphaOrder);
			boolean foundPair=false;
			int things=0;
			int lastItem=alphaOrder.get(alphaOrder.size()-1);
			for(ArrayList<Integer> pair:pairs) {
				if(pair!=null) {
					if(pair.contains(lastItem)) {
						things++;
						
						foundPair=true;
					}
				}
			}
			boolean done=false;
			if(things==1) {
				
				for(ArrayList<Integer> pair:pairs) {
					lastItem=alphaOrder.get(alphaOrder.size()-1);
					if(pair!=null) {
						if(pair.contains(new Integer(lastItem))) {
							for(int i:pair) {
								if(i!=lastItem) {
									//System.out.println("last item:"+lastItem);
									//System.out.println("adding "+i);
									alphaOrder.add(i);
									cows.remove(new Integer(i));
									done=true;
									break;
								}
							}
						}
						
					}
					
					
					pairs.set(pairs.indexOf(pair), null);
					//System.out.println("last item:"+lastItem);
					//System.out.println("set pair to null from things=1");
					//System.out.println("current order: "+alphaOrder);
					//System.out.println("pairs:"+pairs);
					if(done) {
						break;
					}
				}
			}
			if(things==2) {
				
				int betterOne=Integer.MAX_VALUE;
				int worseOne=Integer.MAX_VALUE;
				for(ArrayList<Integer> pair:pairs) {
					if(pair!=null) {
						if(pair.contains(lastItem)) {
							
							for(int i:pair) {
								if(i!=lastItem) {
									if(i<betterOne) {
										worseOne=betterOne;
										betterOne=i;
									}else {
										worseOne=i;
									}
								}
							}
							pairs.set(pairs.indexOf(pair), null);
							//System.out.println("last item:"+lastItem);
							//System.out.println("set pair to null from things=2");
						}
					}
					
				}
				if(alphaOrder.contains(betterOne)) {
					
				}else {
					alphaOrder.remove(alphaOrder.size()-1);
					alphaOrder.add(betterOne);
					
				}
				
				alphaOrder.add(lastItem);
				alphaOrder.add(worseOne);
				cows.remove(new Integer(betterOne));
				cows.remove(new Integer(lastItem));
				cows.remove(new Integer(worseOne));
			}
			if(!foundPair) {
				int smallest=Integer.MAX_VALUE;
				for(int cow:cows) {
					int things2=0;
					for(ArrayList<Integer> pair:pairs) {
						if(pair!=null) {
							if(pair.contains(cow)) {
								things2++;
							}
						
						}
					}
					if(cow==3) {
						//System.out.println(things2);
					}
					
					if(cow<smallest && things2<2) {
						smallest=cow;
					}
				}
				//System.out.println("smallest:"+smallest);
				alphaOrder.add(smallest);
				cows.remove(new Integer(smallest));
			}
			//System.out.println("constraints: "+pairs);
		}
		//System.out.println(alphaOrder);
		
		for(int i:alphaOrder) {
			if(i==1) {
				System.out.println("Beatrice");
			}else if(i==2) {
				System.out.println("Belinda");
			}else if(i==3) {
				System.out.println("Bella");
			}else if(i==4) {
				System.out.println("Bessie");
			}else if(i==5) {
				System.out.println("Betsy");
			}else if(i==6) {
				System.out.println("Blue");
			}else if(i==7) {
				System.out.println("Buttercup");
			}else {
				System.out.println("Sue");
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		int lowestCowLeft=Integer.MAX_VALUE;
		for(int i:cows) {
			if(i<lowestCowLeft) {
				lowestCowLeft=i;
			}
		}
		
		int lowsLeft=0;
		for(ArrayList<Integer> pair:pairs) {
			if(pair.contains(1)) {
				lowsLeft++;
			}
		}
		if(lowsLeft==0) {
			alphaOrder.add(lowestCowLeft);
			cows.remove(new Integer(lowestCowLeft));
		}else if(lowsLeft==1) {
			alphaOrder.add(lowestCowLeft);
			cows.remove(new Integer(lowestCowLeft));
			for(ArrayList<Integer> pair:pairs) {
				if(pair.contains(lowestCowLeft)) {
					for(int i:pair) {
						if(i!=lowestCowLeft) {
							alphaOrder.add(i);
							cows.remove(new Integer(i));
						}
					}
				}
			}
		}else {
			int betterOne=Integer.MAX_VALUE;
			int worseOne=Integer.MAX_VALUE;
			for(ArrayList<Integer> pair:pairs) {
				if(pair.contains(lowestCowLeft)) {
					for(int i:pair) {
						if(i!=lowestCowLeft) {
							if(i<betterOne) {
								worseOne=betterOne;
								betterOne=i;
							}else {
								worseOne=i;
							}
						}
					}
				}
			}
			int lastCow=alphaOrder.get(alphaOrder.size()-1);
			
			alphaOrder.add(betterOne);
			alphaOrder.add(lowestCowLeft);
			alphaOrder.add(worseOne);
			cows.remove(new Integer(betterOne));
			cows.remove(new Integer(lowestCowLeft));
			cows.remove(new Integer(worseOne));
		}
		*/
		//System.out.println("current order: "+alphaOrder);
		//System.out.println("cows left: "+cows);
	}
	

}
