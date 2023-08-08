
public class Dice {

	public static void main(String[] args) {
		int n=10;
		int[] numbers=new int[] {1,2,3,4,5,6};
		long[] sum=new long[n+numbers.length*3];
		sum[0]=1;
		for(int i=0;i<n;i++) {
			for(int number:numbers) {
				sum[i+number]+=sum[i];
			}
		}
		System.out.println(sum[n]);
	}

}
