package Graph;

import java.io.*;
import java.util.*;

public class Baek_1043{
	static int N,M,T;
	static int[] knows;
	static int[] parent;
	static List<Integer>[]party;
	
	private static void union(int a,int b) {
		a=find(a);
		b=find(b);
		if(a!=b)
			parent[b]=a;
	}
	
	private static int find(int a) {
		if(parent[a]==a) return a;
		else return parent[a]=find(parent[a]);
	}
	
	public static void main(String[] args)throws IOException{
		//BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		Scanner sc=new Scanner(System.in);
		//StringTokenizer stk=new StringTokenizer(bf.readLine());
		
		int result=0;
		
		N=sc.nextInt();
		M=sc.nextInt();
		T=sc.nextInt();
		
		knows=new int[T];
		for(int i=0;i<T;i++) {
			knows[i]=sc.nextInt();
		}
		
		party=new ArrayList[M];
		for(int i=0;i<M;i++) {
			party[i]=new ArrayList<>();
			int size=sc.nextInt();
			for(int j=0;j<size;j++)
				party[i].add(sc.nextInt());
		}
		
		parent=new int[N+1];
		for(int i=1;i<=N;i++)
			parent[i]=i;
		
		for(int i=0;i<M;i++) {
			int first=party[i].get(0);
			for(int j=1;j<party[i].size();j++) {
				union(first,party[i].get(j));
			}
		}
		
		for(int i=0;i<M;i++) {
			boolean isPossible=true;
			int member=party[i].get(0);
			for(int j=0;j<knows.length;j++) {
				if(find(knows[j])==find(member)) {
					isPossible=false;
					break;
				}
			}
			if(isPossible) result++;
		}
		System.out.println(result);
	}
}