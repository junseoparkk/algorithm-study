package Graph;

import java.util.*;
import java.io.*;

public class Baek_10026{
	static int N;
	static char[][]picture;
	static boolean[][]visited=new boolean[N][N];
	
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	
	private static int normal() {
		int result=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j] && picture[i][j]=='R') { 
					BFS(i,j,'R');
					result++;
				}
				else if(!visited[i][j] && picture[i][j]=='G') {
					BFS(i,j,'G');
					result++;
				}
				else if(!visited[i][j] && picture[i][j]=='B') {
					BFS(i,j,'B');
					result++;
				}
			}
		}
		return result;
		
	}
	
	private static int abnormal() {
		int result=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(picture[i][j]=='G')
					picture[i][j]='R';
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j] && picture[i][j]=='R') { 
					BFS(i,j,'R');
					result++;
				}
				else if(!visited[i][j] && picture[i][j]=='B') {
					BFS(i,j,'B');
					result++;
				}
			}
		}
		return result;
	}
	
	private static void BFS(int x,int y,char c) {
		Queue<int[]>q=new ArrayDeque<>();
		q.offer(new int[] {x,y});
		visited[x][y]=true;
		
		while(!q.isEmpty()) {
			int[] now=q.poll();
			int nx=now[0];
			int ny=now[1];
			for(int i=0;i<4;i++) {
				int xx=nx+dx[i];
				int yy=ny+dy[i];
				if(xx>=0 && xx<N && yy>=0 && yy<N && !visited[xx][yy] && picture[xx][yy]==c) {
					q.offer(new int[] {xx,yy});
					visited[xx][yy]=true;
				}
			}
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		
		picture=new char[N][N];
		visited=new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			String str=bf.readLine();
			for(int j=0;j<N;j++) {
				picture[i][j]=str.charAt(j);
			}
		}
		
		int r1=normal();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++)
				visited[i][j]=false;
		}
		int r2=abnormal();
		
		System.out.println(r1+" "+r2);
	}
}
