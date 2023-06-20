package Graph;

import java.util.*;
import java.io.*;

public class Baek_5014{
	static int F,S,G,U,D;
	static int arr[];
	
	private static String BFS(int start,int end) {
		Queue<Integer>q=new ArrayDeque<>();
		q.add(start);
		arr[start]=1;
		
		while(!q.isEmpty()) {
			int now=q.poll();
			if(now==end) {
				return String.valueOf(arr[now]-1);
			}
			
			if(now+U <= F) {
				if(arr[now+U] == 0) {
					arr[now+U] = arr[now]+1;
					q.add(now+U);
				}
			}
			
			if(now-D >= 1) {
				if(arr[now-D] == 0) {
					arr[now-D] = arr[now]+1;
					q.add(now-D);
				}
			}
		}
		
		return "use the stairs";
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk=new StringTokenizer(bf.readLine());
		
		F=Integer.parseInt(stk.nextToken());		
		S=Integer.parseInt(stk.nextToken());
		G=Integer.parseInt(stk.nextToken());
		U=Integer.parseInt(stk.nextToken());
		D=Integer.parseInt(stk.nextToken());
		
		arr=new int[F+1];
		
		System.out.println(BFS(S,G));
	}
}
