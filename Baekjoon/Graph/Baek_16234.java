package Graph;

import java.util.*;
import java.io.*;

public class Baek_16234{
	static int N,L,R;
	static int map[][];
	static boolean visited[][];
	
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	
	static ArrayList<Point>list;
	
	static class Point{
		int x,y;
		Point(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	
	private static void resetPeople(int sum) {
		int avg=sum/list.size();
		for(Point p:list) {
			map[p.x][p.y]=avg;
		}
	}
	
	private static int solve() {
		int result=0;
		
		while(true) {
			boolean isMoved=false;
			visited=new boolean[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!visited[i][j]) {
						int sum=BFS(i,j);
						if(list.size()>1) {
							resetPeople(sum);
							isMoved=true;
						}
					}
				}
			}
			if(!isMoved) return result;
			result++;
		}
	}
	
	private static int BFS(int x,int y) {
		Queue<Point>q=new ArrayDeque<>();
		list=new ArrayList<Point>();
		
		q.offer(new Point(x,y));
		list.add(new Point(x,y));
		visited[x][y]=true;
		
		int sum=map[x][y];
		while(!q.isEmpty()) {
			Point now=q.poll();
			for(int i=0;i<4;i++) {
				int nx=now.x+dx[i];
				int ny=now.y+dy[i];
				
				if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny]) {
					int diff=Math.abs(map[nx][ny]-map[now.x][now.y]);
					if(L<=diff && diff<=R) {
						q.offer(new Point(nx,ny));
						list.add(new Point(nx,ny));
						sum+=map[nx][ny];
						visited[nx][ny]=true;
					}
				}
			}
		}
		return sum;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk=new StringTokenizer(bf.readLine());
		
		N=Integer.parseInt(stk.nextToken());
		L=Integer.parseInt(stk.nextToken());
		R=Integer.parseInt(stk.nextToken());
		
		map=new int[N][N];
		
		for(int i=0;i<N;i++) {
			stk=new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(stk.nextToken());
			}
		}
		
		System.out.println(solve());
	}
}
