import java.util.ArrayList;
import java.util.Scanner;

public class RangeReconstructionRealReal {

	public static void main(String[] args) {
		//logic correct
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		ArrayList<ArrayList<Integer>> ranges=new ArrayList<>();
		for(int i=0;i<n;i++) {
			s.nextInt();
			ArrayList<Integer> range=new ArrayList<>();
			for(int j=i+1;j<n;j++) {
				range.add(s.nextInt());
			}
			ranges.add(range);
		}
		int[] theArray=new int[n];
		
		theArray[0]=0;
		//System.out.println(ranges);
		for(int i=1;i<n;i++) {
			//System.out.println(i);
			int instantChange=ranges.get(i-1).get(0);
			int option1=theArray[i-1]+instantChange;
			int option2=theArray[i-1]-instantChange;
			int row=0;
			int col=i-1;
			while(true) {
				int range=ranges.get(row).get(col); //range between arr[row] and arr[i]
				int min=10000000;
				int max=0;
				theArray[i]=option1;
				for(int a=row;a<=i;a++) {
					if(theArray[a]<min) {
						min=theArray[a];
					}
					if(theArray[a]>max) {
						max=theArray[a];
					}
				}
				int option1range=max-min;
				min=10000000;
				max=0;
				theArray[i]=option2;
				for(int a=row;a<=i;a++) {
					if(theArray[a]<min) {
						min=theArray[a];
					}
					if(theArray[a]>max) {
						max=theArray[a];
					}
				}
				int option2range=max-min;
				if(option1range!=range) {
					theArray[i]=option2;
					break;
				}else if(option2range!=range) {
					theArray[i]=option1;
					break;
				}else {
					
				}
				row++;
				col--;
				if(col==-1) {
					theArray[i]=option2;
					break;
				}
			}
		}
		
		for(int i=0;i<theArray.length;i++) {
			if(i==theArray.length-1) {
				System.out.print(theArray[i]);
			}else {
				System.out.print((theArray[i]+9)+" ");
			}
			
		}
		System.out.println();
		System.out.println("9 8 7 6 7 6 5 4 5 4 5 6 7 8 9 8 9 8 7 8 9 8 7 6 7 6 5 6 5 6 7 6 5 4 3 4 5 4 3 2 3 2 1 0 1 2 3 2 1 0 1 2 3 2 3 2 3 4 5 6 5 6 5 6 7 6 7 8 7 6 7 8 9 10 11 12 13 12 13 14 15 16 17 18 19 18 19 20 19 18 19 18 17 16 15 14 13 12 11 10 9 8 7 8 7 8 9 10 11 10 11 12 11 10 11 12 11 12 13 14 13 12 11 12 11 10 9 8 7 8 9 8 7 6 5 6 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101 102 103 104 103 104 105 106 105 104 105 106 107 106 107 106 107 106 105 104 103 102 101 100 99 98 97 96 95 96 97 98 97 96 95 96 97 96 97 98 99 100 101 102 101 100 99 98 99 100 99 98 97 98 99 100 101 100 101 102 101 100 99 98 97 96 95 94\r\n"
				+ "");

	}

}
