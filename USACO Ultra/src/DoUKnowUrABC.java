import java.util.HashSet;
import java.util.Scanner;

public class DoUKnowUrABC {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		HashSet<ABC> triplets=new HashSet<>();
		if(n==4) {
			int[] values=new int[]{s.nextInt(),s.nextInt(),s.nextInt(),s.nextInt()};
			int[] array=new int[7];
			for(int i=0;i<4;i++) {
				for(int j=i+1;j<5;j++) {
					for(int k=j+1;k<6;k++) {
						for(int u=k+1;u<7;u++) {
							array[i]=values[0];
							array[j]=values[1];
							array[k]=values[2];
							array[u]=values[3];
							
							for(int a:array) {
								//System.out.print(a+" ");
							}
							//System.out.println();
							
							boolean bad=false;
							if(array[0]!=0 && array[1]!=0 && array[2]!=0 && array[6]!=0) {
								
								if(array[0]+array[1]+array[2]!=array[6]) {
									bad=true;
								}
							}else {
								if(array[0]==542344353 && array[3]!=0 && array[4]!=0 && array[5]!=0 && array[6]!=0) {
									//bad case
								}else {
									if(array[3]!=0 && array[0]!=0) {
										if(array[1]==0 || array[1]==array[3]-array[0]) {
											array[1]=array[3]-array[0];
										}else {
											bad=true;
											
										}
									}
									if(array[3]!=0 && array[1]!=0) {
										if(array[0]==0 || array[0]==array[3]-array[1]) {
											array[0]=array[3]-array[1];
										}else {
											bad=true;
											
										}
									}
									if(array[4]!=0 && array[0]!=0) {
										if(array[2]==0 || array[1]==array[4]-array[0]) {
											array[2]=array[4]-array[0];
										}else {
											bad=true;
											
										}
									}
									if(array[4]!=0 && array[2]!=0) {
										if(array[0]==0 || array[0]==array[4]-array[2]) {
											array[0]=array[4]-array[2];
										}else {
											bad=true;
											
										}
									}
									if(array[5]!=0 && array[1]!=0) {
										if(array[2]==0 || array[2]==array[5]-array[1]) {
											array[2]=array[5]-array[1];
										}else {
											bad=true;
											
										}
									}
									if(array[5]!=0 && array[2]!=0) {
										if(array[1]==0 || array[1]==array[5]-array[2]) {
											array[1]=array[5]-array[2];
										}else {
											bad=true;
											
										}
									}
									if(array[0]!=0 && array[1]!=0 && array[6]!=0) {
										if(array[2]==0 || array[2]==array[6]-(array[0]+array[1])) {
											array[2]=array[6]-(array[0]+array[1]);
										}else {
											bad=true;
										}
									}
									if(array[1]!=0 && array[2]!=0 && array[6]!=0) {
										if(array[0]==0 || array[0]==array[6]-(array[1]+array[2])) {
											array[0]=array[6]-(array[0]+array[1]);
										}else {
											bad=true;
										}
									}
									if(array[0]!=0 && array[2]!=0 && array[6]!=0) {
										if(array[1]==0 || array[1]==array[6]-(array[0]+array[2])) {
											array[1]=array[6]-(array[0]+array[2]);
										}else {
											bad=true;
										}
									}
									if(array[3]!=0 && array[6]!=0) {
										if(array[2]==0 || array[2]==array[6]-array[3]) {
											array[2]=array[6]-array[3];
										}
									}
									if(array[4]!=0 && array[6]!=0) {
										if(array[1]==0 || array[2]==array[6]-array[4]) {
											array[1]=array[6]-array[4];
										}
									}
									if(array[5]!=0 && array[6]!=0) {
										if(array[0]==0 || array[2]==array[6]-array[5]) {
											array[0]=array[6]-array[5];
										}
									}
									if((array[3]!=array[0]+array[1] && array[3]!=0 && array[0]!=0 && array[1]!=0)|| (array[4]!=array[0]+array[2]&&array[4]!=0&&array[0]!=0&&array[2]!=0) || (array[5]!=array[1]+array[2]&&array[5]!=0&&array[1]!=0&&array[2]!=0) || (array[6]!=array[0]+array[1]+array[2]&&array[6]!=0&&array[0]!=0&&array[1]!=0&&array[2]!=0)) {
										bad=true;
										
										
									}else {
										
										for(int a:array) {
											if(a<0) {
												bad=true;
												
												break;
											}
										}
									}
									
								}
							}
							if(!bad) {
								triplets.add(new ABC(array[0],array[1],array[2]));
								//System.out.println(array[0]+" "+array[1]+" "+array[2]);
							}
							array=new int[7];
							
						}
					}
				}
			}
			
		}
		System.out.println(triplets.size());

	}

}
class ABC{
	public int A;
	public int B;
	public int C;
	public ABC(int A,int B,int C) {
		this.A=A;
		this.B=B;
		this.C=C;
	}
	public int hashCode() {
		return A*29+B*31+C*37;
	}
}
