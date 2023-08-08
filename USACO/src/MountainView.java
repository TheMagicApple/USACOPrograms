import java.util.ArrayList;
import java.util.Scanner;

public class MountainView {
	private static int[][] mountains;
	private static int nMountains;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		nMountains=s.nextInt();
		mountains=new int[nMountains][2];
		for(int i=0;i<nMountains;i++) {
			mountains[i][0]=s.nextInt();
			mountains[i][1]=s.nextInt();
		}
		ArrayList<ArrayList<ArrayList<Integer>>> mountainKeyPoints=new ArrayList<>();
		for(int[] mountain:mountains) {
			ArrayList<Integer> startPoint=new ArrayList<>();
			startPoint.add(mountain[0]-mountain[1]);
			startPoint.add(0);
			ArrayList<Integer> highPoint=new ArrayList<>();
			highPoint.add(mountain[0]);
			highPoint.add(mountain[1]);
			ArrayList<Integer> endPoint=new ArrayList<>();
			endPoint.add(mountain[0]+mountain[1]);
			endPoint.add(0);
			ArrayList<ArrayList<Integer>> keyPoints=new ArrayList<>();
			keyPoints.add(startPoint);
			keyPoints.add(highPoint);
			keyPoints.add(endPoint);
			mountainKeyPoints.add(keyPoints);
		}
		//System.out.println(mountainKeyPoints);
		ArrayList<Integer> elimMountains=new ArrayList<>();
		for(int i=0;i<mountains.length;i++) {
			thing:
			for(ArrayList<ArrayList<Integer>> keyPoints:mountainKeyPoints) {
				if(keyPoints.get(1).get(0)==mountains[i][0] && keyPoints.get(1).get(1)==mountains[i][1]) {
					//own mountain
				}else {
					if(mountains[i][0]>=keyPoints.get(0).get(0) && mountains[i][0]<=keyPoints.get(2).get(0)) {
						if(mountains[i][0]<=keyPoints.get(1).get(0)) {
							//left of peak
							//System.out.println("Mountain "+i);
							//System.out.println("In between left and peak");
							int x=keyPoints.get(1).get(0);
							int y=keyPoints.get(1).get(1);
							while(y>=0) {
								if(x==mountains[i][0]) {
									if(mountains[i][1]<=y) {
										if(!elimMountains.contains(i)) {
											elimMountains.add(i);
											break thing;
										}
									}
								}
								x--;
								y--;
							}
						}else {
							//right of peak
							//System.out.println("Mountain "+i);
							//System.out.println("In between right and peak");
							int x=keyPoints.get(1).get(0);
							int y=keyPoints.get(1).get(1);
							while(y>=0) {
								
								if(x==mountains[i][0]) {
									if(mountains[i][1]<=y) {
										if(!elimMountains.contains(i)) {
											elimMountains.add(i);
											break thing;
										}
									}
								}
								x++;
								y--;
							}
						}
					}
				}
			}
		}
		System.out.println(nMountains-elimMountains.size());
		
	}
	
	

}
