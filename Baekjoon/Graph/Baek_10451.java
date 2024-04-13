import java.util.*;
import java.io.*;

public class Baek_10451 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	static int[][] map;
	static boolean[][] visited;
	
	static class Point{
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static void BFS(int x,int y, int N) {
		int result = 0;
		Queue<Point>q = new ArrayDeque<>();
		q.offer(new Point(x,y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			for(int i=1;i<=N;i++) {
				if(map[now.y][i]==1 && !visited[now.y][i]) {
					q.offer(new Point(now.y,i));
					visited[now.y][i] = true;
				}
			}
		}
		
	}
	
	private static void solve() throws IOException {
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer stk = new StringTokenizer(bf.readLine());
		
		int cnt = 0;
		
		map = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			int j = Integer.parseInt(stk.nextToken());
			map[i][j] = 1;
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(!visited[i][j] && map[i][j]==1) {
					cnt++;
					BFS(i,j,N);
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(bf.readLine());
		
		for(int i=0;i<T;i++)
			solve();
	}
}
