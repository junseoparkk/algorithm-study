import java.io.*;
import java.util.StringTokenizer;
import java.lang.Math;
import java.util.Scanner;

public class Baek_1937{
	static int N;
	static int[][] map;
	static int[][] dp;
	static int[] X = {-1,0,1,0};
	static int[] Y = {0,-1,0,1};
	
	public static int dfs(int x,int y) {
		if(dp[x][y]!=0) return dp[x][y];
		
		dp[x][y]=1;
		for(int i=0;i<4;i++) {
			int nx=x+X[i];
			int ny=y+Y[i];
			if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
			if(map[x][y]<map[nx][ny]) {
				dp[x][y]=Math.max(dp[x][y], dfs(nx,ny)+1);
				dfs(nx,ny);
			}
		}
		return dp[x][y];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		Scanner sc=new Scanner(System.in);
		StringTokenizer stk;
		
		int result=0;
		
		N=Integer.parseInt(bf.readLine());
		
		map = new int[N][N];
		dp = new int[N][N];
		
		for(int i=0;i<N;i++) {
			stk=new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++)
				map[i][j]=Integer.parseInt(stk.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++)
				result=Math.max(result, dfs(i,j));
		}
		
		System.out.print(result);
	}
}