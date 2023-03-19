import java.util.*;
import java.io.*;

public class Baek_24445{
	static int N,M,R;
	static ArrayList<Integer>arr[];
	static boolean visited[];
	static int idx=0;
	static int result[];
	
	public static void BFS(int v) {
		Queue<Integer>q=new LinkedList<>();
		visited[v]=true;
		result[v]=++idx;
		q.add(v);
		
		while(!q.isEmpty()) {
			int now=q.poll();
			for(int i:arr[now]) {
				if(!visited[i]) {
					visited[i]=true;
					q.add(i);
					result[i]=++idx;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk=new StringTokenizer(bf.readLine());
		
		N=Integer.parseInt(stk.nextToken());
		M=Integer.parseInt(stk.nextToken());
		R=Integer.parseInt(stk.nextToken());
		
		arr=new ArrayList[N+1];
		visited=new boolean[N+1];
		result=new int[N+1];
		
		for(int i=1;i<=N;i++)
			arr[i]=new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			stk=new StringTokenizer(bf.readLine());
			int e=Integer.parseInt(stk.nextToken());
			int s=Integer.parseInt(stk.nextToken());
			
			arr[e].add(s);
			arr[s].add(e);
		}
		
		for(int i=1;i<=N;i++)
			Collections.sort(arr[i],Collections.reverseOrder());
		
		BFS(R);
		
		for(int i=1;i<=N;i++)
			System.out.println(result[i]);
	}
}