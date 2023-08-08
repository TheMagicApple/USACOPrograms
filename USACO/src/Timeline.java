import java.util.Scanner;

public class Timeline {
	private static int nSessions;
	private static int mDays;
	private static int cMemories;
	private static int[] minDays;
	private static int[][] memories;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		nSessions=s.nextInt();
		mDays=s.nextInt();
		cMemories=s.nextInt();
		minDays=new int[nSessions];
		for(int i=0;i<minDays.length;i++) {
			minDays[i]=s.nextInt();
		}
		memories=new int[cMemories][3];
		for(int i=0;i<cMemories;i++) {
			int[] memory=new int[3];
			memory[0]=s.nextInt();
			memory[1]=s.nextInt();
			memory[2]=s.nextInt();
			memories[i]=memory;
		}
		for(int[] memory:memories) {	
			if(minDays[memory[1]-1]-minDays[memory[0]-1]<memory[2]){
				minDays[memory[1]-1]+=(memory[2]-(minDays[memory[1]-1]-minDays[memory[0]-1]));
			}
			
			
		}
		for(int minDay:minDays) {
			System.out.println(minDay);
		}
		

	}
	
	

}
