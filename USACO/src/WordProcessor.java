import java.util.Scanner;

public class WordProcessor {
	private static int nWords;
	private static int nCharacters;
	private static String[] essay;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		nWords=s.nextInt();
		nCharacters=s.nextInt();
		essay=new String[nWords];
		for(int i=0;i<nWords;i++) {
			essay[i]=s.next();
		}
		int charsOnLine=0;
		for(int i=0;i<essay.length;i++) {
			charsOnLine+=essay[i].length();
			if(charsOnLine>nCharacters) {
				System.out.println();
				charsOnLine=essay[i].length();
			}
			System.out.print(essay[i]+" ");
		}
		
		
	}

}
