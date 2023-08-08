import java.util.ArrayList;
import java.util.Random;
public class Tester3000 {
	
	/* tips to overcome functional fixedness
	 * 1. break down the problem into the most basic elements. What are you really trying to do?
	 * 2. look for inspiration online
	 * 3. come up with as many solutions as possible
	 * 4. come back to it later?
	 * 5. just see the cow
	 */
	
	static final int TESTCASES=10;
	static final int BOUND=10;
	public static void main(String[] args) {
		Random r=new Random();
		for(int t=0;t<TESTCASES;t++) {
			// --------- "INPUT" -----------
			int l=r.nextInt(BOUND-1)+1;
			int n=r.nextInt(BOUND-1)+1;
			int farmerSpeed=r.nextInt(BOUND-1)+1;
			int bessieSpeed=r.nextInt(BOUND-1)+1;
			while(bessieSpeed>farmerSpeed) {
				bessieSpeed=r.nextInt(BOUND-1)+1;
			}
			ArrayList<Vector> cows=new ArrayList<>();
			for(int i=0;i<n;i++) {
				cows.add(new Vector(r.nextInt(BOUND-1)+1,r.nextInt(BOUND-1)+1));
			}
			// ----------------------------
			// --------- "OUTPUT" ----------
			System.out.println("---- INPUT ----");
			System.out.print(l+" ");
			System.out.print(n+" ");
			System.out.print(farmerSpeed+" ");
			System.out.println(bessieSpeed);
			System.out.println(cows);
			
			System.out.println();
			System.out.println("-----------------");
			System.out.println("--- OUTPUT ---");
			System.out.println("Maybe Solution: "+RestStops.run(l, n, farmerSpeed,bessieSpeed,cows));
			System.out.println("-----------------");
			System.out.println();
			// ----------------------------
		}
	}
}