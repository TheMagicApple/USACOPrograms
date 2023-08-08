import java.util.Scanner;
public class Billboard2 {
	public static int findTarpArea(Billboard mower, Billboard feed) {
		int mowerArea=Billboard.findarea(mower);
		Billboard overlap=Billboard.findOverLap(mower,feed);
		int overlapArea=Billboard.findarea(overlap);
		if(mower.height()==overlap.height()) {
			if(overlap.ux==mower.ux || overlap.lx==mower.lx) {
				return mowerArea-overlapArea;
			}
			
		}
		if(mower.length()==overlap.length()) {
			if(overlap.uy==mower.uy || overlap.ly==mower.ly) {
				return mowerArea-overlapArea;
			}
			
		}
		return mowerArea;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		Billboard mower=new Billboard(s.nextInt(),s.nextInt(),s.nextInt(),s.nextInt());
		Billboard grass=new Billboard(s.nextInt(),s.nextInt(),s.nextInt(),s.nextInt());
		System.out.println(findTarpArea(mower,grass));
		

	}

}
