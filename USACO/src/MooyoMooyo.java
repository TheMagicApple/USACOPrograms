import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class MooyoMooyo {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[][] board=new int[n][10];
		int max=s.nextInt();
		for(int i=0;i<n;i++) {
			int[] row=new int[10];
			String[] string=s.next().split("");
			for(int k=0;k<10;k++) {
				row[k]=Integer.parseInt(string[k]);
			}
			board[i]=row;
		}
		int[][] oldBoard=new int[n][10];
		for(int i=0;i<board.length;i++) {
			for(int k=0;k<10;k++) {
				oldBoard[i][k]=board[i][k];
			}
		}
		ArrayList<ArrayList<Vector>> groups=dfs(board);
		for(ArrayList<Vector> group:groups) {
			if(group.size()>=max) {
				for(Vector v:group) {
					board[v.x][v.y]=0;
				}
			}
		}
		//grav
		for(int i=board.length-2;i>=0;i--) {
			for(int k=0;k<10;k++) {
				if(board[i][k]!=0) {
					int currentY=i;
					while(currentY<board.length-1 && board[currentY+1][k]==0) {
						//swap
						board[currentY+1][k]=board[currentY][k];
						board[currentY][k]=0;
						currentY++;
						
					}
				}
			}
		}
		
		while(!sameBoard(oldBoard,board)) {

			oldBoard=new int[n][10];
			for(int i=0;i<board.length;i++) {
				for(int k=0;k<10;k++) {
					oldBoard[i][k]=board[i][k];
				}
			}
			groups=dfs(board);
			for(ArrayList<Vector> group:groups) {
				if(group.size()>=max) {
					for(Vector v:group) {
						board[v.x][v.y]=0;
					}
				}
			}
			//grav
			for(int i=board.length-2;i>=0;i--) {
				for(int k=0;k<10;k++) {
					if(board[i][k]!=0) {
						int currentY=i;
						while(currentY<board.length-1 && board[currentY+1][k]==0) {
							//swap
							board[currentY+1][k]=board[currentY][k];
							board[currentY][k]=0;
							currentY++;
							
						}
					}
				}
			}
		}
		for(int i=0;i<board.length;i++) {
			for(int k=0;k<10;k++) {
				System.out.print(board[i][k]);
			}
			System.out.println();
		}

		

	}
	
	public static boolean sameBoard(int[][] board1,int[][] board2) {
		for(int i=0;i<board1.length;i++) {
			for(int k=0;k<10;k++) {
				//System.out.println(board1[i][k]+" "+board2[i][k]);
				if(board1[i][k]!=board2[i][k]) {
					return false;
				}
			}
		}
		return true;
	}
	public static ArrayList<ArrayList<Vector>> dfs(int[][] board) {
		int count=0;
		HashSet<Vector> visited=new HashSet<>();
		ArrayList<ArrayList<Vector>> groups=new ArrayList<>();
		for(int i=0;i<board.length;i++) {
			for(int k=0;k<board[i].length;k++) {
				Vector next=new Vector(i,k);
				
				if(!visited.contains(next)) {
					//-------- DFS -----------
					Stack<Vector> stack=new Stack<>();
					ArrayList<Vector> group=new ArrayList<>();
					stack.push(next); 
					while(!stack.empty()) {
						Vector current=stack.pop();
						
						if(!visited.contains(current)) {
							visited.add(current);
							//System.out.print(current+"  ");
							group.add(current);
						}
						Vector[] neighbors=new Vector[] {new Vector(current.x,current.y+1),new Vector(current.x,current.y-1),new Vector(current.x+1,current.y),new Vector(current.x-1,current.y)};
						for(Vector neighbor:neighbors) { 
							if(neighbor.x>=0 && neighbor.x<board.length && neighbor.y>=0 && neighbor.y<10 && !visited.contains(neighbor) && board[current.x][current.y]==board[neighbor.x][neighbor.y]) {
								stack.push(neighbor); 
							}
							
						}
					}
					// -------------------------
					count++;
					if(board[group.get(0).x][group.get(0).y]!=0) groups.add(group);
					
				}
			
			}
		}
	
		return groups;
	}

}
