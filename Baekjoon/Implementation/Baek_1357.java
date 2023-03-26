import java.util.*;
import java.io.*;

public class Baek_1357{
	public static int rev(int x) {
		int result=0;
		while(x>0) {
			result=result*10+x%10;
			x/=10;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		int y=sc.nextInt();
		System.out.print(rev(rev(x)+rev(y)));
	}
}