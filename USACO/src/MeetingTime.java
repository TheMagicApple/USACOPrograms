import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class MeetingTime {
	private static HashMap<Integer,ArrayList<int[]>> roads;
	public static void main(String[] args) {
		roads=new HashMap<>();
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int m=s.nextInt();
		for(int i=0;i<m;i++) {
			int start=s.nextInt();
			if(roads.get(start)==null) {
				roads.put(start,new ArrayList<int[]>());
			}
			int[] info=new int[3];
			info[0]=s.nextInt();
			info[1]=s.nextInt();
			info[2]=s.nextInt();
			ArrayList<int[]> a=roads.get(start);
			a.add(info);
			roads.put(start,a);
		}
		/*
		roads.put(1, new ArrayList<>(Arrays.asList(2, 3, 4)));
		
		roads.put(2, new ArrayList<>(Arrays.asList(3, 4, 5)));
		roads.put(3, new ArrayList<>(Arrays.asList(4, 5)));
		roads.put(4, new ArrayList<>(Arrays.asList(5)));
		*/
		ArrayList<Integer> results=dp(1,n,new HashMap<>());
		ArrayList<Integer> results2=dp2(1,n,new HashMap<>());
		System.out.println("TEST");
		/*
		Collections.sort(results);
		Collections.sort(results2);
		
		
		ArrayList<Integer> dupes=new ArrayList<>();
		for(int i=0;i<results.size();i++) {
			if(results2.contains(results.get(i))) {
				dupes.add(results.get(i));
			}
		}
		Collections.sort(dupes);
		if(dupes.size()==0)System.out.println("IMPOSSIBLE");
		else System.out.println(dupes.get(0));
		*/
		

	}
	//FUNCTION: GIVEN A START POINT AND AN END POINT AND A LIST OF ROADS WITH LENGTHS, RETURN A LIST OF THE TOTAL LENGTHS OF ALL POSSIBLE PATHS FROM START TO END
	//ONLY WORKS IF YOU CANT GO BACKWARDS
	//TIME COMPLEXITY WITHOUT MEMOIZATION: O(2^N)
	//TIME COMPLEXITY WITH MEMOIZATION: O(N) BECAUSE THERE ARE ONLY N UNIQUE BRANCHES, HOWEVER CALCULATING EACH BRANCH MAKE TAKE A LONG TIME, ESPECIALLY IF THE TREE IS REALLY TALL OR WIDE
	public static ArrayList<Integer> dp(int start, int end, HashMap<Integer,ArrayList<Integer>> memo){
		int key=start;
		if(memo.get(key)!=null) {
			return memo.get(key);
		}
		ArrayList<Integer> result=new ArrayList<>();
		if(start==end) {
			result.add(0);
			return result;
		}
		ArrayList<int[]> road=roads.get(start);
		for(int[] i:road) {
			ArrayList<Integer> a=dp(i[0],end,memo);
			for(int ii:a) {
				result.add(ii+i[1]);
			}
		}
		memo.put(key, result);
		return result;
	}
	public static ArrayList<Integer> dp2(int start,int end,HashMap<Integer,ArrayList<Integer>> memo){
		int key=start;
		if(memo.get(key)!=null) return memo.get(key);
		ArrayList<Integer> result=new ArrayList<>();
		if(start==end) {
			result.add(0);
			return result;
		}
		ArrayList<int[]> road=roads.get(start);
		for(int[] i:road) {
			ArrayList<Integer> a=dp(i[0],end,memo);
			for(int ii:a) {
				result.add(ii+i[2]);
			}
		}
		memo.put(key, result);
		return result;
	}
}
