package Backtracking;
import java.util.*;

public class Baek_2023{
	static int N;
	
	//n:숫자, v:자릿수
	public static void dfs(int n,int v) {
		if(v==N) {
			if(isPrime(n))
				System.out.println(n);
			return;
		}
		for(int i=1;i<=9;i++) {
			if(i%2==0) continue;
			if(isPrime(n*10+i)) {
				dfs(n*10+i,v+1);
			}
		}
	}
	
	public static boolean isPrime(int n) {
		for(int i=2;i<=n/2;i++) {
			if(n%i==0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		
		dfs(2,1);
		dfs(3,1);
		dfs(5,1);
		dfs(7,1);
	}
}