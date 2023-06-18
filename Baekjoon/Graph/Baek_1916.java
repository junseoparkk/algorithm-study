package Graph;

import java.util.*;
import java.io.*;

public class Baek_1916{
	static class Bus implements Comparable<Bus>{
		int vertex,cost;
		public Bus(int vertex,int cost) {
			this.vertex=vertex;
			this.cost=cost;
		}
		
		@Override
		public int compareTo(Bus o) {
			return this.cost-o.cost;
		}
	}
	
	static int N,M;
	static int INF=999999999;
	
	static List<Bus>info[];
	static boolean visited[];
	static int dist[];
	
	private static void Dijkstra(int k) {
		PriorityQueue<Bus>q=new PriorityQueue<>();
		q.offer(new Bus(k,0));
		dist[k]=0;
		
		while(!q.isEmpty()) {
			Bus now=q.poll();
			int nowNum=now.vertex;
			if(visited[nowNum]) continue;
			visited[nowNum]=true;
			
			for(int i=0;i<info[nowNum].size();i++) {
				Bus tmp=info[nowNum].get(i);
				int next=tmp.vertex;
				int cost=tmp.cost;
				
				if(dist[next]>dist[nowNum]+cost) {
					dist[next]=dist[nowNum]+cost;
					q.offer(new Bus(next,dist[next]));
				}
			}
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N=Integer.parseInt(bf.readLine());
		M=Integer.parseInt(bf.readLine());
		
		info=new ArrayList[N+1];
		visited=new boolean[N+1];
		dist=new int[N+1];
		
		for(int i=1;i<=N;i++) {
			info[i]=new ArrayList<Bus>();
			dist[i]=INF;
		}
		
		for(int i=0;i<M;i++) {
			stk=new StringTokenizer(bf.readLine());
			int s=Integer.parseInt(stk.nextToken());
			int e=Integer.parseInt(stk.nextToken());
			int c=Integer.parseInt(stk.nextToken());
			
			info[s].add(new Bus(e,c));
		}
		
		stk=new StringTokenizer(bf.readLine());
		int start=Integer.parseInt(stk.nextToken());
		int end=Integer.parseInt(stk.nextToken());
		
		Dijkstra(start);
		
		System.out.print(dist[end]);
	}
}
