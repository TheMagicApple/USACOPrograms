import java.util.ArrayList;
import java.util.Scanner;

public class ComfortableCows {
	private static int n;
	private static int[][] cows;
	private static int[][] map;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		cows=new int[n][2];
		map=new int[1003][1003];
		for(int i=0;i<n;i++) {
			int[] cow=new int[2];
			cow[0]=s.nextInt();
			cow[1]=s.nextInt();
			cows[i]=cow;
		}
		ArrayList<int[]> comfortCows=new ArrayList<>();
		int cowsPlaced=0;
		for(int[] cow:cows) {
			
			int x=cow[0]+1;
			int y=cow[1]+1;
			map[y][x]=1;
			
			if(map[y-1][x]==1) {
				boolean left=map[y-1][x-1]==1;
				boolean right=map[y-1][x+1]==1;
				boolean top=map[y-2][x]==1;
				boolean bottom=map[y][x]==1;
				if((left && right && top && !bottom) || (left && top && bottom && !right) || (left && right && bottom && !top) || (right && top && bottom && !left)) {
					cowsPlaced++;
					comfortCows.add(cow);
				}else {
					if(comfortCows.contains(cow)) {
						comfortCows.remove(cow);
						cowsPlaced--;
						System.out.println("NO COM");
					}
				}
			}
			if(map[y+1][x]==1) {
				boolean left=map[y+1][x-1]==1;
				boolean right=map[y+1][x+1]==1;
				boolean top=map[y][x]==1;
				boolean bottom=map[y+2][x]==1;
				if((left && right && top && !bottom) || (left && top && bottom && !right) || (left && right && bottom && !top) || (right && top && bottom && !left)) {
					cowsPlaced++;
					comfortCows.add(cow);
				}else {
					if(comfortCows.contains(cow)) {
						comfortCows.remove(cow);
						cowsPlaced--;
						System.out.println("NO COM");
					}
				}
			}
			if(map[y][x-1]==1) {
				boolean left=map[y][x-2]==1;
				boolean right=map[y][x]==1;
				boolean top=map[y-1][x-1]==1;
				boolean bottom=map[y+1][x-1]==1;
				if((left && right && top && !bottom) || (left && top && bottom && !right) || (left && right && bottom && !top) || (right && top && bottom && !left)) {
					cowsPlaced++;
					comfortCows.add(cow);
				}else {
					System.out.println("HELLO");
					int[] thing= {map[y][x-1]};
					for(int[] comfortCow:comfortCows) {
						System.out.println(comfortCow[0]+" "+comfortCow[1]);
						if(comfortCow[0]-1==y && comfortCow[1]-1==x-1) {
							comfortCows.remove(cow);
							cowsPlaced--;
							System.out.println("NO COM");
						}
					}
					if(comfortCows.contains(thing)) {
						
					}
				}
			}
			if(map[y][x+1]==1) {
				boolean left=map[y-1][x]==1;
				boolean right=map[y-1][x+2]==1;
				boolean top=map[y-1][x+1]==1;
				boolean bottom=map[y+1][x+1]==1;
				if((left && right && top && !bottom) || (left && top && bottom && !right) || (left && right && bottom && !top) || (right && top && bottom && !left)) {
					cowsPlaced++;
					comfortCows.add(cow);
				}else {
					if(comfortCows.contains(cow)) {
						comfortCows.remove(cow);
						cowsPlaced--;
						System.out.println("NO COM");
					}
				}
			}
			System.out.println(comfortCows);
			System.out.println(cowsPlaced);
			
		}
	}

}
