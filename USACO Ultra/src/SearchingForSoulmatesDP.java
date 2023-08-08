import java.util.Scanner;

public class SearchingForSoulmatesDP {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int start=s.nextInt();
		int end=s.nextInt();
		int[] visited=new int[100000];
		int operations=0;
		for(int i=0;i<100000;i++) {
			int random=(int)(Math.random()*100000);
			if(visited[random]!=0) {
				int operation1=random+1;
				int operation2=random*2;
				int operation3=random/2;
				operations++;
				if(random<visited.length-1) {
					if(visited[operation1]==0) {
						visited[operation1]=operations;
					}
				}
				if(random*2<visited.length-1) {
					if(visited[operation2]==0) {
						visited[operation2]=operations;
					}
				}
				if(random%2==0) {
					if(visited[operation3]==0) {
						visited[operation3]=operations;
					}
				}
			}
			
		}
		
		for(int i=0;i<50;i++) {
			System.out.println(visited[i]);
		}

	}

}
