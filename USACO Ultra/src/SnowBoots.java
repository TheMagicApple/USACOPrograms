import java.util.Scanner;

public class SnowBoots {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int b=s.nextInt();
		int[] snow=new int[n];
		for(int i=0;i<n;i++) {
			snow[i]=s.nextInt();
		}
		Vector[] boots=new Vector[b];
		for(int i=0;i<b;i++) {
			boots[i]=new Vector(s.nextInt(),s.nextInt());
		}
		System.out.println(run(n,b,snow,boots));
	}
	public static int run(int n,int b,int[] snow,Vector[] boots) {
		int currentPosition=0;
		int currentBoot=0;
		int discardedBoots=0;
		while(true) {
			Vector boot=boots[currentBoot];
			boolean teleport=false;
			for(int i=currentPosition+boot.y;i>currentPosition;i--) {
				if(i<snow.length && snow[i]<=boot.x) {
					currentPosition=i;
					if(currentPosition==snow.length-1) {
						return discardedBoots;
					}
					teleport=true;
					break;
				}
			}
			if(!teleport) {
				for(int i=currentBoot+1;i<b;i++) { 
					discardedBoots++;
					if(boots[i].x>=snow[currentPosition]) {
						currentBoot=i;
						break;
					}
				}
			}
		}
	}

}
