package Graph;

import java.util.*;
import java.io.*;

public class Baek_1504{
	static class Node implements Comparable<Node>{
		int end,weight;
		
		public Node(int end,int weight) {
			this.end=end;
			this.weight=weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
	}
	
	static int N,E;
	static final int INF=200000000;
	static boolean[] visited;
	static int[] dist;
	static List<Node>[] graph;
	
	private static int dijkstra(int start,int end) {
		Arrays.fill(dist,INF);
		Arrays.fill(visited, false);
		PriorityQueue<Node> q=new PriorityQueue<>();
		
		//자기 자신에 대한 초기화
		q.add(new Node(start,0));
		dist[start]=0;
		
		while(!q.isEmpty()) {
			Node now=q.poll();
			if(!visited[now.end]) {
				visited[now.end]=true;
				
				for(Node next:graph[now.end]) {
					if(!visited[next.end] && dist[next.end]>now.weight+next.weight) {
						//최소값으로 갱신
						dist[next.end]=now.weight+next.weight;
						q.add(new Node(next.end,dist[next.end]));
					}
				}
			}
		}
		return dist[end];
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk=new StringTokenizer(bf.readLine());
		
		N=Integer.parseInt(stk.nextToken());
		E=Integer.parseInt(stk.nextToken());
		
		graph=new ArrayList[N+1];
		visited=new boolean[N+1];
		dist=new int[N+1];
		
		for(int i=0;i<=N;i++) {
			graph[i]=new ArrayList<>();
			dist[i]=INF;
		}
		
		for(int i=0;i<E;i++) {
			stk=new StringTokenizer(bf.readLine());
			int u=Integer.parseInt(stk.nextToken());
			int v=Integer.parseInt(stk.nextToken());
			int w=Integer.parseInt(stk.nextToken());
			
			graph[u].add(new Node(v,w));
			graph[v].add(new Node(u,w));
		}
		
		stk=new StringTokenizer(bf.readLine());
		int v1=Integer.parseInt(stk.nextToken());
		int v2=Integer.parseInt(stk.nextToken());
		
		int result1=0;
		result1+=dijkstra(1,v1);
		result1+=dijkstra(v1,v2);
		result1+=dijkstra(v2,N);
		
		int result2=0;
		result2+=dijkstra(1,v2);
		result2+=dijkstra(v2,v1);
		result2+=dijkstra(v1,N);
		
		int result = (result1>=INF && result1>=INF) ? -1 :Math.min(result1, result2);
		
		System.out.print(result);
	}
}
