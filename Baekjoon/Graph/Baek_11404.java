package Graph;

import java.util.*;
import java.io.*;

public class Baek_11404{
	static class Bus{
		int next,cost;
		public Bus(int next,int cost) {
			this.next=next;
			this.cost=cost;
		}
	}
	
	static int n,m;
	static int[][]graph;
	static final int INF=987654321;
	
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(bf.readLine());
		m=Integer.parseInt(bf.readLine());
		
		graph=new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				graph[i][j]=INF;
				if(i==j)
					graph[i][j]=0;
			}
		}
		
		
		for(int i=0;i<m;i++) {
			StringTokenizer stk=new StringTokenizer(bf.readLine());
			int s=Integer.parseInt(stk.nextToken());
			int e=Integer.parseInt(stk.nextToken());
			int cost=Integer.parseInt(stk.nextToken());
			
			graph[s][e]=Math.min(graph[s][e], cost);
		}
		
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(graph[i][k]+graph[k][j]<graph[i][j])
						graph[i][j]=graph[i][k]+graph[k][j];
				}
			}
		}
		
		StringBuilder sb=new StringBuilder();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(graph[i][j]==INF)
					graph[i][j]=0;

				sb.append(graph[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
