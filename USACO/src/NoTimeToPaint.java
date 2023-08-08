import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NoTimeToPaint {
	private static int nSegments;
	private static int qCandidates;
	private static String[] desiredFence;
	private static int[][] candidates;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		nSegments=s.nextInt();
		qCandidates=s.nextInt();
		desiredFence=new String[nSegments];
		candidates=new int[qCandidates][2];
		desiredFence=s.next().split("");
		for(int i=0;i<qCandidates;i++) {
			int[] candidate=new int[2];
			candidate[0]=s.nextInt();
			candidate[1]=s.nextInt();
			candidates[i]=candidate;
		}
		//ArrayList<ArrayList<Integer>> completedCandidates=new ArrayList<>();
		//without cheese...  t2-t4:500 ms   t5:1k ms   t6:3k/3.5k ms   t7+:timeout
		//with cheese...
		for(int[] candidate:candidates) {
			
				
				
					/*
					int cheeseStrokes=completedCandidate.get(2);
					ArrayList<String> subArray=new ArrayList<>();
					for(int i=completedCandidate.get(1);i<desiredFence.length;i++) {
						subArray.add(desiredFence[i]);
					}
					
					for(int i=0;i<(candidate[1]-completedCandidate.get(1));i++){
						boolean foundBad=false;
						char c=subArray.get(0).charAt(0);
						int maxAscii=(int)c;
						//System.out.println("max ascii:"+maxAscii);
						for(int k=1;k<subArray.size();k++) {
							//System.out.println("current ascii:"+(int)subArray.get(k).charAt(0));
							if((int)subArray.get(k).charAt(0)>=maxAscii) {
								foundBad=true;
								break;
							}
							
						}
						if(!foundBad) {
							cheeseStrokes--;
						}
						if(subArray.size()>0) {
							subArray.remove(0);
						}
						
					}
					System.out.println(cheeseStrokes);
					ArrayList<Integer> ccompletedCandidate=new ArrayList<>();
					ccompletedCandidate.add(candidate[0]);
					ccompletedCandidate.add(candidate[1]);
					ccompletedCandidate.add(cheeseStrokes);
					completedCandidates.add(ccompletedCandidate);
					cheesed=true;
					break;
					*/
				
				//}
				
				
		
			
				String[] currentFence=new String[nSegments];
				for(int i=0;i<nSegments;i++) {
					currentFence[i]="0";
				}
				for(int i=candidate[0]-1;i<=candidate[1]-1;i++) {
					currentFence[i]="-";
				}
				int strokes=0;
				String[] perfectFence=new String[nSegments];
				for(int a=0;a<nSegments;a++) {
					perfectFence[a]="-";
				}
				boolean done=false;
				while(!done) {
					
					for(int i=0;i<currentFence.length;i++) {
						if(currentFence[i].equals(desiredFence[i])){
							currentFence[i]="-";
						}
					}
					ArrayList<ArrayList<Integer>> streaks=new ArrayList<>();
					ArrayList<Integer> streak=new ArrayList<>();
					for(int i=0;i<currentFence.length;i++) {
						if(currentFence[i].equals("-")) {
							ArrayList<Integer> thing=new ArrayList<>();
							if(streak.size()>0) {
								thing.add(streak.get(0));
								thing.add(streak.get(streak.size()-1));
								streaks.add(thing);
								streak.clear();
							}
							
						}else {
							streak.add(i);
						}
					}
					streaks.add(streak);
					for(int i=0;i<streaks.size();i++) {
						if(streaks.get(i).size()==0) {
							streaks.remove(i);
						}
					}
					if(candidate[0]==1) {
						//System.out.println(streaks);
					}
					for(ArrayList<Integer> sstreak:streaks) {
						String[] desiredFenceSection=new String[sstreak.get(sstreak.size()-1)-sstreak.get(0)+1];
						int ii=0;
						for(int i=sstreak.get(0);i<=sstreak.get(sstreak.size()-1);i++) {
							desiredFenceSection[ii]=desiredFence[i];
							ii++;
						}
						int minAscii=Integer.MAX_VALUE;
						String minString="";
						for(String ss:desiredFenceSection) {
							char c=ss.charAt(0);
							int ascii=(int)c;
							if(ascii<minAscii) {
								minAscii=ascii;
								minString=ss;
							}
						}
						for(int i=sstreak.get(0);i<=sstreak.get(sstreak.size()-1);i++) {
							currentFence[i]=minString;
						}
						if(Arrays.equals(currentFence, perfectFence)) {
							done=true;
						}else {
							strokes++;
						}
						
					}
					//strokes++;
					/*
					for(String sss:currentFence) {
						System.out.print(sss);
					}
					*/
					//System.out.println();
					if(Arrays.equals(currentFence, perfectFence)) {
						done=true;
					}else {
						
					}
					//System.out.println(streaks);
					
				}
				
				System.out.println(strokes);
				/*
				ArrayList<Integer> completedCandidate=new ArrayList<>();
				completedCandidate.add(candidate[0]);
				completedCandidate.add(candidate[1]);
				completedCandidate.add(strokes);
				completedCandidates.add(completedCandidate);
				*/
			}
			
			
			
			
			
			
			
			
			
		}
		//System.out.println(completedCandidates);
		

	}



