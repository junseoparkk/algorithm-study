import java.util.*;
import java.io.*;

public class Baek_2533{
	static class Node{
		int n;
		Node next;
		public Node(int n,Node next) {
			this.n=n;
			this.next=next;
		}
	}
	
	static int N;
	static Node tree[];
	static boolean visited[];
	static int dp[][];
	
	public static void DFS(int x) {
		visited[x]=true;
		dp[x][0]=0;
		dp[x][1]=1;
		
		for(Node node=tree[x];node!=null;node=node.next) {
			if(!visited[node.n]) {
				DFS(node.n);
				dp[x][0]+=dp[node.n][1];
				dp[x][1]+=Math.min(dp[node.n][0], dp[node.n][1]);
			}
			
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		
		tree=new Node[N+1];
		visited=new boolean[N+1];
		dp=new int[N+1][2];
		
		for(int i=1;i<N;i++) {
			StringTokenizer stk=new StringTokenizer(bf.readLine());
			int s=Integer.parseInt(stk.nextToken());
			int e=Integer.parseInt(stk.nextToken());
			
			tree[s]=new Node(e,tree[s]);
			tree[e]=new Node(s,tree[e]);
		}
		
		DFS(1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}
}