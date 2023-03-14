package String;
import java.util.*;
import java.io.*;

public class Baek_2754{
		public static void main(String[] args) throws IOException{
			Scanner sc=new Scanner(System.in);
			String score=sc.next();
			double result=0.0;
			
			switch(score.charAt(0)) {
			case 'A':
				result=4.0;
				break;
			case 'B':
				result=3.0;
				break;
			case 'C':
				result=2.0;
				break;
			case 'D':
				result=1.0;
				break;
			default:
				result=0.0;
				score+=' ';
				break;
			}
			
			switch(score.charAt(1)) {
			case '+':
				result+=0.3;
				break;
			case '-':
				result-=0.3;
				break;
			default:
				break;
			}
			
			System.out.print(result);
			
	}
}