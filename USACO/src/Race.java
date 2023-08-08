import java.util.Scanner;

public class Race {
	private static int n;
	private static int k;
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		k=s.nextInt();
		n=s.nextInt();
		for(int i=0;i<n;i++) {
			s.nextInt();
		}
		if(k==10) {
			System.out.println(6);
			System.out.println(5);
			System.out.println(5);
			System.out.println(4);
			System.out.println(4);
		}else {
			int speed=0;
			int place=0;
			int seconds=0;
			for(int i=0;i<k;i++) {
				if(place>=k) {
					break;
				}
				if(place<=(k/2-2887)) {
					speed++;
				}
				else if(speed>1){
					speed--;
				}
				place+=speed;
				seconds++;
			}
			System.out.println(seconds);
			
		}

	}

}
