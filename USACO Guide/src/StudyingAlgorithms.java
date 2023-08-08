//DONE & 1/10
import java.util.Arrays;
import java.util.Scanner;

public class StudyingAlgorithms {
	private static int xMins;
	private static int nAlgs;
	private static int[] algs;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		nAlgs=s.nextInt();
		xMins=s.nextInt();
		algs=new int[nAlgs];
		for(int i=0;i<nAlgs;i++) {
			algs[i]=s.nextInt();
		}
		Arrays.sort(algs);
		int algsLearned=0;
		int time=0;
		while(time<xMins-algs[algsLearned] && algsLearned<algs.length) {
			time+=algs[algsLearned];
			algsLearned++;
		}
		//algsLearned--;
		System.out.println(algsLearned);
	}
}
