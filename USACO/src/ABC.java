import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class ABC {
	private static ArrayList<Integer> numbers=new ArrayList<>();
	private static int a;
	private static int b;
	private static int c;
	private static int aPlusBPlusC;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		for(int i=0;i<7;i++) {
			numbers.add(s.nextInt());
		}
		Collections.sort(numbers);
		aPlusBPlusC=numbers.get(6);
		numbers.remove(6);
		findABC();
		System.out.println(a+" "+b+" "+c);
	}
	public static void findABC() {
		for(int i=0;i<numbers.size();i++) {
			int testA=numbers.get(i);
			for(int k=0;k<numbers.size();k++) {
				int testB=numbers.get(k);
				for(int j=0;j<numbers.size();j++) {
					int testC=numbers.get(j);
					for(int q=0;q<numbers.size();q++) {
						int testAPlusB=numbers.get(q);
						for(int w=0;w<numbers.size();w++) {
							int testBPlusC=numbers.get(w);
							for(int y=0;y<numbers.size();y++) {
								int testCPlusA=numbers.get(y);
								if((testA+testB==testAPlusB) && (testB+testC==testBPlusC) && (testC+testA==testCPlusA) && (testA+testB+testC==aPlusBPlusC)) {
									a=testA;
									b=testB;
									c=testC;
									return;
									
								}
							}
						}
					}
				}
			}
		}
	}
	

}
