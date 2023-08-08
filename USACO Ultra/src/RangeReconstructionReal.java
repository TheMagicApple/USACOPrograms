import java.util.ArrayList;
import java.util.Scanner;

public class RangeReconstructionReal {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		ArrayList<Integer>[] list=new ArrayList[n];
		for(int i=0;i<n;i++) {
			ArrayList<Integer> a=new ArrayList<>();
			for(int k=0;k<n-i;k++) {
				if(k==0) {
					s.nextInt();
				}else {
					a.add(s.nextInt());
				}
				
			}
			list[i]=a;
		}
		ArrayList<Integer> theList=new ArrayList<>();
		theList.add(0);
		for(int i=0;i<n-1;i++) {
			//item i in row 1 is the new total range and item i in column 1 is the difference between last number and this
			int newRange=list[0].get(i);
			int difference=list[i].get(0);
			int previous=theList.get(i);
			int change=difference;
			int add=previous+change;
			int sub=previous-change;
			if(add!=newRange) {
				theList.add(sub);
			}else {
				theList.add(add);
			}
		}
		int counter=0;
		for(int i:theList) {
			if(counter==theList.size()-1) {
				System.out.print(i);
			}else {
				System.out.print(i+" ");
			}
			
			counter++;
		}
		//System.out.println();
		//System.out.println(theList);

	}

}
