//INCOMPLETE
import java.util.Arrays;
import java.util.Scanner;

public class CountingHaybales {
	private static int n;
	private static int[] haybales;
	private static int q;
	private static int queries[][];
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		q=s.nextInt();
		haybales=new int[n];
		queries=new int[q][2];
		for(int i=0;i<n;i++) {
			haybales[i]=s.nextInt();
		}
		for(int i=0;i<q;i++) {
			int[] query=new int[2];
			query[0]=s.nextInt();
			query[1]=s.nextInt();
			queries[i]=query;
		}
		Arrays.sort(haybales);
		for(int[] query:queries) {
			int mid=haybales[haybales.length/2];
			
		}
	}

}
