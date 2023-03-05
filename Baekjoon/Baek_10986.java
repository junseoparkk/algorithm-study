import java.util.*;

public class Baek_10986{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		long[] S=new long[N+1];
		long[] C=new long[M];
		long answer=0;
		
		for(int i=1;i<N+1;i++)
			S[i]=S[i-1]+sc.nextInt();
		
		for(int i=1;i<N+1;i++) {
			int r=(int)(S[i] % M);
			if(r==0) answer++;
			C[r]++;
		}
		
		for(int i=0;i<M;i++) {
			if(C[i]>1)
				answer=answer+(C[i]*(C[i]-1)/2);
		}
		System.out.print(answer);
	}
}