import java.util.*;
import java.io.*;

public class Baek_7562{
	//좌표값
	static class Location{
		int x;
		int y;
		int cnt;
		
		public Location(int x,int y) {
			this.x=x;
			this.y=y;
		}
		
		public Location(int x,int y,int cnt) {
			this.x=x;
			this.y=y;
			this.cnt=cnt;
		}
	}
	
	static int L;
	static int[][]map;
	static int[]dx = {1,1,2,2,-1,-1,-2,-2};
	static int[]dy = {2,-2,-1,1,-2,2,1,-1};
	
	public static int BFS(Location start,Location goal) {
		Queue<Location>q=new LinkedList<>();
		boolean[][]visited=new boolean[L][L];

		q.add(start);
		while(!q.isEmpty()) {
			Location now=q.poll();
			
			if(now.x==goal.x&&now.y==goal.y)
				return now.cnt;
			
			int x=now.x;
			int y=now.y;
			
			for(int i=0;i<8;i++) {
				int xx=x+dx[i];
				int yy=y+dy[i];
				if(0<=xx && xx<L && 0<=yy && yy<L && !visited[xx][yy]) {
					q.add(new Location(xx,yy,now.cnt+1));
					visited[xx][yy]=true;
				}
				else continue;
			}
		}
		return -1;
	}
	
	public static void solve(int L,int nx,int ny,int x,int y) {
		int min=Integer.MAX_VALUE;
		map=new int[L][L];
		
		Location start=new Location(nx,ny);
		Location goal=new Location(x,y);
		
		System.out.println(BFS(start,goal));
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(bf.readLine());
		
		for(int i=0;i<T;i++) {
			L=Integer.parseInt(bf.readLine());
			StringTokenizer stk=new StringTokenizer(bf.readLine());
			int nx=Integer.parseInt(stk.nextToken());
			int ny=Integer.parseInt(stk.nextToken());
			
			stk=new StringTokenizer(bf.readLine());
			int x=Integer.parseInt(stk.nextToken());
			int y=Integer.parseInt(stk.nextToken());
			
			solve(L,nx,ny,x,y);
		}
		
	}
}