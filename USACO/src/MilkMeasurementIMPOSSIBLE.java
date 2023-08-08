import java.util.ArrayList;
import java.util.Scanner;
public class MilkMeasurementIMPOSSIBLE {
	private static int[] milk;
	private static String milkHackers="";
	private static int nMeasurements;
	private static String[] logs;
	private static int baseMilk;
	private static int changes=0;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		nMeasurements=s.nextInt();
		logs=new String[nMeasurements];
		baseMilk=s.nextInt();
		milk=new int[10000];
		for(int i=0;i<milk.length;i++) {
			milk[i]=baseMilk;
		}
		s.nextLine();
		for(int i=0;i<logs.length;i++) {
			//s.nextLine();
			logs[i]=s.nextLine();
			//s.nextLine();
		}
		//logs[0]="7 3 +3";
		//logs[1]="4 2 -1";
		//logs[2]="9 3 -1";
		//logs[3]="1 1 +2";
		sort();
		/*
		for(String measure:logs) {
			System.out.println(measure);
		}
		*/
		track();
		System.out.println(changes);
		
	}
	public static void findWinner() {
		ArrayList<Integer> winners=new ArrayList<>();
		int biggest=0;
		for(int m:milk) {
			if(m>biggest) {
				biggest=m;
			}
		}
		for(int i=0;i<milk.length;i++) {
			if(milk[i]==biggest) {
				winners.add(i);
			}
		}
		//String[] oldMilkHackers=milkHackers.split(" ");
		String oldMilkHackers=milkHackers;
		milkHackers="";
		for(int winner:winners) {
			milkHackers+=winner+" ";
		}
		//System.out.println("old:"+oldMilkHackers);
		//System.out.println("hackers:"+milkHackers);
		//System.out.println("FLAG");
		if(milkHackers.equals(oldMilkHackers)) {
			//changes++;
		}else {
			changes++;
		}
		
	}
	public static void track() {
		//findWinner();
		for(String measurement:logs) {
			String[] logParts=measurement.split(" ");
			String cow=logParts[1];
			String change=logParts[2];
			int realChange;
			if(change.charAt(0)=='-') {
				
				String aaa=" "+change;
				String[] thing=aaa.split("\\-");
				//System.out.println(thing[1]);
				realChange=-1*Integer.parseInt(String.valueOf(thing[1]));
			}else {
				
				String aaa=" "+change;
				String[] thing=aaa.split("\\+");
				realChange=Integer.parseInt(String.valueOf(thing[1]));
				
			}
			int cowIndex=Integer.parseInt(cow)-1;
			//milk[cowIndex]+=realChange;
			findWinner();
		}
	}
	public static void sort() {
		for(int i=0;i<logs.length;i++) {
			for(int k=0;k<logs.length-1;k++) {
				char day=logs[k].charAt(0);
				char dayAfter=logs[k+1].charAt(0);
				int nDay=Integer.parseInt(String.valueOf(day));
				int nDayAfter=Integer.parseInt(String.valueOf(dayAfter));
				if(nDay>nDayAfter) {
					String temp=logs[k];
					logs[k]=logs[k+1];
					logs[k+1]=temp;
				}
				
			}
		}
	}
	

}
