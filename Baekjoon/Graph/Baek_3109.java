package Graph;

import java.util.*;
import java.io.*;

public class Baek_3109 {
	static int R,C;
	static char[][]map;
	static boolean[][]visited;
	
	public static boolean isPossible(int x,int y) {
		visited[x][y]=true;
		
		//원웅이 빵집 도착
		if(y==C-1) return true;
		
		//오른쪽 위
		if(x>0 && map[x-1][y+1]=='.' && !visited[x-1][y+1]) {
			if(isPossible(x-1,y+1))
				return true;
		}
		
		//오른쪽
		if(map[x][y+1]=='.' && !visited[x][y+1]) {
			if(isPossible(x,y+1))
				return true;
		}
		
		//오른쪽 아래
		if(x+1<R && map[x+1][y+1]=='.' && !visited[x+1][y+1]) {
			if(isPossible(x+1,y+1))
				return true;
		}
		
		return false;
		
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk=new StringTokenizer(bf.readLine());
		
		R=Integer.parseInt(stk.nextToken());
		C=Integer.parseInt(stk.nextToken());
		
		map=new char[R][C];
		visited=new boolean[R][C];
		int result=0;
		
		for(int i=0;i<R;i++) {
			String str=bf.readLine();
			for(int j=0;j<C;j++) {
				map[i][j]=str.charAt(j);
			}
		}
		
		for(int i=0;i<R;i++) {
			if(isPossible(i,0))
				result++;
		}
		
		System.out.println(result);
	}
}
