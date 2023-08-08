import java.util.ArrayList;
import java.util.Scanner;

public class SubsetEquality {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String s1=s.next();
		String s2=s.next();
		int q=s.nextInt();
		String[] queries=new String[q];
		for(int i=0;i<q;i++) {
			queries[i]=s.next();
		}
		ArrayList<String> badStrings=new ArrayList<>();
		int[] s1Chars=new int[18];
		int[] s2Chars=new int[18];
		for(int i=0;i<s1.length();i++) {
			s1Chars[s1.charAt(i)-97]++;
		}
		for(int i=0;i<s2.length();i++) {
			s2Chars[s2.charAt(i)-97]++;
		}
		for(int i=0;i<18;i++) {
			if(s1Chars[i]!=s2Chars[i]) {
				badStrings.add(String.valueOf((char) (i+97)));
			}
		}
		char[] alphabet= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r'};
		for(int i=0;i<18;i++) {
			for(int k=i+1;k<18;k++) {
				char char1=alphabet[i];
				char char2=alphabet[k];
				String newS1="";
				String newS2="";
				for(int c=0;c<s1.length();c++) {
					if(s1.charAt(c)==char1 || s1.charAt(c)==char2) {
						newS1+=s1.charAt(c);
					}
				}
				for(int c=0;c<s2.length();c++) {
					if(s2.charAt(c)==char1 || s2.charAt(c)==char2) {
						newS2+=s2.charAt(c);
					}
				}
				if(!newS1.equals(newS2)) {
					String badString="";
					badString+=char1;
					badString+=char2;
					badStrings.add(badString);
				}
			}
		}
		String answer="";
		for(String query:queries) {
			boolean problem=false;
			for(String badString:badStrings) {
				if(badString.length()==1) {
					if(query.indexOf(badString)!=-1) {
						answer+="N";
						problem=true;
						break;
					}
				}else {
					if(query.indexOf(badString.charAt(0))!=-1 && query.indexOf(badString.charAt(1))!=-1) {
						answer+="N";
						problem=true;
						break;
					}
				}
			}
			if(!problem) {
				answer+="Y";
			}
		}
		System.out.println(answer);
	}
}
