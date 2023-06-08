package Graph;

import java.util.*;
import java.io.*;

public class Baek_2252{
	static int N,M;
	static int D[];
	static ArrayList<ArrayList<Integer>> list=new ArrayList<>();
	
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk=new StringTokenizer(bf.readLine());
		
		N=Integer.parseInt(stk.nextToken());
		M=Integer.parseInt(stk.nextToken());
		
		D=new int[N+1];
		
		for(int i=0;i<=N;i++)
			list.add(new ArrayList<>());
		
		for(int i=0;i<M;i++) {
			stk=new StringTokenizer(bf.readLine());
			int s=Integer.parseInt(stk.nextToken());
			int e=Integer.parseInt(stk.nextToken());
			
			list.get(s).add(e);
			D[e]++;
		}
		
		Queue<Integer>q=new ArrayDeque<>();
		for(int i=1;i<=N;i++) {
			if(D[i]==0)
				q.offer(i);
		}
		
		while(!q.isEmpty()) {
			int now=q.poll();
			System.out.print(now+" ");
			for(int next:list.get(now)) {
				D[next]--;
				if(D[next]==0)
					q.offer(next);
			}
		}
		
	}
}
