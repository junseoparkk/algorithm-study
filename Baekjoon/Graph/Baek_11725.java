import java.util.*;
import java.io.*;

public class Baek_11725{
	static int N;
	static int parent[];
	static ArrayList<Integer>arr[];
	static boolean visited[];
	
	public static void dfs(int v) {
		visited[v]=true;
		for(int x:arr[v]) {
			if(!visited[x]) {
				parent[x]=v;
				dfs(x);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		N=Integer.parseInt(bf.readLine());
		
		parent=new int[N+1];
		arr=new ArrayList[N+1];
		visited=new boolean[N+1];
		
		for(int i=1;i<=N;i++)
			arr[i]=new ArrayList<Integer>();
		for(int i=0;i<N-1;i++) {
			StringTokenizer stk=new StringTokenizer(bf.readLine());
			int s=Integer.parseInt(stk.nextToken());
			int e=Integer.parseInt(stk.nextToken());
			
			arr[s].add(e);
			arr[e].add(s);
		}
		for(int i=1;i<=N;i++)
			Collections.sort(arr[i]);
		
		dfs(1);
		for(int i=2;i<=N;i++)
			sb.append(parent[i]).append('\n');
		System.out.print(sb);
			
	}
}