import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
 
class GFG {
    long val;
    long steps;
 
    public GFG(long val, long steps)
    {
        this.val = val;
        this.steps = steps;
    }
}
 
public class SearchingForSoulmatesReal {
    private static long minOperations(long src, long target)
    {
 
        Set<Long> visited = new HashSet<>(1000000);
        LinkedList<GFG> queue = new LinkedList<GFG>();
 
        GFG node = new GFG(src, 0);
 
        queue.offer(node);
 
        while (!queue.isEmpty()) {
            GFG temp = queue.poll();
            if(visited.contains(temp.val)) {
              continue;
            }
            visited.add(temp.val);
 
            if (temp.val == target) {
                return temp.steps;
            }
 
            long mul = temp.val * 2;
            long sub = temp.val + 1;
            if(temp.val%2==0) {
            	long div=temp.val/2;
            	 if (mul > 0 && mul < 1000000000000000000l) {
                     GFG nodeMul = new GFG(mul, temp.steps + 1);
                     queue.offer(nodeMul);
                 }
                 if (sub > 0 && sub < 1000000000000000000l) {
                     GFG nodeSub = new GFG(sub, temp.steps + 1);
                     queue.offer(nodeSub);
                 }
                 if (div > 0 && div < 1000000000000000000l) {
                     GFG nodeSub = new GFG(div, temp.steps + 1);
                     queue.offer(nodeSub);
                 }
            }else {
            	if (mul > 0 && mul < 1000000000000000000l) {
                    GFG nodeMul = new GFG(mul, temp.steps + 1);
                    queue.offer(nodeMul);
                }
                if (sub > 0 && sub < 1000000000000000000l) {
                    GFG nodeSub = new GFG(sub, temp.steps + 1);
                    queue.offer(nodeSub);
                }
            }
            // given constraints
           
        }
        return -1;
    }
 
    // Driver code
    public static void main(String[] args)
    {
        // int x = 2, y = 5;
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        long[][] stuff=new long[n][2];
        for(int i=0;i<n;i++) {
        	long x=s.nextLong();
        	long y=s.nextLong();
        	long[] thing=new long[2];
        	thing[0]=x;
        	thing[1]=y;
        	stuff[i]=thing;
        }
        for(long[] thing:stuff) {
        	GFG src = new GFG(thing[0], thing[1]);
            System.out.println(minOperations(thing[0], thing[1]));
        }
        
    }
}
 