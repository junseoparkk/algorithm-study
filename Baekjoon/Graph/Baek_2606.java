package Graph;
import java.util.Scanner;

public class Baek_2606 {
	static int[][] map;
	static boolean[] visited;
	static int total=0;
	static int com, connect;
	
	public static void dfs(int x) {
		visited[x]=true;
		
		for(int i=1;i<=com;i++) {
			if(map[x][i]==1 && !visited[i]) {
				total++;
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		com=sc.nextInt();
		connect=sc.nextInt();
		
		map=new int[101][101];
		visited=new boolean[101];
		
		for(int i=0;i<connect;i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			
			map[x][y]=1;
			map[y][x]=1;
		}
		dfs(1);
		System.out.print(total);
	}

}
