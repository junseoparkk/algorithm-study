package Graph;

import java.util.*;
import java.io.*;

public class Baek_1976{
	static int N,M;
	static int[][]map;
	static int[]parent;
	static int[]route;
	
	private static void union(int a,int b) {
		a=find(a);
		b=find(b);
		if(a!=b)
			parent[b]=a;
	}
	
	private static int find(int a) {
		if(parent[a]==a) return a;
		else return parent[a]=find(parent[a]);
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N=Integer.parseInt(bf.readLine());
		M=Integer.parseInt(bf.readLine());
		
		map=new int[N+1][N+1];
		parent=new int[N+1];
		route=new int[M+1];
		
		for(int i=0;i<=N;i++)
			parent[i]=i;
		
		for(int i=1;i<=N;i++) {
			stk=new StringTokenizer(bf.readLine());
			for(int j=1;j<=N;j++) {
				map[i][j]=Integer.parseInt(stk.nextToken());
				if(map[i][j]==1) union(i,j);
			}
		}
		
		stk=new StringTokenizer(bf.readLine());
		for(int i=1;i<=M;i++)
			route[i]=Integer.parseInt(stk.nextToken());
		
		int idx=find(route[1]);
		for(int i=2;i<route.length;i++) {
			if(find(route[i])!=idx) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
		
	}
}
