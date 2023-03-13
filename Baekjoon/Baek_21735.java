import java.util.Scanner;

public class Baek_21735 {
	static int[] snow=new int[101];
	static int N,M;
	
	public static int bruteforce(int idx,int time,int size) {
		if(time>M) return 0;
		if(time==M) return size;
		return Math.max(bruteforce(idx+1,time+1,size+snow[idx+1]),bruteforce(idx+2,time+1,size/2+snow[idx+2]));
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		
		for(int i=1;i<N+1;i++)
			snow[i]=sc.nextInt();
		System.out.print(bruteforce(0,0,1));
	}

}
