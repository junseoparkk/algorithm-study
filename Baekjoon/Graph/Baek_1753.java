package Graph;

import java.util.*;
import java.io.*;

public class Baek_1753{
	static class Node{
		int v;
		int cost;
		public Node(int v,int cost) {
			this.v=v;
			this.cost=cost;
		}
	}
	
	static int V,E,K;
	static ArrayList<Node>[]graph;
	static boolean[]visited;
	static int[]dist;
	
	public static void dijkstra(int k) {
		PriorityQueue<Node>q=new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
		q.add(new Node(k,0));
		dist[k]=0;
		
		while(!q.isEmpty()) {
			Node now=q.poll();
			if(!visited[now.v])
				visited[now.v]=true;
			
			for(Node next:graph[now.v]) {
				if(!visited[next.v]&&dist[next.v]>now.cost+next.cost) {
					dist[next.v]=now.cost+next.cost;
					q.add(new Node(next.v,dist[next.v]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk=new StringTokenizer(bf.readLine());
		
		V=Integer.parseInt(stk.nextToken());
		E=Integer.parseInt(stk.nextToken());
		K=Integer.parseInt(bf.readLine());
		
		graph=new ArrayList[V+1];
		dist=new int[V+1];
		visited=new boolean[V+1];
		
		for(int i=1;i<=V;i++) {
			graph[i]=new ArrayList<>();
			dist[i]=Integer.MAX_VALUE;
		}
		
		for(int i=0;i<E;i++) {
			stk=new StringTokenizer(bf.readLine());
			int u=Integer.parseInt(stk.nextToken());
			int v=Integer.parseInt(stk.nextToken());
			int w=Integer.parseInt(stk.nextToken());
			
			graph[u].add(new Node(v,w));
		}
		
		dijkstra(K);
		
		for(int i=1;i<dist.length;i++) {
			if(dist[i]==Integer.MAX_VALUE)
				System.out.println("INF");
			else System.out.println(dist[i]);
		}
	}
}
