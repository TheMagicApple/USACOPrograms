import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Meetings {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int l=s.nextInt();
		ArrayList<int[]> cows=new ArrayList<>();
		
		int totalSum=0;
		for(int i=0;i<n;i++) {
			int weight=s.nextInt();
			int x=s.nextInt();
			int velocity=s.nextInt();
			cows.add(new int[] {x,weight,velocity});
			totalSum+=cows.get(i)[1];
		}
		cows.sort(new Comparator<int[]>() {
		    public int compare(int[] a, int[] b) {
		        return Double.compare(a[0], b[0]);
		    }
		});
		ArrayList<int[][]> collisions=new ArrayList<>();
		for(int i=0;i<cows.size()-1;i++) {
			if(cows.get(i)[2]==1 && cows.get(i+1)[2]==-1) {
				collisions.add(new int[][] {cows.get(i),cows.get(i+1)});
			}
		}
		/*
		cows.get(0)[0]=5;
		
		for(int[][] collision:collisions) {
			System.out.println("Cow1: "+collision[0][0]+" "+collision[0][1]+" "+collision[0][2]);
			System.out.println("Cow2: "+collision[1][0]+" "+collision[1][1]+" "+collision[1][2]);
		}
		*/
		
		int sum=0;
		int meetings=0;
		int time=0;
		ArrayList<int[]> timedUpdates=new ArrayList<>();
		System.out.println(collisions);
		while(sum<totalSum/2) {
			/*
			if(collisions.size()==0) {
				timedUpdates.sort(new Comparator<int[]>() {
		    public int compare(int[] a, int[] b) {
		        return Double.compare(a[0], b[0]);
		    }
		});
		*/
			//System.out.println("RUN");
			if(collisions.size()==0) {
				System.out.println("SIZE )");
				break;
			}
			//break;
				
			
			int[][] minCollision=collisions.get(0);
			int minDistance=1000000000;
			for(int[][] collision:collisions) {
				System.out.print(collision[0][0]+" "+collision[1][0]+" - ");
				int distance=collision[1][0]-collision[0][0];
				if(distance<minDistance) {
					minDistance=distance;
					minCollision=collision;
				}
			}
			System.out.println();
			//System.out.println(minCollision);
			int timeToCollision=0;
			if(minDistance%2==1) {
				timeToCollision=(minDistance+1)/2;
			}else {
				timeToCollision=(minDistance)/2;
			}
			for(int i=0;i<cows.size();i++) {
				int[] cow=cows.get(i);
				if(cow[0]==minCollision[0][0]) {
					System.out.println("collision between: "+cow[0]+" "+cow[1]+" "+cow[2]+" and "+cows.get(i+1)[0]+" "+cows.get(i+1)[1]+" "+cows.get(i+1)[2]);
					
					meetings++;
					cow[2]=-1;
					cows.get(i+1)[2]=1;
					collisions.remove(minCollision);
					//System.out.println(collisions);
					System.out.println(minDistance);
					/*
					for(int c=0;c<collisions.size();c++) {
						int[][] collision=collisions.get(c);
						if(collision[0][0]==minCollision[0][0] && collision[1][0]==minCollision[1][0]) {
							collisions.remove(c);
							break;
						}
					}
					*/
					if(minDistance%2==1) {
						cow[0]=cow[0]+((minDistance+1)/2-1);
						cow[0]-=1000000;
						cows.get(i+1)[0]-=((minDistance+1)/2-1);
						System.out.println("MOVED "+cow[0]+" "+cows.get(i+1)[0]);
					}else {
						cow[0]=cow[0]+(minDistance)/2;
						cows.get(i+1)[0]-=(minDistance)/2;
					}
					time+=timeToCollision;
					//System.out.println(time);
					for(int j=0;j<timedUpdates.size();j++) {
						if(timedUpdates.get(j)[0]<=time) {
							sum+=timedUpdates.get(j)[1];
							//System.out.println(sum);
							timedUpdates.remove(j);
							j--;
						}
					}
					boolean foundMatchRight=false;
					for(int a=i+2;a<cows.size();a++) {
						if(cows.get(a)[2]==-1) {
							foundMatchRight=true;
							System.out.println("FOUND MATCH BETWEEN "+cows.get(i+1)[0]+" "+cows.get(a)[0]);
							collisions.add(new int[][] {cows.get(i+1),cows.get(a)});
							break;
						}
					}
					boolean foundMatchLeft=false;
					for(int a=i-1;a>=0;a--) {
						if(cows.get(a)[2]==1) {
							foundMatchLeft=true;
							System.out.println("FOUND MATCH BETWEEN "+cows.get(i)[0]+" "+cows.get(a)[0]);
							collisions.add(new int[][] {cows.get(i),cows.get(a)});
							break;
						}
					}
					if(foundMatchRight && foundMatchLeft) {
						for(int[] cowToUpdate:cows) {
							if(cowToUpdate[0]!=cow[0] && cowToUpdate[0]!=cows.get(i+1)[0]) {
								cowToUpdate[0]+=timeToCollision*cowToUpdate[2];
							}
						}
					}else {
						if(!foundMatchLeft) {
							int timeToEnd=cows.get(i)[0];
							timedUpdates.add(new int[] {timeToEnd,cow[1]});
						}
						if(!foundMatchRight) {
							int timeToEnd=l-cows.get(i+1)[0];
							timedUpdates.add(new int[] {timeToEnd,cows.get(i+1)[1]});
						}
					}
					break;
				}
				
			}
		}
		System.out.println(meetings);
		

	}

}
