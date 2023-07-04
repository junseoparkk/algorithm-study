package Graph;

import java.util.*;
import java.io.*;

public class Baek_3055{
	static int R,C;
	static char map[][];
	static boolean visited[][];
	
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	
	static int answer=Integer.MAX_VALUE;
	
	static Queue<Point>gq=new ArrayDeque<Point>();
	static Queue<Point>wq=new ArrayDeque<Point>();
	
	static class Point{
		int x,y,time;
		
		Point(int x,int y,int time){
			this.x=x;
			this.y=y;
			this.time=time;
		}
		
		Point(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	
	private static void BFS() {
		while(!gq.isEmpty()) {
			
			//물 퍼짐
			int size=wq.size();
			for(int i=0;i<size;i++) {
				Point wnow=wq.poll();
				int wx=wnow.x;
				int wy=wnow.y;

				for(int k=0;k<4;k++) {
					int nwx=wx+dx[k];
					int nwy=wy+dy[k];
					if(nwx>=0 && nwx<R && nwy>=0 && nwy<C && map[nwx][nwy]=='.') {
						map[nwx][nwy]='*';
						wq.offer(new Point(nwx,nwy));
					}
				}
			}
			
			//고슴도치 이동
			size=gq.size();
			for(int i=0;i<size;i++) {
				Point now=gq.poll();
				int x=now.x;
				int y=now.y;
				int t=now.time;
				
				for(int k=0;k<4;k++) {
					int nx=x+dx[k];
					int ny=y+dy[k];
					if(nx>=0 && nx<R && ny>=0 && ny<C) {
						if(map[nx][ny]=='D') {
							answer=Math.min(answer, t+1);
							return;
						}
						else if(map[nx][ny]=='.') {
							map[nx][ny]='S';
							gq.offer(new Point(nx,ny,t+1));
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk=new StringTokenizer(bf.readLine());
		
		R=Integer.parseInt(stk.nextToken());
		C=Integer.parseInt(stk.nextToken());
		
		map=new char[R][C];
		visited=new boolean[R][C];
		
		for(int i=0;i<R;i++) {
			String str=bf.readLine();
			for(int j=0;j<C;j++) {
				map[i][j]=str.charAt(j);
				if(map[i][j]=='S')
					gq.offer(new Point(i,j,0));
				else if(map[i][j]=='*')
					wq.offer(new Point(i,j));
			}
		}
		
		
		BFS();
		System.out.println(answer==Integer.MAX_VALUE?"KAKTUS":answer);
	}
}
