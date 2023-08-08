import java.util.Scanner;

public class Billboard {

	int lx,ly,ux,uy;
	
	public Billboard(int lx, int ly, int ux,int uy) {
		this.lx = lx;
		this.ly = ly;
		this.ux = ux;
		this.uy = uy;
	}
	
	public int length() {
		return Math.abs(this.lx - this.ux);
	}
	
	public int height() {
		return Math.abs(this.ly-this.uy);
	}
	
	public static int findarea(Billboard b) {
		return b.length()*b.height();
	}
	
	public static Billboard findOverLap(Billboard b1,Billboard b2) {
		
		int x1=Math.max(b1.lx, b2.lx);
		int x2=Math.min(b1.ux, b2.ux);
		int y1=Math.max(b1.ly, b2.ly);
		int y2=Math.min(b1.uy, b2.uy);
		if(x1>x2 || y1>y2) return new Billboard(0,0,0,0);
		return new Billboard(x1,y1,x2,y2);
	}
	
	private static int areaNotCovered(Billboard b1,Billboard b2 ) {
		int area1=findarea(b1);
		Billboard billboardCovered=findOverLap(b1,b2);
		int areaCovered=findarea(billboardCovered);
		
		return area1-areaCovered;
		
	}

	
	public static void main(String args[]) {
		Billboard b1=new Billboard(0,0,0,0);
		Billboard b2=new Billboard(0,0,0,0);
		Billboard b3=new Billboard(0,0,0,0);
		Scanner s=new Scanner(System.in);
		int i1;
		int i2;
		int i3;
		int i4;
		for(int i=0;i<3;i++) {
			i1=s.nextInt();
			i2=s.nextInt();
			i3=s.nextInt();
			i4=s.nextInt();
			if(i==0) b1=new Billboard(i1,i2,i3,i4);
			if(i==1) b2=new Billboard(i1,i2,i3,i4);
			if(i==2) b3=new Billboard(i1,i2,i3,i4);
			
		}
		
		
		
		System.out.println(areaNotCovered(b1,b3) + areaNotCovered(b2,b3));
		

		
	}

	
	
	
}
