import java.util.ArrayList;

public class Knapsack {
	private static int[][] items;
	public static void main(String[] args) {
		//given a list of items with weights and profits, find the maximum profit with weight<=c where each item can only be used once
		int[] item1= {3,3};
		int[] item2= {5,4};
		int[] item3= {3,7};
		int[] item4= {5,5};
		int[] item5= {1,2};
		items=new int[2][2];
		items[0]=item1;
		items[1]=item2;
		//items[2]=item3;
		//items[3]=item4;
		//items[4]=item5;
		int maxWeight=15;
		int max=dp(0,maxWeight);
		System.out.println(max);

	}
	//number of ways to get to the max weight
	private static int dp(int weight,int goal) {
		if(weight==goal) {
			return 1;
		}else if(weight>=goal) {
			return 0;
		}
		int n=0;
		for(int[] item:items) {
			n+=dp(weight+item[0],goal);
		}
		return 1+n;
	}

}
