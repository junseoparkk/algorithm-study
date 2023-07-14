import java.util.*;
import java.io.*;

public class Baek_15686{
	static class Point{
		int x,y;
		public Point(int x,int y) {
			this.x=x;
			this.y=y;
		}
	}
	
	static int N,M;
	static int map[][];
	static boolean isOpen[];
	
	static List<Point>house;
	static List<Point>chicken;
	
	static int result;
	
	private static void DFS(int start,int cnt) {
		if(cnt==M) {
			int ans=0;
			for(int i=0;i<house.size();i++) {
				int tmp=Integer.MAX_VALUE;
				for(int j=0;j<chicken.size();j++) {
					if(isOpen[j]) {
						int dist=Math.abs(house.get(i).x-chicken.get(j).x)
								+Math.abs(house.get(i).y-chicken.get(j).y);
						tmp=Math.min(tmp, dist);
					}
				}
				ans+=tmp;
			}
			result=Math.min(result,ans);
			return;
		}
		
		for(int i=start;i<chicken.size();i++) {
			isOpen[i]=true;
			DFS(i+1,cnt+1);
			isOpen[i]=false;
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk=new StringTokenizer(bf.readLine());
		
		N=Integer.parseInt(stk.nextToken());
		M=Integer.parseInt(stk.nextToken());
		
		map=new int[N][N];
		house=new ArrayList<>();
		chicken=new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			stk=new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(stk.nextToken());
				if(map[i][j]==1)
					house.add(new Point(i,j));
				else if(map[i][j]==2)
					chicken.add(new Point(i,j));
			}
		}
		
		result=Integer.MAX_VALUE;
		isOpen=new boolean[chicken.size()];
		
		DFS(0,0);
		
		System.out.print(result);
	}
}
