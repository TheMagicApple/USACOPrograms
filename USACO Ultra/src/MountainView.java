import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;

public class MountainView {
	public static void main(String[] args) {
		//failed :(
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		double[][] mountains=new double[n][4]; //inx 0 is left coord, 1 and 2 are peak coords, 3 is right coord
		for(int i=0;i<n;i++) {
			int peakX=s.nextInt();
			int peakY=s.nextInt();
			double x=peakY*Math.tan(Math.toRadians(45));
			double leftCoord=peakX-x;
			double rightCoord=peakX+x;
			mountains[i]=new double[] {leftCoord,peakX,peakY,rightCoord};
		}
		Arrays.sort(mountains, new Comparator<double[]>() {
		    public int compare(double[] a, double[] b) {
		        return Double.compare(a[0], b[0]);
		    }
		});
		double[] currentMountain=mountains[0];
		int	visibleMountains=mountains.length;
		for(int i=1;i<mountains.length;i++) {
			double[] mountain=mountains[i];
			if(mountain[3]>currentMountain[3]) { //if this mountains peak is to the right of the rightmost part of the current mountain, there cannot be any other mountains being blocked by the current mountain
				currentMountain=mountain;
			}else {
				visibleMountains--;				
			}
		}
		System.out.println(visibleMountains);	
	}
}
