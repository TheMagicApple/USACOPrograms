import java.util.ArrayList;

public class TimeTesting {

	public static void main(String[] args) {
		/* RESULTS:
		 * N=100000 and 0 function calls: <200ms
		 * N=100000 and 10 function calls: 320ms
		 * N=100000 and 20 function calls: 360ms
		 * N=1000000 and 2 function calls: 200ms
		 * N=1000000 and 10 function calls: 1000ms
		 * N=1000000 and 20 function calls: 1600ms
		 * N=1000000 and 20 function calls and 2 gets() and 1 remove(): TIMEOUT
		 * N=1000000 and 20 function calls and 3 gets(): 1400ms
		 * N=1000000 and 20 function calls and 2 gets() and 1 if statement: 1400ms
		 * N=1000000 and 17 function calls and 1 remove(): TIMEOUT
		 * N=1000000 and 17 function calls and 1 set(null): 1350ms
		 * 
		 * 
		 * DO NOT USE REMOVE()!!!!!!!!!!!! USE SET(NULL)!!!!!!!!!!!!!!
		 * REMOVE()=INSTANT TIMEOUT!!!!!!!
		 * 
		 * server takes about 5x to 7x as long to run program
		 */
		
		
		
		
		
		long startTime=System.currentTimeMillis();
		int n=1000000;
		ArrayList<Integer> test=new ArrayList<>();
		for(int i=0;i<n;i++) {
			
			test.add((int)(Math.random()*10+1));
			test.add((int)(Math.random()*10+1));
			test.add((int)(Math.random()*10+1));
			test.add((int)(Math.random()*10+1));
			test.add((int)(Math.random()*10+1));
			
		}
		
		
		
		System.out.println("2 2 7");
		long endTime=System.currentTimeMillis();
		System.out.println("program took: "+(endTime-startTime));

	}

}
