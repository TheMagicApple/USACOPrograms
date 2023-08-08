import java.util.Scanner;

public class Uddered {
	private static String alphabet;
	private static String heard;
	private static int x;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		alphabet=s.next();
		heard=s.next();
		x=0;
		int lettersUttered=0;
		int i=0;
		while(i<heard.length()) {
			
			//worst case: each letter in the heard string is an alphabet so go through every single letter (edcba)
			for(int k=0;k<26;k++) {
				//go through each letter in the alphabet
				if(alphabet.charAt(k)==heard.charAt(i)) {
					//System.out.println(i);
					//System.out.println(alphabet.charAt(k));
					
					
					//if the heard letter matches the alphabet letter
					i++;
					//move on to the next heard letter
					if(i==heard.length()) {
					//if you have finished all of the heard letters
						
						break;
						//stop
					}
					
				}
			}
			x++;
			//once you have gone through the entire alphabet, alphebetsheard++ and go through it again with the next heard letters
		}
		System.out.println(x);
	}

}
