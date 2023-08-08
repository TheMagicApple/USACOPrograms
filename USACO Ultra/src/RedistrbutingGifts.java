import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class RedistrbutingGifts {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		HashMap<Integer,ArrayList<Integer>> cows=new HashMap<>();
		for(int i=1;i<=n;i++) {
			ArrayList<Integer> gifts=new ArrayList<>();
			boolean recording=true;
			for(int k=0;k<n;k++) {
				int gift=s.nextInt();
				if(recording) gifts.add(gift);
				if(gift==i) {
					recording=false;
				}
			}
			cows.put(i, gifts);
		}
		ArrayList<Integer> mostPreferred=new ArrayList<>();
		for(int cow:cows.keySet()) {
			boolean foundIt=false;
			int index=0;
			while(!foundIt) {
				int gift=cows.get(cow).get(index);
				HashSet<Integer> giftsLeft=new HashSet<>();
				boolean possible=true;
				for(int c:cows.keySet()) {
					if(c!=cow) {
						int a=0;
						for(int want:cows.get(c)) {
							if(want!=gift) {
								giftsLeft.add(want);
								a++;
							}
						}
						if(a==0) {
							possible=false;
							break;
						}
					}
				}
				if(possible && giftsLeft.size()>=n-1) { //if there are less gifts than cows it impossible, else it is possible
					mostPreferred.add(gift);
					foundIt=true;
					break;
				}
				index++;
			}
		}
		
		System.out.println(mostPreferred);

	}

}
