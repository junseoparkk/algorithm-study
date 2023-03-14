import java.util.*;
import java.io.*;

public class Baek_14889{
	static int N;
	static int[][] stat;
	static boolean[] visited;
	static int result=Integer.MAX_VALUE;
	
	//cnt: 팀원 수
	public static void dfs(int depth,int cnt) {
		if(cnt==N/2) {
			find();
			return;
		}
		
		for(int i=depth;i<N;i++) {
			if(!visited[i]) {
				visited[i]=true;
				dfs(i+1,cnt+1);
				visited[i]=false;
			}
		}
	}
	
	public static void find() {
		int start=0;
		int link=0;
		
		for(int i=0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				if(visited[i] && visited[j]) {
					start+=stat[i][j];
					start+=stat[j][i];
				}
				else if(!visited[i] && !visited[j]) {
					link+=stat[i][j];
					link+=stat[j][i];
				}
			}
		}
		
		int num=Math.abs(start-link);
		
		if(num==0) {
			System.out.print(num);
			System.exit(0);
		}
		
		result=Math.min(num,result);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		
		stat=new int[N][N];
		visited=new boolean[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer stk=new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++) {
				stat[i][j]=Integer.parseInt(stk.nextToken());
			}
		}
		
		dfs(0,0);
		System.out.print(result);
		
	}
}