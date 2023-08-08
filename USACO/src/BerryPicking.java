import java.util.Scanner;

public class BerryPicking {
	private static int nTrees;
	private static int kBaskets;
	private static int[] trees;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		nTrees=s.nextInt();
		kBaskets=s.nextInt();
		trees=new int[nTrees];
		for(int i=0;i<nTrees;i++) {
			trees[i]=s.nextInt();
		}
		
	}
}
