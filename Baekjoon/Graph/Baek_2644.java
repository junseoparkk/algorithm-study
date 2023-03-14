package Graph;
import java.util.*;
import java.io.*;

public class Baek_2644{
	static int n,p1,p2,m,x,y;
	static int[][]map;
	static boolean[]visited;
	static boolean find;
	static int result=0;
	
	public static void dfs(int x,int p2,int cnt) {
		visited[x]=true;
		if(x==p2) {
			find=true;
			result=cnt;
			return;
		}
		
		//System.out.print(x+" ");
		for(int i=1;i<=n;i++) {
			if(map[x][i]==1 && !visited[i]) {
				visited[i]=true;
				dfs(i,p2,cnt+1);
				visited[i]=false;
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(bf.readLine());
		StringTokenizer stk=new StringTokenizer(bf.readLine());
		p1=Integer.parseInt(stk.nextToken());
		p2=Integer.parseInt(stk.nextToken());
		m=Integer.parseInt(bf.readLine());
		
		map=new int[n+1][n+1];
		visited=new boolean[n+1];
		
		for(int i=0;i<m;i++) {
			stk=new StringTokenizer(bf.readLine());
			x=Integer.parseInt(stk.nextToken());
			y=Integer.parseInt(stk.nextToken());
			
			map[x][y]=1;
			map[y][x]=1;
		}
		dfs(p1,p2,0);
		if(!find) result=-1;
		System.out.print(result);
	}
}
