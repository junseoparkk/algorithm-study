package Graph;

import java.util.*;
import java.io.*;

public class Baek_1926{
	static int N,M;
	
	static int[][] map;
	static boolean[][] visited;
	
	static int max=0;
	static int result=0;
	
	static int[]dx= {0,1,0,-1};
	static int[]dy= {1,0,-1,0};
	
	private static int BFS(int x,int y) {
		int area=0;
		Queue<int[]>q=new ArrayDeque<>();
		q.add(new int[] {x,y});
		visited[x][y]=true;
		area++;
		
		while(!q.isEmpty()) {
			int[] now=q.poll();
			int xx=now[0];
			int yy=now[1];
			
			for(int i=0;i<4;i++) {
				int nx=xx+dx[i];
				int ny=yy+dy[i];
				
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					if(!visited[nx][ny] && map[nx][ny]==1) {
						q.offer(new int[] {nx,ny});
						visited[nx][ny]=true;
						area++;
					}
				}
				
			}
		}
		return area;
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk=new StringTokenizer(bf.readLine());
		
		N=Integer.parseInt(stk.nextToken());
		M=Integer.parseInt(stk.nextToken());
		
		map=new int[N][M];
		visited=new boolean[N][M];
		int area=0;
		
		for(int i=0;i<N;i++) {
			stk=new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(stk.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				area=0;
				if(!visited[i][j] && map[i][j]==1) {
					max=Math.max(BFS(i,j), max);
					result++;
				}
			}
		}
		System.out.print(result+"\n"+max);	
	}
}