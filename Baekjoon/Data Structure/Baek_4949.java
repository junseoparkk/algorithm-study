import java.util.*;
import java.io.*;

public class Baek_4949{
	public static String solve(String str) {
		Stack<Character>stk=new Stack<>();
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			
			if(ch=='('||ch=='[') 
				stk.push(ch);
			
			else if(ch==')') {
				if(stk.empty()||stk.peek()!='(') {
					return "no";
				}
				else stk.pop();
			}
			else if(ch==']') {
				if(stk.empty()||stk.peek()!='[') {
					return "no";
				}
				else stk.pop();
			}
		}
		if(!stk.empty()) return "no";
		else return "yes";
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String str=bf.readLine();
			if(str.equals(".")) break;
			System.out.println(solve(str));
		}
	}
}