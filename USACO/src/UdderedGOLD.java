import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class UdderedGOLD {
	private static String[] heard;
	
	private static int currentIndex=0;
	
	private static String[] possibleLetters= {"m","i","l","d","r","e","b","s"};
	private static ArrayList<int[]> possibleCowphabets=new ArrayList<>();
	private static ArrayList<Integer> nCowphabets=new ArrayList<>();
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		Random r=new Random();
		String input=s.next();
		heard=input.split("");
		//this solution will work for ALL test cases...but...
		//for test case 8, it will take MORE THAN 4 HOURS TO FINISH
		//for test case 16, it will take MORE THAN 5 HOURS TO FINISH
		//and for test case 2, it will take MORE THAN 8 HOURS TO FINISH
		
		
		
		for(int i=0;i<40320;i++) {
			int[] aa=null;
			while(aa==null || possibleCowphabets.contains(aa)) {
				aa=new int[8];
				int a=r.nextInt(8);
				int b=a;
				while(b==a) {
					b=r.nextInt(8);
				}
				int c=b;
				while(c==b || c==a) {
					c=r.nextInt(8);
				}
				int d=c;
				while(d==c || d==b || d==a) {
					d=r.nextInt(8);
				}
				int e=c;
				while(e==c || e==b || e==a || e==d) {
					e=r.nextInt(8);
				}
				int f=c;
				while(f==c || f==b || f==a || f==d || f==e) {
					f=r.nextInt(8);
				}
				int g=c;
				while(g==c || g==b || g==a || g==d || g==e || g==f) {
					g=r.nextInt(8);
				}
				int h=c;
				while(h==c || h==b || h==a || h==d || h==e || h==f || h==g) {
					h=r.nextInt(8);
				}
				aa[0]=a;
				aa[1]=b;
				aa[2]=c;
				aa[3]=d;
				aa[4]=e;
				aa[5]=f;
				aa[6]=g;
				aa[7]=h;
			}
					
			
			
			possibleCowphabets.add(aa);
			
		}
		int a=0;
		for(int[] cowphabet:possibleCowphabets) {
			/*
			for(int i:cowphabet) {
				System.out.print(i+" ");
			}
			System.out.println();
			*/
			nCowphabets.add(calculateNCowphabets(cowphabet));
			a++;
			if(a%100==0)
			System.out.println("progress: "+Math.round((a/40320.0)*100)/100.0+"%");
		}
		//System.out.println(nCowphabets);
		/*
		for(int a=0;a<8;a++) {
			for(int b=0;b<8;b++) {
				for(int c=0;c<8;c++) {
					for(int d=0;d<8;d++) {
						for(int e=0;e<8;e++) {
							for(int f=0;f<8;f++) {
								for(int g=0;g<8;g++) {
									for(int h=0;h<8;h++) {
										//System.out.println("hello");
										int[] picks= {a,b,c,d,e,f,g,h};
										
										
										for(int i:picks) {
											System.out.print(i+" ");
										}
										System.out.println();
										
										if(isGood(picks)) {
											//System.out.println("hello");
											nCowphabets.add(calculateNCowphabets(picks));
										}
									}
								}
							}
						}
					}
				}
			}
		}
		*/
		int minimum=Integer.MAX_VALUE;
		for(int i:nCowphabets) {
			if(i<minimum) {
				minimum=i;
			}
		}
		System.out.println(minimum);
		//LINEAR LOGIC (WRONG)
		/*
		for(String letter:heard) {
			if(cowphabet.contains(letter)) {
				int letterIndex=cowphabet.indexOf(letter);
				//System.out.println("letter index:"+letterIndex);
				if(currentIndex>letterIndex) {
					nCowphabets++;
					currentIndex=cowphabet.indexOf(letter)+1;
					//System.out.println("new round");
				}else {
					currentIndex=cowphabet.indexOf(letter)+1;
				}
			}else {
				cowphabet.add(letter);
				currentIndex++;
			}
			//System.out.println(cowphabet);
			//System.out.println("current index:"+currentIndex);
		}
		*/
		
		

	}
	public static int calculateNCowphabets(int[] picks) {
		int total=1;
		ArrayList<String> pickedCowphabet=new ArrayList<>();
		for(int i:picks) {
			String letter=possibleLetters[i];
			pickedCowphabet.add(letter);
		}
		for(String letter:heard) {
			if(pickedCowphabet.contains(letter)) {
				int letterIndex=pickedCowphabet.indexOf(letter);
				if(currentIndex>letterIndex) {
					total++;
					currentIndex=pickedCowphabet.indexOf(letter)+1;
					//System.out.println("new round");
				}else {
					currentIndex=pickedCowphabet.indexOf(letter)+1;
				}
			}else {
				currentIndex++;
			}
			
		}
		return total;
	}
	public static boolean isGood(int[] picks) {
		ArrayList<Integer> uniquePicks=new ArrayList<>();
		for(int i:picks) {
			if(uniquePicks.contains(i)) {
				return false;
			}else {
				uniquePicks.add(i);
			}
		}
		return true;
	}

}
