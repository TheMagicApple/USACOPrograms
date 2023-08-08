import java.util.Scanner;

public class COWOperations {

	public static void main(String[] args) {
		//success! (watched a tiny bit of a video)
		Scanner s=new Scanner(System.in);
		String string=s.next();
		int q=s.nextInt();
		int[][] queries=new int[q][2];
		for(int i=0;i<q;i++) {
			queries[i]=new int[] {s.nextInt(),s.nextInt()};
		}
		int[][] prefix=new int[string.length()+1][3];
		prefix[0]=new int[] {0,0,0};
		for(int i=0;i<string.length();i++) {
			char c=string.charAt(i);
			if(c=='C') {
				prefix[i+1]=new int[] {prefix[i][0]+1,prefix[i][1],prefix[i][2]};
			}
			if(c=='O') {
				prefix[i+1]=new int[] {prefix[i][0],prefix[i][1]+1,prefix[i][2]};
			}
			if(c=='W') {
				prefix[i+1]=new int[] {prefix[i][0],prefix[i][1],prefix[i][2]+1};
			}
		}
		String answer="";
		for(int[] query:queries) {
			int c=prefix[query[1]][0]-prefix[query[0]-1][0];
			int o=prefix[query[1]][1]-prefix[query[0]-1][1];
			int w=prefix[query[1]][2]-prefix[query[0]-1][2];
			if((c%2==1 && o%2==0 && w%2==0) || (c%2==0 && o%2==1 && w%2==1)) {
				answer+="Y";
			}else {
				answer+="N";
			}
		}
		System.out.println(answer);
	}

}
