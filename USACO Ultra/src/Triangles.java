import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Triangles {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		
		HashMap<Integer,ArrayList<Vector>> xPoints=new HashMap<>();
		HashMap<Integer,ArrayList<Vector>> yPoints=new HashMap<>();
		for(int i=0;i<n;i++) {
			Vector point=new Vector(s.nextInt(),s.nextInt());
			ArrayList<Vector> x=new ArrayList<>();
			ArrayList<Vector> y=new ArrayList<>();
			if(xPoints.get(point.x)!=null) x=xPoints.get(point.x);
			if(yPoints.get(point.y)!=null) y=yPoints.get(point.y);
			x.add(point);
			y.add(point);
			xPoints.put(point.x, x);
			yPoints.put(point.y, y);
		}
		long startTime=System.currentTimeMillis();
		//System.out.println(yPoints);
		long area=0;
		for(int i=-10000;i<10000;i++) {
			if(xPoints.get(i)!=null && xPoints.get(i).size()>1) {
				//System.out.println("X IS GOOD");
				ArrayList<Vector> x=xPoints.get(i);
				for(Vector point:x) {
					//System.out.println(yPoints);
					//System.out.println(point+" "+yPoints.get(point.y));
					if(yPoints.get(point.y)!=null && yPoints.get(point.y).size()>1) {
						//System.out.println("WE MAKE TRIANGLES");
						ArrayList<Vector> otherX=(ArrayList<Vector>) xPoints.get(point.x).clone();
						ArrayList<Vector> otherY=(ArrayList<Vector>) yPoints.get(point.y).clone();
						otherX.remove(point);
						otherY.remove(point);
						for(Vector xx:otherX) {
							for(Vector yy:otherY) {
								//right triangle: xx, point, yy
								int height=Math.abs(point.y-xx.y);
								int length=Math.abs(point.x-yy.x);
								area+=height*length;
								//System.out.println("TRIANGLE: "+xx+" "+point+" "+yy);
							}
						}
						
					}				
				}
			}
		}
		System.out.println(area%1000000007);
		System.out.println("It took "+(System.currentTimeMillis()-startTime)+"ms");
	}

}
