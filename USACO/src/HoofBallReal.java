import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class HoofBallReal {
	private static int nCows;
	private static int totalPasses=0;
	private static Scanner s=new Scanner(System.in);
	private static ArrayList<Integer> players;
	private static ArrayList<String> playerPasses;
	private static boolean[] passedTo;
	private static boolean[] hasBall;
	public static void main(String[] args) {
		nCows=10;
		players=new ArrayList<>();
		playerPasses=new ArrayList<>();
		passedTo=new boolean[nCows];
		hasBall=new boolean[nCows];
		for(int i=0;i<nCows;i++) {
			players.add(s.nextInt());
		}
		Collections.sort(players);
		for(int player:players) {
			//System.out.println(player);
		}
		calcPasses();
		for(String player:playerPasses) {
			System.out.println(player);
		}
		initBalls();
		for(boolean pass:passedTo) {
			//System.out.println(pass);
			//System.out.println("HELOO");
		}
		if(done()) {
			//System.out.println(totalPasses);
		}else {
			
			
			extraBalls();
			
			
			
		}
		//System.out.println("extra balls are out");
		for(boolean pass:passedTo) {
			//System.out.println(pass);
		}
		System.out.println(totalPasses);
		
		
	}
	public static void calcPasses() {
		for(int i=0;i<nCows;i++) {
			if(i==0) {
				playerPasses.add("R");
			}else if(i==nCows-1) {
				playerPasses.add("L");
			}else {
				if(Math.abs(players.get(i)-players.get(i-1))<Math.abs(players.get(i)-players.get(i+1))) {
					playerPasses.add("L");
				}else if(Math.abs(players.get(i)-players.get(i-1))>Math.abs(players.get(i)-players.get(i+1))) {
					playerPasses.add("R");
				}else {
					playerPasses.add("L");
				}
				
			}
			
			
		}
	}
	public static void initBalls() {
		passedTo[0]=true;
		passedTo[nCows-1]=true;
		hasBall[0]=true;
		hasBall[nCows-1]=true;
		totalPasses+=2;
		pass();
	}
	public static void extraBalls() {
		while(!done()) {
			System.out.println("FLAG -1");
			for(int i=1;i<nCows-2;i++) {
				
				if(passedTo[i]==false) {
					//System.out.print("no!");
					if(passedTo[i+1]==true && passedTo[i-1]==true) {
						System.out.println("FLAG 0");
						passedTo[i]=true;
						hasBall[i]=true;
						totalPasses+=1;
						//System.out.print("FLAG 2");
						
					}
					if(passedTo[i+1]==false && passedTo[i-1]==true) {
						System.out.println("FLAG 1");
						if(playerPasses.get(i).equals("R")) {
							passedTo[i]=true;
							hasBall[i]=true;
							totalPasses+=1;
							//System.out.print("FLAG 2.");
						}else {
							if(playerPasses.get(i+1).equals("R")) {
								passedTo[i]=true;
								hasBall[i]=true;
								totalPasses+=1;
								System.out.print("FLAG 2");
							}else {
								/*
								passedTo[i]=true;
								hasBall[i]=true;
								totalPasses+=1;
								*/
								//System.out.print("FLAG 4");
							}
						}
					}
					if(passedTo[i+1]==true && passedTo[i-1]==false) {
						System.out.println("FLAG 2");
						if(playerPasses.get(i).equals("L")) {
							passedTo[i]=true;
							hasBall[i]=true;
							totalPasses+=1;
							//System.out.print("FLAG 2");
						}else {
							if(playerPasses.get(i-1).equals("L")) {
								passedTo[i]=true;
								hasBall[i]=true;
								totalPasses+=1;
								//System.out.print("FLAG 2");
							}else {
								
								passedTo[i]=true;
								hasBall[i]=true;
								totalPasses+=1;
								
								//System.out.print("FLAG 5");
							}
						}
						if(passedTo[i+1]==false && passedTo[i-1]==false) {
							System.out.println("FLAG 3");
							if(playerPasses.get(i).equals("L")) {
								if(playerPasses.get(i+1).equals("L")) {
									if(playerPasses.get(i-1).equals("L")) {
										System.out.print("FLAG 1");
									}else {
										System.out.print("FLAG 1");
									}
								}else {
									if(playerPasses.get(i-1).equals("L")) {
										passedTo[i]=true;
										hasBall[i]=true;
										totalPasses+=1;
									}else {
										System.out.print("FLAG 1");
									}
								}
							}else {
								if(playerPasses.get(i+1).equals("R")) {
									if(playerPasses.get(i-1).equals("R")) {
										System.out.print("FLAG 1");
									}else {
										passedTo[i]=true;
										hasBall[i]=true;
										totalPasses+=1;
									}
								}else {
									if(playerPasses.get(i-1).equals("R")) {
										System.out.print("FLAG 1");
									}else {
										passedTo[i]=true;
										hasBall[i]=true;
										totalPasses+=1;
									}
								}
							}
							
							
						}
						pass();
					}
				}
				pass();
				
			}
			 
		}
		
	}
	public static void pass() {
		for(int j=0;j<100;j++){
			for(int i=0;i<nCows;i++) {
				if(hasBall[i]) {
					if(playerPasses.get(i)=="R") {
						hasBall[i]=false;
						hasBall[i+1]=true;
						if(passedTo[i+1]==false) {
							passedTo[i+1]=true;
						}else {
							
						}
					
					}
					if(playerPasses.get(i)=="L") {
						hasBall[i]=false;
						hasBall[i-1]=true;
						if(passedTo[i-1]==false) {
							passedTo[i-1]=true;
						}else {
							
						}
					
					}
					
				}
			}
		}
	}
	public static boolean done(){
		for(boolean b:passedTo) {
			if(b==false) {
				return false;
			}
		}
		return true;
	}

}
