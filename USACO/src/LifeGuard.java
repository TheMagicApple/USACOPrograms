import java.util.ArrayList;
import java.util.List;

public class LifeGuard {
	
	public int start;
	public int end;
	public static List<LifeGuard> guards = new  ArrayList<LifeGuard>();
	
	public LifeGuard(int start, int end) {      
		this.start = start;                     
		this.end = end;                         
		                                        
		guards.add(this);                       
	}                                           
	                                            
	public int timeCovered() {                  
		return end-start;                       
	}                                           
	                                            
	public int totalTimeCoveredIfMissing() {    
		int total=0;                            
		int currentStart=guards.get(0).start;   
		int currentEnd=0;                       
		for(LifeGuard guard:guards) {           
			if(guard==this) {
				continue;
			}
			currentStart=guard.start;           
			if(currentEnd<currentStart) {       
				currentEnd=guard.end;           
			}else {                             
				currentStart=currentEnd;        
				currentEnd=guard.end;           
			}                                   
			total+=currentEnd-currentStart;     
			                                    
		}                                       
		return total;                             
	}                                           
	                                            
	public static int totalTimeCovered() {      
		int total=0;                            
		int currentStart=guards.get(0).start;   
		int currentEnd=0;                       
		for(LifeGuard guard:guards) {           
			currentStart=guard.start;           
			if(currentEnd<currentStart) {       
				currentEnd=guard.end;           
			}else {                             
				currentStart=currentEnd;        
				currentEnd=guard.end;           
			}                                   
			total+=currentEnd-currentStart;     
			                                    
		}                                       
		return total;
		
	}
	
	public static int largestTimeAfterFire() {
		int largest=0;
		for(LifeGuard guard:guards) {
			if(guard.totalTimeCoveredIfMissing()>largest) {
				largest=guard.totalTimeCoveredIfMissing();
			}
		}
		return largest;
	}

	public static void main(String[] args) {
		
		new LifeGuard(5,9);
		new LifeGuard(1,4);
		new LifeGuard(3,4);
		new LifeGuard(20,30);
		new LifeGuard(19,25);
		guards.sort((l1,l2) -> l1.start-l2.start);
		System.out.println( largestTimeAfterFire() );

		
		

	}

}

