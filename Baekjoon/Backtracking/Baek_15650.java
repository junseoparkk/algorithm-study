package Backtracking;

import java.util.*;
import java.io.*;

public class Baek_15650 {
	static int N,M;
	static int[] num;
	static boolean[] visited;
	
	public static void dfs(int n,int depth) {
		if(depth==M) {
			for(int x:num)
				System.out.print(x+" ");
			System.out.println();
			return;
		}
		
		for(int i=n;i<N;i++) {
			if(!visited[i]) {
				visited[i]=true;
				num[depth]=i+1;
				dfs(i,depth+1);
				visited[i]=false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(stk.nextToken());
		M=Integer.parseInt(stk.nextToken());
		
		num=new int[M];
		visited=new boolean[N];
		
		dfs(0,0);
	}
}
