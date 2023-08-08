import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class CowSteeplechase2 {
	private static int n;
	private static int[][] lines;
	public static void main(String[] args) {
		//System.out.println(Line2D.linesIntersect(2,1,2,6,4,0,4,5));
		Scanner s=new Scanner(System.in);
		
		n=s.nextInt();
		lines=new int[n][4];
		for(int i=0;i<n;i++) {
			int[] line=new int[4];
			for(int k=0;k<4;k++) {
				line[k]=s.nextInt();
			}
			lines[i]=line;	
		}
		int bLine1=0;
		int bLine2=1;
		
	
		
		
		go:
		for(int i=0;i<n;i++) {
			for(int k=0;k<n;k++) {
				if(i!=k) {
					int[] line1=lines[i];
					int[] line2=lines[k];
					if(Line2D.linesIntersect(line1[0], line1[1],line1[2],line1[3],line2[0],line2[1],line2[2],line2[3])){
						bLine1=i;
						bLine2=k;
						break go;
					}
				}
			}
		}
		
		System.out.println(bLine1+1);
		
		
		/*
		lines[bLine1]=null;
		boolean bad=false;
		go:
		for(int i=0;i<n;i++) {
			for(int k=0;k<n;k++) {
				if(i!=k && lines[i]!=null && lines[k]!=null) {
					int[] line1=lines[i];
					int[] line2=lines[k];
					if(Line2D.linesIntersect(line1[0], line1[1],line1[2],line1[3],line2[0],line2[1],line2[2],line2[3])){
						bad=true;
						break go;
					}
				}
			}
		}
		if(bad) {
			System.out.println(bLine2+1);
		}else {
			System.out.println(bLine1+1);
		}
		*/
	}
	

}
