import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Triangles {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[][] points=new int[n][2];
		Map<Integer,ArrayList<Integer>> x=new HashMap<>();
		Map<Integer,ArrayList<Integer>> y=new HashMap<>();
		for(int i=0;i<n;i++) {
			int[] point=new int[2];
			point[0]=s.nextInt();
			point[1]=s.nextInt();
			points[i]=point;
			if(x.get(point[0])==null) {
				ArrayList<Integer> otherY=new ArrayList<>();
				otherY.add(point[1]);
				x.put(point[0], otherY);
			}else {
				x.get(point[0]).add(point[1]);
			}
			if(y.get(point[1])==null) {
				ArrayList<Integer> otherX=new ArrayList<>();
				otherX.add(point[0]);
				y.put(point[1], otherX);
			}else {
				y.get(point[1]).add(point[0]);
			}
		}
		float area=0;
		
		for(int[] point:points) {
			ArrayList<Integer> otherX=y.get(point[1]);
			ArrayList<Integer> otherY=x.get(point[0]);
			for(int xx:otherX) {
				for(int yy:otherY) {
					area+=0.5f*Math.abs(yy-point[1])*Math.abs(xx-point[0]);
					area=area%1000000007;
				}
			}
		}
		System.out.println((int)(2*area)%1000000007);
		
		

	}

}
