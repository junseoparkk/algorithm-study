import java.util.*;
import java.io.*;

public class Baek_2178{
	static int[][] maze;
	static boolean[][] visited;
	static int[][] cnt;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int N,M;
	
	public static void bfs(int x,int y) {
		Queue<int[]>q=new LinkedList<>();
		q.add(new int[] {x,y});
		while(!q.isEmpty()) {
			int now[]=q.poll();
			int x1=now[0];
			int y1=now[1];
			for(int i=0;i<4;i++) {
				int xx=x1+dx[i];
				int yy=y1+dy[i];
				if(xx>=0&&xx<N&&yy>=0&&yy<M&&maze[xx][yy]==1&&!visited[xx][yy]) {
					visited[xx][yy]=true;
					q.offer(new int[] {xx,yy});
					cnt[xx][yy]=cnt[x1][y1]+1;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk=new StringTokenizer(bf.readLine()," ");
		N=Integer.parseInt(stk.nextToken());
		M=Integer.parseInt(stk.nextToken());
		
		maze=new int[N][M];
		visited=new boolean[N][M];
		cnt=new int[N][M];
		
		for(int i=0;i<N;i++) {
			String str=bf.readLine();
			for(int j=0;j<M;j++) {
				maze[i][j]=str.charAt(j)-'0';
			}
		}
		
		bfs(0,0);
		
		System.out.print(cnt[N-1][M-1]+1);
	}
}
