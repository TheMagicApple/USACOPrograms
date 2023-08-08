import java.util.Scanner;
public class MooBuzz {
	private static int n;
	private static int numbersSaid=0;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		/*
		for(int i=1;i<=2*n;i++) {
			if(i%3==0 || i%5==0) {
				
			}else {
				numbersSaid++;
			}
			if(numbersSaid==n) {
				System.out.println(i);
				break;
			}
		}
		*/
		int[] efficiency100= {1,2,4,7,8,11,13,14};
		int realN;
		int a;
		if(n>8) {
			a=(int) Math.floor(n/8);
			if(n%8==0) {
				realN=((n+1)%8)+1;
			}else {
				realN=(n%8)-1;
			}
			
		}else{
			realN=n-1;
			a=0;
		}
		System.out.println(efficiency100[realN]+(a*15));
		

	}

}
