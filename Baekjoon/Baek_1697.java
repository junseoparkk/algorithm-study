import java.util.*;

public class Baek_1697{
	static int N,K;
	static int[] visited;
	static final int MAX = 100000;
	
	public static int bfs(int x) {
		Queue<Integer>q=new LinkedList<>();
		q.add(x);
		int idx=x;
		int n=0;
		visited[idx]=1;
		
		while(!q.isEmpty()) {
			n=q.poll();
			if(n==K) return visited[n]-1;
			if(n-1>=0 && visited[n-1]==0) {
				visited[n-1]=visited[n]+1;
				q.add(n-1);
			}
			if(n+1<=MAX && visited[n+1]==0) {
				visited[n+1]=visited[n]+1;
				q.add(n+1);
			}
			if(n*2<=MAX && visited[n*2]==0) {
				visited[n*2]=visited[n]+1;
				q.add(n*2);
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		K=sc.nextInt();
		
		visited=new int[MAX+1];
		
		System.out.print(bfs(N));
	}
}