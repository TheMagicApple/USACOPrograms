import java.util.Scanner;

public class MixingMilk {
	private static int bucket1;
	private static int bucket2;
	private static int bucket3;
	private static int capacity1;
	private static int capacity2;
	private static int capacity3;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		capacity1=s.nextInt();
		bucket1=s.nextInt();
		capacity2=s.nextInt();
		bucket2=s.nextInt();
		capacity3=s.nextInt();
		bucket3=s.nextInt();
		int bucketLeaving=1;
		for(int i=0;i<100;i++) {
			int temp=0;
			if(bucketLeaving==1) {
				bucket2+=bucket1;
				bucket1=0;
				if(bucket2>capacity2) {
					int difference=bucket2-capacity2;
					bucket2-=difference;
					bucket1+=difference;
				}
				temp=2;
			}
			if(bucketLeaving==2) {
				bucket3+=bucket2;
				bucket2=0;
				if(bucket3>capacity3) {
					int difference=bucket3-capacity3;
					bucket3-=difference;
					bucket2+=difference;
				}
				temp=3;
				
			}
			if(bucketLeaving==3) {
				bucket1+=bucket3;
				bucket3=0;
				if(bucket1>capacity1) {
					int difference=bucket1-capacity1;
					bucket1-=difference;
					bucket3+=difference;
				}
				temp=1;
			}
			bucketLeaving=temp;
		}
		System.out.println(bucket1);
		System.out.println(bucket2);
		System.out.println(bucket3);
		
	}

}
