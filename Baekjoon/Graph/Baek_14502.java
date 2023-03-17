import java.util.*;
import java.io.*;

public class Baek_14502{
	static int N,M;
	static int map[][];
	static int dx[]= {0,1,0,-1};
	static int dy[]= {-1,0,1,0};
	static int max=Integer.MIN_VALUE;
	
	static class Node{
		int x;
		int y;
		public Node(int x,int y) {
			this.x=x;
			this.y=y;
		}
	}
	
	public static void DFS(int wall) {
		if(wall==3) {
			BFS();
			return;
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					map[i][j]=1;
					DFS(wall+1);
					map[i][j]=0;
				}
			}
		}
	}
	
	public static void BFS() {
		Queue<Node>q=new LinkedList<Node>();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==2)
					q.add(new Node(i,j));
			}
		}
		
		int[][] newmap=new int[N][M];
		
		for(int i=0;i<N;i++)
			newmap[i]=map[i].clone();
		
		while(!q.isEmpty()) {
			Node now=q.poll();
			int x=now.x;
			int y=now.y;
			for(int k=0;k<4;k++) {
				int nx=x+dx[k];
				int ny=y+dy[k];
				if(0<=nx && nx<N && 0<=ny && ny<M) {
					if(newmap[nx][ny]==0) {
						newmap[nx][ny]=2;
						q.add(new Node(nx,ny));
					}
				}
			}
		}
		cntSafe(newmap);
	}
	
	public static void cntSafe(int[][] newmap) {
		int safe=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(newmap[i][j]==0)
					safe++;
			}
		}
		if(max<safe) 
			max=safe;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk=new StringTokenizer(bf.readLine());
		
		N=Integer.parseInt(stk.nextToken());
		M=Integer.parseInt(stk.nextToken());
		
		map=new int[N][M];
		
		for(int i=0;i<N;i++) {
			stk=new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++)
				map[i][j]=Integer.parseInt(stk.nextToken());
		}
		
		DFS(0);
		
		System.out.print(max);
	}
}