import java.util.Scanner;
public class DaisyChains {
	private static int nFlowers;
	private static int[] flowers;
	private static int averagePhotos;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		nFlowers=s.nextInt();
	
		flowers=new int[nFlowers];
		for(int i=0;i<flowers.length;i++) {
			flowers[i]=s.nextInt();
		}
		/*
		flowers[0]=1;
		flowers[1]=1;
		flowers[2]=2;
		flowers[3]=3;
		*/
		for(int i=0;i<nFlowers;i++) {
			for(int j=0;j<nFlowers;j++) {
				if(j>=i) {
					if(isAverage(i,j)) {
						averagePhotos++;
					}
				}
			}
		}
		System.out.println(averagePhotos);
	}
	public static boolean isAverage(int i,int j) {
		if(i==j) {
			return true;
		}
		double average=0.0;
		for(int ii=i;ii<=j;ii++) {
			average+=flowers[ii];
		}
		average=average/(double)(j-i+1);
		for(int ii=i;ii<=j;ii++) {
			if(flowers[ii]==average) {
				//System.out.println(i);
				//System.out.println(j);
				return true;
			}
		}
		return false;
		
	}

}
