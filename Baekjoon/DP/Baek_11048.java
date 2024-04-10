import java.lang.Math;
import java.util.Scanner;

public class Baek_11048 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		
		int max=0;
		int[][] maze=new int[N+1][M+1];
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				maze[i][j]=sc.nextInt();
				max=Math.max(maze[i][j-1], Math.max(maze[i-1][j],maze[i-1][j-1]));
				maze[i][j]+=max;
				
			}
		}
		System.out.println(maze[N][M]);
	}
}