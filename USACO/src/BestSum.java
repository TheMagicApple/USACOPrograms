import java.util.ArrayList;
public class BestSum {
	private static int[] numbers= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
	private static int target=100000;
	public static void main(String[] args) {
		System.out.println(bestSum());
		//O(n*m^2) time where n is numbers.length and m is target
		//actual time is probably closer to O(n*m^1.5)
		//the basic idea:
		//calculate bestSum(0)...bestSum(n) one at a time
		//the key realization is that bestSum(n+number) is very easy to calculate given bestSum(n)
		//bestSum(1) is easy from bestSum(0), then bestSum(2) is easy from bestSum(1), so on
		//step by step, each thing has to only be calculated once. NO RECURSION. you basically gradually fill in the table with all of the answers to bestSum(0)...bestSum(n)
	}
	public static ArrayList<Integer> bestSum(){ //TABULATION :)
		ArrayList<Integer>[] tab=new ArrayList[target+1]; //create the table that will hold the values of bestSum(0),bestSum(1),bestSum(2),so on until we get to bestSum(n)
		tab[0]=new ArrayList<>(); //IMPORTANT: you need to start off with something otherwise you wont get anywhere. we know bestSum(0) is an empty array, all others are null for now
		for(int i=0;i<tab.length-2;i++) { //calculate bestSum(1)...bestSum(n) with each slot in the table
			if(tab[i]!=null) { //if this spot in the table is null, it is unreachable and therefore should not be considered
				for(int number:numbers) { //go through each number you can possibly add to this number to advance
					if(i+number<tab.length) { //only consider if the advancement would stay in bounds
						ArrayList<Integer> newA=((ArrayList<Integer>) tab[i].clone()); //get the array at the current position
						newA.add(number); //add the number to the array, basically creating a branch and a possible way to get to bestSum(n+number)
						ArrayList<Integer> oldA=tab[i+number]; //get the current array at n+number that we may replace
						if(oldA==null) { //if there is no path to n+number, make this the path
							tab[i+number]=newA;
						}else {
							if(oldA.size()>newA.size()) { //otherwise, only make this the path if it is shorter than the current path at n+number
								tab[i+number]=newA;
							}
						}
					}
				}
			}
		}
		return tab[tab.length-1]; //tab[i] is bestSum(i), therefore tab[tab.length-1] is bestSum(n)
	}

}
