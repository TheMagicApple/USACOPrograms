import java.util.LinkedList;
import java.util.Scanner;

public class Censoring {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String magazine=s.next();
		String censor=s.next();
		for(int i=0;i<100;i++) {
			magazine=magazine.replaceAll(censor, "");
		}
		
		/*
		LinkedList<Character> letters=new LinkedList<>();
		for(int i=0;i<magazine.length();i++) {
			letters.add(magazine.charAt(i));
		}
		
		for(int i=0;i<letters.size()-censor.length();i++) {
			String substring=magazine.substring(i,i+censor.length());
			if(substring.equals(censor)) {
				magazine=magazine.substring(0,i)+magazine.substring(i+censor.length(),magazine.length());
				i-=censor.length();
				if(i<0) {
					i=0;
				}
			}
		}
		*/
		System.out.println(magazine);
	}

}
