package Graph;
import java.util.*;
import java.io.*;

class Rotate{
	int x;
	int y;
	int day;
	
	public Rotate(int x,int y,int day) {
		this.x=x;
		this.y=y;
		this.day=day;
	}
}

public class Baek_7576{
	static int M,N;
	static int[][] tomato;
	static int day=0;
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	static 	Queue<Rotate>q=new LinkedList<>();
	
	public static void bfs() {
		while(!q.isEmpty()) {
			Rotate r=q.poll();
			int nowx=r.x;
			int nowy=r.y;
			int nowd=r.day+1;
			
			for(int i=0;i<4;i++) {
				int newx=nowx+dx[i];
				int newy=nowy+dy[i];
				if(newx>=0 && newx<N && newy>=0 && newy<M) {
					day=nowd;
					if(tomato[newx][newy]==0) {
						q.offer(new Rotate(newx,newy,day));
						tomato[newx][newy]=1;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk=new StringTokenizer(bf.readLine());
		M=Integer.parseInt(stk.nextToken());	//가로 칸
		N=Integer.parseInt(stk.nextToken());	//세로 칸
		
		tomato=new int[N][M];
		
		for(int i=0;i<N;i++) {
			stk=new StringTokenizer(bf.readLine()," ");
			for(int j=0;j<M;j++) {
				tomato[i][j]=Integer.parseInt(stk.nextToken());
				if(tomato[i][j]==1)
					q.offer(new Rotate(i,j,0));
			}
		}
		bfs();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++)
				if(tomato[i][j]==0)
					day=-1;
		}
		
		if(day==-1) System.out.print(day);
		else System.out.print(day-1);
	}
}