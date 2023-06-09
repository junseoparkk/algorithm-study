import java.util.*;
import java.io.*;

public class Baek_1406{
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		String str= bf.readLine();
		int M=Integer.parseInt(bf.readLine());
		
		Stack<Character>left=new Stack<>();
		Stack<Character>right=new Stack<>();
		
		for(int i=0;i<str.length();i++)
			left.push(str.charAt(i));
		
		for(int i=0;i<M;i++) {
			StringTokenizer stk=new StringTokenizer(bf.readLine());
			char ch=stk.nextToken().charAt(0);
			
			if(ch=='L') {
				if(left.isEmpty()) continue;
				else right.push(left.pop());
			}else if(ch=='D') {
				if(right.isEmpty()) continue;
				else left.push(right.pop());
			}else if(ch=='B') {
				if(left.isEmpty()) continue;
				else left.pop();
			}else if(ch=='P') {
				char ch2=stk.nextToken().charAt(0);
				left.push(ch2);
			}
		}
		
		while(!left.isEmpty())
			right.push(left.pop());
		
		while(!right.isEmpty())
			sb.append(right.pop());
		
		System.out.print(sb.toString());
	}
}
