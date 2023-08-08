import java.util.Scanner;

public class RedistributingGifts {
	private static int n;
	private static int cows[][];
	private static int cowGifts[];
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		n=s.nextInt();  //number of cows
		cows=new int[n][n]; //each cow is a list of their gifts ranked (ngifts = ncows)
		cowGifts=new int[n];
		for(int i=0;i<n;i++) {
			int[] cow=new int[n];
			for(int k=0;k<n;k++) {
				cow[k]=s.nextInt()-1;
			}
			cowGifts[i]=i;
			cows[i]=cow;
		}
		//int[] bestGifts=new int[n]; //list to store each cows best gift
		//1. go through each cow
		//2. get the gift the cow currently has
		//3. go through each gift that is better than the current gift (starting from the best)
		//4. get which cow has the better gift
		//5. check if you can swap with the cow(if that cow had your gift, would it be lower than its og gift? if so, you cant swap)
		//6. if you can swap, swap, add the better gift to bestGifts and then move on to next cow
		//7. if you cant swap, continue to the gift that is 1 worse and check that one
		//8. if you get to the gift that is equal to your current gift, then give up, add current gift to bestGifts and move on to the next cow
		for(int i=0;i<cows.length;i++) { //STEP 1
			int currentGift=i; //STEP 2
			thing:
			for(int k=0;k<cows[i].length;k++) { //STEP 3
				
				if(cows[i][k]==i) { //STEP 8
					//DONT CHANGE COWGIFTS[] //STEP 8
					break; //STEP 8
				} 
				//System.out.println("I (cow "+i+") WANT GIFT "+cows[i][k]);
				int swapCowIndex=0;
				int[] swapCow=cows[0];
				for(int a=0;a<cowGifts.length;a++) {
					if(cowGifts[a]==cows[i][k]) {
						swapCow=cows[a];
						swapCowIndex=a;
						//System.out.println("I (cow "+i+") WANT TO SWAP WITH "+a);
					}
				}
				
				for(int a=0;a<swapCow.length;a++) { //STEP 5
					if(swapCow[a]==cowGifts[swapCowIndex]) { //STEP 7
						//System.out.println("I (cow "+i+") CANNOT SWAP BECAUSE IT WOULD HARM THE OTHER COW! THE OTHER COW HAS GIFT "+swapCow[a]+" AT POSITION "+a+" AND BY DEFAULT HAS "+cowGifts[a]);
						break; //STEP 7
					}else { //STEP 5
						if(swapCow[a]==cowGifts[i]) { //STEP 5
							//System.out.println("I (cow "+i+") JUST SWAPPED WITH THE SWAP COW AND RECEIVED GIFT "+cowGifts[a]);
							int temp=cowGifts[i];
							cowGifts[i]=cowGifts[swapCowIndex];
							cowGifts[swapCowIndex]=temp;
							break thing;
						}
						//System.out.println("I (cow "+i+") CAN SWAP BUT DONT WANT TO!");
					}
				}
			
			}
		}
		for(int bestGift:cowGifts) {
			System.out.println(bestGift+1);
		}

	}

}
