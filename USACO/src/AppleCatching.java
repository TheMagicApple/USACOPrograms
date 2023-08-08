import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AppleCatching {
	private static int n;
	private static ArrayList<ArrayList<Integer>> apples=new ArrayList<>();
	private static ArrayList<ArrayList<Integer>> cows=new ArrayList<>();
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		for(int i=0;i<n;i++) {
			int choice=s.nextInt();
			if(choice==2) {
				ArrayList<Integer> apple=new ArrayList<>();
				apple.add(s.nextInt());
				apple.add(s.nextInt());
				apple.add(s.nextInt());
				apples.add(apple);
			}else {
				ArrayList<Integer> cow=new ArrayList<>();
				cow.add(s.nextInt());
				cow.add(s.nextInt());
				cow.add(s.nextInt());
				cows.add(cow);
			}
		}
		//2d arraylist shellsort
		for (int interval = apples.size() / 2; interval > 0; interval /= 2) {
		    for (int i = interval; i < apples.size(); i += 1) {
		    ArrayList<Integer> temp = apples.get(i);
		    int j;
		    for (j = i; j >= interval && apples.get(j-interval).get(0) > temp.get(0); j -= interval) {
		      apples.set(j, apples.get(j-interval));
		    }
		    apples.set(j, temp);
		    }
		 }
		for (int interval = cows.size() / 2; interval > 0; interval /= 2) {
		    for (int i = interval; i < cows.size(); i += 1) {
		    ArrayList<Integer> temp = cows.get(i);
		    int j;
		    for (j = i; j >= interval && cows.get(j-interval).get(0) > temp.get(0); j -= interval) {
		      cows.set(j, cows.get(j-interval));
		    }
		    cows.set(j, temp);
		    }
		 }
		
		int time=0;
		int endOfTime=Math.max(cows.get(cows.size()-1).get(0),apples.get(apples.size()-1).get(0));
		int applesCollected=0;
		
		for(int a=0;a<apples.size();a++) {
			int appleX=apples.get(a).get(1);
			int appleTime=apples.get(a).get(0);
			for(int c=0;c<cows.size();c++) {
				int cowTime=cows.get(c).get(0);
				if(cowTime<appleTime) {
					int timeToGetToApple=appleTime-cowTime;
					int cowX=cows.get(c).get(1);
					int distanceToCross=Math.abs(appleX-cowX);
					if(distanceToCross<=timeToGetToApple) {
						int applesCaught=cows.get(c).get(2);
						if(applesCaught>apples.get(a).get(2)) {
							applesCaught=apples.get(a).get(2);
						}
						apples.get(a).set(2, apples.get(a).get(2)-cows.get(c).get(2));
						cows.get(c).set(2, 0);
						if(apples.get(a).get(2)<0) {
							cows.get(c).set(2, -1*apples.get(a).get(2));
							apples.get(a).set(2, 0);
							
						}
						
						applesCollected+=applesCaught;
					}
				}
				
				
				
			}
		}
		/*
		ArrayList<ArrayList<Integer>> cowsOnTheLine=new ArrayList<>();
		ArrayList<ArrayList<Integer>> applesOnTheLine=new ArrayList<>();
		while(time<=endOfTime) {
			for(ArrayList<Integer> cow:cows) {
				if(cow.get(0)==time) {
					cowsOnTheLine.add(cow);
				}
			}
			for(ArrayList<Integer> apple:apples) {
				if(apple.get(0)==time) {
					applesOnTheLine.add(apple);
				}
			}
			for(int k=0;k<applesOnTheLine.size();k++) {
				for(int i=0;i<cowsOnTheLine.size();i++) {
					int xCoord=cowsOnTheLine.get(i).get(1);
					int dropTime=cowsOnTheLine.get(i).get(0);
					int xCoord2=applesOnTheLine.get(k).get(1);
					int dropTime2=applesOnTheLine.get(k).get(0);
					int dXCoord=Math.abs(xCoord2-xCoord);
					int dDropTime=dropTime2-dropTime;
					if(dXCoord>dDropTime) {
						//wont make it in time
					}else {
						//will make it in time
						if(cowsOnTheLine.get(i).get(2)>=applesOnTheLine.get(k).get(2)) {
							//more cows than apples
							applesCollected+=applesOnTheLine.get(k).get(2);
							applesOnTheLine.remove(i);
							cowsOnTheLine.get(i).set(2,cowsOnTheLine.get(i).get(2)-applesOnTheLine.get(k).get(2));
							break;
							
						}else {
							//more apples than cows
							applesCollected+=applesOnTheLine.get(k).get(2)-cowsOnTheLine.get(i).get(2);
							applesOnTheLine.get(i).set(2, applesOnTheLine.get(k).get(2)-cowsOnTheLine.get(i).get(2));
							cowsOnTheLine.remove(i);
						}
						
					}
					
				}
				System.out.println("next set of apples");
			}
			time++;
		}
		*/
		System.out.println(applesCollected);
		
		

	}

}
