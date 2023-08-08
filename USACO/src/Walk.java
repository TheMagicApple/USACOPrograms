import java.util.ArrayList;
import java.util.Scanner;

public class Walk {
	private static int nCows;
	private static int kGroups;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		nCows=s.nextInt();
		kGroups=s.nextInt();
		ArrayList<Long> walks=new ArrayList<>();
		for(int i=1;i<=nCows;i++) {
			for(int k=i;k<=nCows;k++) {
				if(i!=k) {
					long distance=(2019201913l*i+2019201949l*k)%2019201997l;
					walks.add(distance);
				}
			}
		}
		
		System.out.println(walks);

	}

}
