import java.util.Scanner;

public class ShellGame {
	private static Scanner s=new Scanner(System.in);
	private static int nSwaps;
	private static int[] shells1= {1,2,3};
	private static int[] shells2= {1,2,3};
	private static int[] shells3= {1,2,3};
	private static int[][] a;
	public static void main(String[] args) {
		nSwaps=s.nextInt();
		a=new int[nSwaps][3];
		for(int i=0;i<nSwaps;i++) {
			a[i][0]=s.nextInt();
			a[i][1]=s.nextInt();
			a[i][2]=s.nextInt();
		}
		/*
		a[0][0]=1;
		a[0][1]=2;
		a[0][2]=1;
		a[1][0]=3;
		a[1][1]=2;
		a[1][2]=1;
		a[2][0]=1;
		a[2][1]=3;
		a[2][2]=1;
		*/
		int one=goodShellONE();
		int two=goodShellTWO();
		int three=goodShellTHREE();
		if(one>two) {
			if(one>three) {
				System.out.println(one);
			}else {
				System.out.println(three);
			}
		}
		else if(one>three) {
			if(one>two) {
				System.out.println(one);
			}else {
				System.out.println(two);
			}
		}
		else if(two>one){
			if(two>three) {
				System.out.println(two);
			}else {
				System.out.println(three);
			}
		}
		else if(two>three){
			if(two>one) {
				System.out.println(two);
			}else {
				System.out.println(one);
			}
		}
		else if(three>one){
			if(three>two) {
				System.out.println(three);
			}else {
				System.out.println(two);
			}
		}
		else if(three>two){
			if(three>one) {
				System.out.println(three);
			}else {
				System.out.println(one);
			}
		}
		
		
		

	}
	public static void swap(int a,int b,int c) {
		if(c==1) {
			int temp=shells1[a];
			shells1[a]=shells1[b];
			shells1[b]=temp;
		}
		if(c==2) {
			int temp=shells2[a];
			shells2[a]=shells2[b];
			shells2[b]=temp;
		}
		if(c==3) {
			int temp=shells3[a];
			shells3[a]=shells3[b];
			shells3[b]=temp;
		}
		
	}
	public static int goodShellONE() {
		int[][] temp=a;
		int points=0;
		int goodShell=1;
		for(int i=0;i<nSwaps;i++) {
			swap(temp[i][0]-1,temp[i][1]-1,1);
			if(shells1[temp[i][2]-1]==goodShell) {
				points++;
			}
		}
		return points;
	}
	public static int goodShellTWO() {
		int[][] temp=a;
		int points=0;
		int goodShell=2;
		for(int i=0;i<nSwaps;i++) {
			//System.out.println(temp[i][0]-1);
			//System.out.println(temp[i][1]-1);
			swap(temp[i][0]-1,temp[i][1]-1,2);
			for(int a:temp[i]) {
				//System.out.println(a);
			}
			//System.out.println("was it a winner?" +shells[temp[i][2]-1]);
			if(shells2[temp[i][2]-1]==goodShell) {
				points++;
			}
		}
		return points;
	}
	public static int goodShellTHREE() {
		int[][] temp=a;
		int points=0;
		int goodShell=3;
		for(int i=0;i<nSwaps;i++) {
			//System.out.println(temp[i][0]-1);
			//System.out.println(temp[i][1]-1);
			swap(temp[i][0]-1,temp[i][1]-1,3);
			for(int j:shells3) {
				//System.out.println("v:"+j);
			}
			if(shells3[temp[i][2]-1]==goodShell) {
				//System.out.println("i:"+i);
				points++;
			}
		}
		return points;
	}
	

}
