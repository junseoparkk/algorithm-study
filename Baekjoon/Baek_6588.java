import java.util.*;
import java.io.*;

public class Baek_6588{
	static final int MAX=1000001;
	static boolean[] prime=new boolean[MAX];
	
	public static void isPrime() {
		prime[0]=prime[1]=true;
		for(int i=2;i<prime.length;i++) {
			if(!prime[i]) {
				for(int j=i+i;j<prime.length;j+=i)
					prime[j]=true;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		isPrime();
		
		while(true) {
			boolean flag=false;
			int n=Integer.parseInt(bf.readLine());
			if(n==0) break;
			
			for(int i=2;i<=n/2;i++) {
				if(!prime[i] && !prime[n-i]) {
					System.out.println(n+" = "+i+" + "+(n-i));
					flag=true;
					break;
				}
			}
			
			if(!flag) System.out.println("Goldbach's conjecture is wrong.");
		}
		
	}
}