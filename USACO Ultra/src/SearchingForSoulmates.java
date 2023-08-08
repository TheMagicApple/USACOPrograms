import java.util.ArrayList;
import java.util.Scanner;

public class SearchingForSoulmates {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		Vector[] pairs=new Vector[n];
		for(int i=0;i<2;i++) {
			pairs[i]=new Vector(s.nextInt(),s.nextInt());
		}
		for(Vector pair:pairs) {
			int start=pair.x;
			int end=pair.y;
			int operations=0;
			ArrayList<Integer> divisors=new ArrayList<>();
			int i=end;
			if(i%2==1) i--;
			while(true) {
				divisors.add(i);
				if(i%2==1)break;
				i/=2;
			}
			System.out.println(divisors);
			while(start!=end) {
				if(start>end) {
					if(start%2==1) {
						start++;
						operations++;
					}else {
						start/=2;
						operations++;
					}
				}else {
					int currentDivisor=0;
					while(true) {
						if(end-start<=2 && start<end) {
							System.out.println("0:"+start);
							start++;
							operations++;
						}
						else if(start%2==1) {
							start++;
							System.out.println("1:"+start);
							operations++;
						}else {
							if(currentDivisor>=divisors.size()-1) {
								while(start!=divisors.get(currentDivisor)) {
									start++;
									System.out.println("2:"+start);
									operations++;
								}
								while(start!=end && start!=end-1) {
									start*=2;
									System.out.println("3:"+start);
									operations++;
									//System.out.println("HELLO");
								}
								if(start==end-1) {
									start++;
									System.out.println("4:"+start);
									operations++;
								}
								break;
							}
							int distance=divisors.get(currentDivisor)-start;
							int newdistance=divisors.get(currentDivisor+1)-(start/2);
							if(newdistance<distance) {
								start/=2;
								System.out.println("5:"+start);
								currentDivisor++;
								operations++;
							}else {
								while(start!=divisors.get(currentDivisor)) {
									start++;
									System.out.println("6:"+start);
									operations++;
								}
								while(start!=end && start!=end-1) {
									start*=2;
									System.out.println("7:"+start);
									operations++;
								}
								if(start==end-1) {
									start++;
									System.out.println("8:"+start);
									operations++;
								}
								break;
							}
							//operations++;
							System.out.println("special:"+start);
						}
					}
					
				}
			}
			System.out.println("answer:"+operations);
		}

	}

}
