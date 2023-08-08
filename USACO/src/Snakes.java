import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Snakes {
	private static int n;
	private static int k;
	private static int[] groups;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		k=s.nextInt();
		groups=new int[n];
		for(int i=0;i<n;i++) {
			groups[i]=s.nextInt();
		}
		ArrayList<Integer> groupDifferences=new ArrayList<>();
		
		for(int i=0;i<groups.length-1;i++) {
			groupDifferences.add(Math.abs(groups[i+1]-groups[i]));
			
		}
		
		
		Collections.sort(groupDifferences);
		for(int i=0;i<k;i++) {
			groupDifferences.remove(groupDifferences.size()-1);
		}
		int sum=0;
		for(int i:groupDifferences) {
			sum+=i;
		}
		System.out.println(sum);
		
			
		

	}

}
