import java.util.Scanner;
import java.util.ArrayList;
public class YearOfTheCow {
	private static String[] years= {"Ox","Tiger","Rabbit","Dragon","Snake","Horse","Goat","Monkey","Rooster","Dog","Pig","Rat"};
	private static String[] instructions;
	private static int nInstructions;
	private static String[] cowRelationships;
	private static ArrayList<String> variables=new ArrayList<String>();
	private static ArrayList<String> equations=new ArrayList<String>();
	private static ArrayList<String> solvedCows=new ArrayList<String>();
	private static ArrayList<String> realSolvedCows=new ArrayList<String>();
	private static int year=1;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		nInstructions=s.nextInt();
		instructions=new String[nInstructions];
		cowRelationships=new String[nInstructions];
		s.nextLine();
		for(int i=0;i<nInstructions;i++) {
			
			instructions[i]=s.nextLine();
			
		}
		//bessie=1
		//mildred=
		//mildred=1-a
		//a=9
		//gretta=mildred-b
		//b=8
		//elsie=gretta+c
		//c=5
		//paulina=bessie+d
		
		//bessie-a=gretta+b
		//bessie-a=elsie-c+b
		//bessie-elsie=x
		//bessie-elsie=a-c+b
		
		//instructions[0]="Mildred born in previous Dragon year from Bessie";
		//instructions[1]="Gretta born in previous Monkey year from Mildred";
		//instructions[2]="Elsie born in next Ox year from Gretta";
		//instructions[3]="Paulina born in next Dog year from Bessie";
		
		createEquations();
		
		for(String equation:equations) {
			//System.out.println(equation);
		}
		solveVariables();
		for(String variable:variables) {
			//System.out.println(variable);
		}
		for(String variable:realSolvedCows) {
			//System.out.println(variable);
		}
		System.out.println(solveEquations());
	}
	public static void createEquations() {
		
		for(int i=0;i<instructions.length;i++) {
			String instruction=instructions[i];
			String[] ins=instruction.split(" ");
			String sign;
			if(ins[3].equals("next")) {
				sign="+";
			}else {
				sign="-";
			}
			/*
			if(i==0) {
				equations.add(ins[0]+"=1"+sign+"a"+i);
			}else {
				equations.add(ins[0]+"="+ins[7]+sign+"a"+i);
			}
			*/
			equations.add(ins[0]+"="+ins[7]+sign+"a"+i);
			variables.add("a"+i+"=");
			
		}
	}
	public static void solveVariables() {
		solvedCows.add("Bessie=1");
		int aaa=0;
		String sign="";
		for(String equation:equations) {
			
		String[] e=equation.split("-|\\+");
			String variable=e[1];
			int cowis=0;
			boolean already=false;
			for(String var:variables) {
				if(var.charAt(var.length()-1)=='=') {
					already=false;
				}else {
					already=true;
				}
			}
			if(already==true) {
				continue;
			}
			
			int solved;
			int counter=0;
			String[] things=equation.split("=");
			int y=0;
			int realIndex=0;
			for(String s:solvedCows) {
				String[] asdf=s.split("=");
				if(asdf[0].charAt(0)==things[1].charAt(0)){
					String index=asdf[1];
					//System.out.println("index:"+index);
					realIndex=Integer.parseInt(index);
					cowis=realIndex;
				}
			}
			boolean done=false;
			String animal;
			while(!done) {
				//System.out.println("realindex:"+realIndex);
				animal=years[realIndex-1];
				String instruction=instructions[aaa];
				String[] iii=instruction.split(" ");
				if(iii[3].equals("next")) {
					sign="+";
				}else {
					sign="-";
				}
				//System.out.println(iii[4]);
				//System.out.println(animal);
				if(iii[4].equals(animal)) {
					//System.out.println("flag");
					done=true;
				}
				if(sign.equals("-")) {
					realIndex--;
				}else {
					realIndex++;
				}
				
				if(realIndex<1) {
					realIndex=12;
				}else if(realIndex>12) {
					realIndex=1;
				}
				counter++;
			}
			counter--;
			//System.out.println("flag");
			for(int i=0;i<variables.size();i++) {
				//System.out.println(variables.get(i).charAt(1));
				//System.out.println(e[1].charAt(1));
				if(variables.get(i).charAt(1)==e[1].charAt(1)) {
					//System.out.println("flag");
					variables.set(i, variables.get(i)+counter);
				}
			}
			if(sign.equals("-")) {
				if(cowis-counter<1) {
					solvedCows.add(things[0]+"="+(((cowis-counter)+12)));
				}else if(cowis-counter>12) {
					solvedCows.add(things[0]+"="+(((cowis-counter)-12)));
				}else {
					solvedCows.add(things[0]+"="+(((cowis-counter))));
				}
				realSolvedCows.add(things[0]+"="+(((cowis-counter))));
				
			}
			if(sign.equals("+")) {
				
				if(cowis+counter<1) {
					solvedCows.add(things[0]+"="+(((cowis+counter)+12)));
				}else if(cowis+counter>12) {
					solvedCows.add(things[0]+"="+(((cowis+counter)-12)));
				}else {
					solvedCows.add(things[0]+"="+(((cowis+counter))));
				}
				realSolvedCows.add(things[0]+"="+(((cowis+counter))));
			}
			aaa++;
			
			
		}
	}
	public static int solveEquations() {
		int magicNumber=1;
		for(int i=0;i<realSolvedCows.size();i++) {
			String s=realSolvedCows.get(i);
			String[] breakup=s.split("=");
			if(breakup[0].equals("Elsie")) {
				magicNumber=Integer.parseInt(breakup[1]);
			}
		}
		return Math.abs(1-magicNumber);
	}
	

}
