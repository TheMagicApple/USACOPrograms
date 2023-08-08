import java.util.ArrayList;
import java.util.Scanner;

public class CowFrisbee {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		/*
		int[] cows=new int[n];
		for(int i=0;i<n;i++) {
			cows[i]=s.nextInt();
		}
		*/
		for(int test=0;test<10;test++) {
			int[] cows=generateRandom(n);
			int sum=0;
			for(int i=0;i<n;i++) {
				for(int k=i+1;k<n;k++) {
					if(k-i==1) {
						sum+=2;
					}else {
						int beginSubarray=i+1;
						int endSubarray=k-1;
						int maxSubarray=0;
						for(int a=beginSubarray;a<=endSubarray;a++) {
							if(cows[a]>maxSubarray) {
								maxSubarray=cows[a];
							}
						}
						if(maxSubarray>Math.min(cows[i], cows[k])) {
							//BAD
						}else {
							System.out.println("Pair: "+cows[i]+" "+cows[k]);
							sum+=(k-i)+1;
						}
					}
					
				}
			}
			System.out.println("Result: "+sum);
		}
		

	}
	static int[] generateRandom(int n)
    {
        ArrayList<Integer> v = new ArrayList<>(n);
        int[] permutation=new int[n];
        // Fill the vector with the values
        // 1, 2, 3, ..., n
        for (int i = 0; i < n; i++)
            v.add(i + 1);
     
        // While vector has elements
        // get a random number from the vector and print it
        int count=0;
        System.out.print("Array: ");
        while (v.size() > 0)
        {
            int i=getNum(v);
        	System.out.print(i + " ");
        	permutation[count]=i;
        	count++;
        }
        System.out.println();
        return permutation;
    }
	static int getNum(ArrayList<Integer> v)
    {
        // Size of the vector
        int n = v.size();
     
        // Make sure the number is within
        // the index range
        int index = (int)(Math.random() * n);
     
        // Get random number from the vector
        int num = v.get(index);
     
        // Remove the number from the vector
        v.set(index, v.get(n - 1));
        v.remove(n - 1);
     
        // Return the removed number
        return num;
    }

}
