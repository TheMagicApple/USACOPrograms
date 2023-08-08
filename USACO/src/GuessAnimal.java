import java.util.ArrayList;
import java.util.Scanner;

public class GuessAnimal {
	private static int nAnimals;
	private static int yes=0;
	private static ArrayList<ArrayList<String>> animals=new ArrayList<>();
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		nAnimals=s.nextInt();
		
		
		for(int i=0;i<nAnimals;i++) {
			ArrayList<String> animal=new ArrayList<>();
			animal.add(s.next());
			int end=s.nextInt();
			for(int k=0;k<end;k++) {
				animal.add(s.next());
			}
			animals.add(animal);
		}
		
		
		ArrayList<String> removedChars=new ArrayList<>();
		boolean foundIt=false;
		
		while(!foundIt) {
			ArrayList<String> characteristics=new ArrayList<>();
			for(ArrayList<String> animal:animals) {
				for(int i=1;i<animal.size();i++) {
					if(characteristics.contains(animal.get(i)) || removedChars.contains(animal.get(i))) {
						
					}else {
						characteristics.add(animal.get(i));
					}
				}
			}
			
			int[] c=new int[characteristics.size()];
			for(ArrayList<String> animal:animals) {
				for(int i=1;i<animal.size();i++) {
					if(removedChars.contains(animal.get(i))) {
						
					}else {
						c[characteristics.indexOf(animal.get(i))]++;
					}
					
				}
			}
			int maximum=0;
			int maxIndex=0;
			
			for(int i=0;i<c.length;i++) {
				if(c[i]>maximum) {
					maximum=c[i];
					maxIndex=i;
					
				}
				
			}
			//System.out.println(characteristics.get(maxIndex));
			//we have the characteristic that appeared the most
			for(int i=0;i<animals.size();i++) {
				if(animals.get(i).contains(characteristics.get(maxIndex))) {
					
				}else {
					animals.remove(i);
				}
			}
			removedChars.add(characteristics.get(maxIndex));
			
			yes++;
			if(animals.size()==1) {
				foundIt=true;
			}
			
			
		}
		System.out.println(yes);
		

	}

}
