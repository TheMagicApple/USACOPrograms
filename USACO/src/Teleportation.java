import java.util.Scanner;
public class Teleportation {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int a=s.nextInt();
		int b=s.nextInt();
		int teleporter1=s.nextInt();
		int teleporter2=s.nextInt();
		int firstpath=straightShot(a,b);
		int secondpath=firstTeleporter(a,b,teleporter1,teleporter2);
		int thirdpath=secondTeleporter(a,b,teleporter1,teleporter2);
		if(firstpath<secondpath && firstpath<thirdpath) {
			System.out.println(firstpath);
		}else if(secondpath<firstpath && secondpath<thirdpath) {
			System.out.println(secondpath);
		}else if(thirdpath<firstpath && thirdpath<secondpath) {
			System.out.println(thirdpath);
		}
		
		
	}
	static int straightShot(int a,int b) {
		return Math.abs(a-b);
	}
	static int firstTeleporter(int a,int b,int teleporter1,int teleporter2) {
		int distanceToFirstTeleporter=Math.abs(a-teleporter1);
		int distanceToFinish=Math.abs(teleporter2-b);
		return distanceToFirstTeleporter+distanceToFinish;
	}
	static int secondTeleporter(int a,int b,int teleporter1,int teleporter2) {
		int distanceToSecondTeleporter=Math.abs(a-teleporter2);
		int distanceToFinish=Math.abs(teleporter1-b);
		return distanceToSecondTeleporter+distanceToFinish;
	}

}
