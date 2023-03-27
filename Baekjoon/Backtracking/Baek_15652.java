import java.util.*;
import java.io.*;

public class Baek_15652{
	static int N,M;
	static int[] num;
	static StringBuilder sb=new StringBuilder();
	
	public static void dfs(int n,int depth){
		if(depth==M) {
			for(int i=0;i<M;i++)
				sb.append(num[i]).append(' ');
			sb.append('\n');
			return;
		}

		for(int i=n;i<N;i++) {
			num[depth]=i+1;
			dfs(i,depth+1);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(stk.nextToken());
		M=Integer.parseInt(stk.nextToken());
		
		num=new int[M];
		
		dfs(0,0);
		System.out.println(sb);
	}
}