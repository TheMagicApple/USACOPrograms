import java.util.ArrayList;
import java.util.Scanner;

public class Whereami {
	private static int n;
	private static String road;
	private static int k;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		road=s.next();
		
		for(int i=1;i<=n;i++) {
			k=i;
			if(unique()) {
				System.out.println(k);
				break;
			}
		}
		
	}
	public static boolean unique() {
		ArrayList<String> mailboxes=new ArrayList<>();
		for(int i=0;i<road.length()-k+1;i++) {
			mailboxes.add(road.substring(i,i+k));
		}
		for(String mailbox:mailboxes) {
			if(mailboxes.indexOf(mailbox)!=mailboxes.lastIndexOf(mailbox)) {
				return false;
			}
		}
		return true;
	}

}
