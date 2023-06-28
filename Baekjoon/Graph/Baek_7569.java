package Graph;

import java.io.*;
import java.util.*;

public class Baek_7569{
	
	static class Point{
		int x,y,z;
		
		Point(int z,int x,int y){
			this.z=z;
			this.x=x;
			this.y=y;
		}
	}
	
	static int N,M,H;
	
	static int[][][] map;
	static boolean[][][] visited;
	
	static int dx[]= {0,1,0,-1,0,0};
	static int dy[]= {1,0,-1,0,0,0};
	static int dz[]= {0,0,0,0,-1,1};
	
	static Queue<Point>q=new ArrayDeque<>();
	
	private static void BFS() {
		while(!q.isEmpty()) {
			Point now=q.poll();
			int z=now.z;
			int x=now.x;
			int y=now.y;
			
			for(int i=0;i<6;i++) {
				int nz=z+dz[i];
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				if(nz>=0 && nz<H && nx>=0 && nx<N && ny>=0 && ny<M) {
					if(map[nz][nx][ny]==0) {
						q.offer(new Point(nz,nx,ny));
						visited[nz][nx][ny]=true;
						map[nz][nx][ny]=map[z][x][y]+1;
					}
				}
			}
		}
	}
	
	private static int getResult() {
		boolean isAll=true;
		int max=Integer.MIN_VALUE;
		
		for(int k=0;k<H;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[k][i][j]==0) return -1;
					else max=Math.max(max, map[k][i][j]);
				}
			}
		}
		
		return max==1?0:max-1;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk=new StringTokenizer(bf.readLine());
		
		M=Integer.parseInt(stk.nextToken());
		N=Integer.parseInt(stk.nextToken());
		H=Integer.parseInt(stk.nextToken());
		
		map=new int[H][N][M];
		visited=new boolean[H][N][M];
		boolean firstCheck=true;
		
		for(int k=0;k<H;k++) {
			for(int i=0;i<N;i++) {
				stk=new StringTokenizer(bf.readLine());
				for(int j=0;j<M;j++) {
					map[k][i][j]=Integer.parseInt(stk.nextToken());
					if(map[k][i][j]==1) q.offer(new Point(k,i,j));
				}
			}
		}

		BFS();
		
		System.out.println(getResult());
	}
}
