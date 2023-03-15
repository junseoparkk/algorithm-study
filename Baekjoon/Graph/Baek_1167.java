import java.util.*;

class Edge{
	int node;
	int dis;
	
	public Edge(int node,int dis) {
		this.node=node;
		this.dis=dis;
	}
}

public class Baek_1167{
	static ArrayList<Edge>tree[];
	static boolean visited[];
	static int distance[];
	
	public static void BFS(int index) {
		Queue<Integer>queue=new LinkedList<Integer>();
		queue.add(index);
		visited[index]=true;
		
		while(!queue.isEmpty()) {
			int now=queue.poll();
			for(Edge i:tree[now]) {
				int e=i.node;
				int v=i.dis;
				if(!visited[e]) {
					visited[e]=true;
					queue.add(e);
					distance[e]=distance[now]+v;
				}
			}
		}
	}
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		
		tree=new ArrayList[N+1];
		for(int i=1;i<=N;i++)
			tree[i]=new ArrayList<Edge>();
		
		for(int i=0;i<N;i++) {
			int S=sc.nextInt();
			while(true) {
				int E=sc.nextInt();
				if(E==-1) break;
				int V=sc.nextInt();
				tree[S].add(new Edge(E,V));
			}
		}
		distance=new int[N+1];
		visited=new boolean[N+1];
		
		BFS(1);
		int max=1;
		
		for(int i=2;i<=N;i++) {
			if(distance[max]<distance[i])
				max=i;
		}
		
		distance=new int[N+1];
		visited=new boolean[N+1];
		
		BFS(max);
		
		Arrays.sort(distance);
		System.out.print(distance[N]);
	}
}