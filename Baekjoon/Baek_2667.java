import java.util.*;
import java.io.*;

public class Baek_2667{
	static int N;
	static int[][]map;
	static boolean[][]visited;
	static int[]dx= {0,1,0,-1};
	static int[]dy= {-1,0,1,0};
	static int apartNum;
	static List<Integer>result=new ArrayList<>();
	
	public static void dfs(int x,int y) {
		visited[x][y]=true;
		apartNum++;
		
		for(int i=0;i<4;i++) {
			int xx=x+dx[i];
			int yy=y+dy[i];
			if(xx>=0 && xx<N && yy>=0 && yy<N) {
				if(!visited[xx][yy] && map[xx][yy]==1)
					dfs(xx,yy);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		
		map=new int[N][N];
		visited=new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			String str=bf.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]=str.charAt(j)-'0';
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					apartNum=0;
					dfs(i,j);
					result.add(apartNum);
				}
			}
		}
		
		Collections.sort(result);
		
		System.out.println(result.size());
		for(int x:result)
			System.out.println(x+" ");
	}
}