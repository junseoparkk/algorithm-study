package Graph;

import java.util.*;
import java.io.*;

public class Baek_1854{
	static class Node implements Comparable<Node>{
		int v,cost;
		public Node(int v,int cost) {
			this.v=v;
			this.cost=cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
	}
	
	static int N,M,K;
	static final int INF=100000000;
	
	static List<Node>graph[];
	static PriorityQueue<Integer>dist[];
	
	private static void Dijkstra(int k) {
		PriorityQueue<Node>q=new PriorityQueue<>();
		q.offer(new Node(k,0));
		dist[1].add(0);
		
		while(!q.isEmpty()) {
			Node now=q.poll();
			for(int i=0;i<graph[now.v].size();i++) {
				Node tmp=graph[now.v].get(i);
				if(dist[tmp.v].size()<K) {
					dist[tmp.v].add(now.cost+tmp.cost);
					q.offer(new Node(tmp.v,now.cost+tmp.cost));
				}
				else if(dist[tmp.v].peek()>now.cost+tmp.cost) {
					dist[tmp.v].poll();
					dist[tmp.v].add(now.cost+tmp.cost);
					q.offer(new Node(tmp.v,now.cost+tmp.cost));
				}
			}
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk=new StringTokenizer(bf.readLine());
		
		N=Integer.parseInt(stk.nextToken());
		M=Integer.parseInt(stk.nextToken());
		K=Integer.parseInt(stk.nextToken());
		
		graph=new ArrayList[N+1];
		dist=new PriorityQueue[N+1];
		
		for(int i=1;i<=N;i++) {
			graph[i]=new ArrayList<>();
			dist[i]=new PriorityQueue<Integer>(K,Collections.reverseOrder());
		}
		
		for(int i=0;i<M;i++) {
			stk=new StringTokenizer(bf.readLine());
			int s=Integer.parseInt(stk.nextToken());
			int e=Integer.parseInt(stk.nextToken());
			int c=Integer.parseInt(stk.nextToken());
			
			graph[s].add(new Node(e,c));
		}
		
		Dijkstra(1);
		
		StringBuilder sb=new StringBuilder();
		
		for(int i=1;i<=N;i++) {
			if(dist[i].size()==K) sb.append(dist[i].peek()+"\n");
			else sb.append(-1+"\n");
		}
		System.out.print(sb.toString());
	}
}
