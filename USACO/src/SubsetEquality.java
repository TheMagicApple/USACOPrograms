import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubsetEquality {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String s1=s.next();
		String s2=s.next();
		int q=s.nextInt();
		String[] queries=new String[q];
		for(int i=0;i<q;i++) {
			queries[i]=s.next();
		}
		Map<Character,ArrayList<Integer>> map1=new HashMap<>();
		Map<Character,ArrayList<Integer>> map2=new HashMap<>();
		for(int i=0;i<s1.length();i++) {
			char c=s1.charAt(i);
			if(map1.get(c)!=null) {
				map1.get(c).add(i);
			}else {
				ArrayList<Integer> a=new ArrayList<>();
				a.add(i);
				map1.put(c, a);
			}
		}
		for(int i=0;i<s2.length();i++) {
			char c=s1.charAt(i);
			if(map2.get(c)!=null) {
				map2.get(c).add(i);
			}else {
				ArrayList<Integer> a=new ArrayList<>();
				a.add(i);
				map2.put(c, a);
			}
		}
		for(String query:queries) {
			int l=0;
			for(int i=0;i<query.length();i+=0) {
				if(query.charAt(i)==l+97) {
					i++;
				}else {
					
				}
				l++;
			}
		}
		String[] s1split=s1.split("");
		String[] s2split=s2.split("");
		

	}

}
