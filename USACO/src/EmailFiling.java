import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EmailFiling {
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int eee=0;eee<t;eee++) {
			int m=s.nextInt();
			int n=s.nextInt();
			int k=s.nextInt();
			ArrayList<Integer> emails=new ArrayList<>();
			for(int i=0;i<n;i++) {
				emails.add(s.nextInt()-1);
			}
			int topFolder=0;
			int bottomFolder=k-1;
			List<Integer> eViewingWindow=new ArrayList<Integer>();
			
			int topEmail=0;
			int bottomEmail=k-1;
			boolean giveUp=false;
			while(emails.size()>0 || !giveUp) {
				eViewingWindow=emails.subList(topEmail, bottomEmail+1);
				boolean foundEmail=false;
				for(int i=0;i<eViewingWindow.size();i++) {
					if(eViewingWindow.get(i)>=topFolder && eViewingWindow.get(i)<=bottomFolder) {
						emails.remove(i+topEmail);
						foundEmail=true;
						
						//System.out.println(emails);
						//System.out.println("DELETED EMAIL "+i+" IN VIEWING WINDOW");
						break;
					}
				}
				if(emails.size()==0) {
					break;
				}
				if(bottomEmail==emails.size()) {
					bottomEmail--;
					if(topEmail!=0) {
						topEmail--;
					}
					
					//System.out.println("SCROLLED UP EMAIL");
				}
				eViewingWindow=emails.subList(topEmail, bottomEmail+1);
				if(!foundEmail) {
					
					if(bottomEmail==emails.size()-1) {
						if(bottomFolder==m-1) {
							giveUp=true;
						}else {
							bottomFolder++;
							topFolder++;
							//System.out.println("SCROLL DOWN FOLDER");
						}
					}else {
						bottomEmail++;
						topEmail++;
						//System.out.println("SCROLL DOWN EMAIL");
					}
				}
			}
			if(giveUp) {
				System.out.println("NO");
			}else {
				System.out.println("YES");
			}
			
		}
	}

}
