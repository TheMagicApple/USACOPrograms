import java.util.Scanner;

public class Fence {
	private static int n;
	private static String[] fences;
	private static String[] clocks;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		fences=new String[n];
		clocks=new String[n];
		for(int i=0;i<n;i++) {
			fences[i]=s.next();
		}
		for(int i=0;i<fences.length;i++) {
			clocks[i]=clock(fences[i]);
		}
		for(String clock:clocks) {
			System.out.println(clock);
		}
		
	}
	public static String clock(String fence) {
		char startingLetter=fence.charAt(0);
		char secondLetter=' ';
		for(int i=1;i<fence.length();i++) {
			if(fence.charAt(i)!=startingLetter) {
				secondLetter=fence.charAt(i);
				break;
			}
		}
		if(startingLetter=='W' && secondLetter=='S') {
			return "CCW";
		}else if(startingLetter=='W' && secondLetter=='N') {
			return "CW";
		}else if(startingLetter=='E' && secondLetter=='S') {
			return "CW";
		}else if(startingLetter=='E' && secondLetter=='N') {
			return "CCW";
		}else if(startingLetter=='S' && secondLetter=='W') {
			return "CW";
		}else if(startingLetter=='S' && secondLetter=='E') {
			return "CCW";
		}else if(startingLetter=='N' && secondLetter=='W') {
			return "CCW";
		}else if(startingLetter=='N' && secondLetter=='E') {
			return "CW";
		}else {
			return "something went wrong";
		}
		
		
	}

}
