import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class CowFrisbee {
	static int ans=0;
	static int N;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		N=s.nextInt();
		ArrayList<Integer> h=new ArrayList<>();
		for(int i=0;i<N;i++) {
			h.add(s.nextInt());
		}
		add_contribution_alt(h);
		Collections.reverse(h);
		add_contribution_alt(h);
		System.out.println(ans);
	}
	static void add_contribution_alt(ArrayList<Integer> h) {
		Stack<Integer> stk=new Stack<>();
		for (int i = N-1; i >= 0; --i) {
			System.out.println(stk);
			while (!stk.empty() && h.get(stk.peek()) < h.get(i)) {
				System.out.println(stk);
				stk.pop();
			}
			if (!stk.empty()) {
				ans += stk.peek()-i+1;
				System.out.println("pair:"+i+" "+stk.peek());
			}
			stk.push(i);
		}
	}
}
