import java.util.*;
import java.io.*;

/**
 * 
 * 1.‘()’ 인 괄호열의 값은 2이다.
 * 2.‘[]’ 인 괄호열의 값은 3이다.
 * 3.‘(X)’ 의 괄호값은 2×값(X) 으로 계산된다.
 * 4.‘[X]’ 의 괄호값은 3×값(X) 으로 계산된다.
 * 5.올바른 괄호열 X와 Y가 결합된 XY의 괄호값은 값(XY)= 값(X)+값(Y) 로 계산된다.
 *
 */

public class Baek_2504{
	public static void solve(String str) {
		Stack<Character>stk=new Stack<>();
		int result=0;
		int tmp=1;
		
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			
			if(ch=='('||ch=='[') {
				stk.push(ch);
				if(ch=='(') 
					tmp*=2;
				else 
					tmp*=3;
					
			}
			else if(ch==')') {
				if(stk.isEmpty()||stk.peek()!='(') {
					result=0;
					break;
				}
				else if(str.charAt(i-1)=='(') {
					result+=tmp;
				}
				tmp/=2;
				stk.pop();
			}else if(ch==']') {
				if(stk.isEmpty()||stk.peek()!='[') {
					result=0;
					break;
				}
				else if(str.charAt(i-1)=='[') {
					result+=tmp;
				}
				tmp/=3;
				stk.pop();
			}
		}
		
		if(!stk.isEmpty()) System.out.print(0);
		else System.out.print(result);
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String str=bf.readLine();
		
		solve(str);		
	}
}