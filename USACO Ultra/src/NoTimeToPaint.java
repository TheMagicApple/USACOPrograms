import java.util.Scanner;
public class NoTimeToPaint {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int q=s.nextInt();
		String art=s.next();
		int[][] queries=new int[q][2];
		for(int i=0;i<q;i++) {
			queries[i]=new int[] {s.nextInt(),s.nextInt()};
		}
		for(int[] query:queries) {
			System.out.println(calculate(art.substring(0,query[0]-1))+calculate(art.substring(query[1])));
		}

	}
	static int calculate(String art) {
		int[] streaks=new int[26];
		for(int a=0;a<streaks.length;a++) {
			streaks[a]=-1;
		}
		char previousChar='?';
		int strokes=0;
		for(int i=0;i<art.length();i++) {
			char c=art.charAt(i);
			if(streaks[c-65]==-1) {
				streaks[c-65]=0;
			}
			if(c!=previousChar) {
				if(c>previousChar) {
					strokes++;
				}else {
					if(streaks[c-65]==0 || streaks[c-65]==-1) {
						strokes++;
					}
				}
			}
			previousChar=c;
			for(int a=0;a<streaks.length;a++) {
				if(streaks[a]!=-1) {
					if(a+65<=c) {
						streaks[a]++;
					}else {
						streaks[a]=-1;
					}
				}
				
			}
		}
		return strokes;
	}
}