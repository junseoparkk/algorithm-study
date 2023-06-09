import java.util.*;
import java.io.*;

public class Baek_1018{
	static boolean[][] chess;	//true:W, false:B
	static int min=64;
	
	public static void createChess(int x,int y) {
		int maxrow=x+8;
		int maxcol=y+8;
		int cnt=0;
		
		boolean firstColor=chess[x][y];
		
		for(int i=x;i<maxrow;i++) {
			for(int j=y;j<maxcol;j++) {
				if(chess[i][j]!=firstColor)
					cnt++;
				firstColor=!firstColor;
			}
			firstColor=!firstColor;
		}
		cnt=Math.min(cnt,64-cnt);
		min=Math.min(min, cnt);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk=new StringTokenizer(bf.readLine());
		int N=Integer.parseInt(stk.nextToken());
		int M=Integer.parseInt(stk.nextToken());
		
		chess=new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			String str=bf.readLine();
			for(int j=0;j<M;j++) {
				if(str.charAt(j)=='W')
					chess[i][j]=true;
				else
					chess[i][j]=false;
			}
		}
		
		for(int i=0;i<N-7;i++) {
			for(int j=0;j<M-7;j++)
				createChess(i,j);
		}
		System.out.print(min);
	}
}