import java.util.*;
import java.io.*;

public class Baek_1717{
	static int parent[];
	
	private static void union(int a,int b) {
		a=find(a);
		b=find(b);
		if(a!=b) parent[b]=a;
	}
	
	private static String same(int a,int b) {
		if(find(a)==find(b)) return "YES";
		else return "NO";
	}
	
	private static int find(int a) {
		if(parent[a]==a) return a;
		else return parent[a]=find(parent[a]);
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk=new StringTokenizer(bf.readLine());
		
		int n=Integer.parseInt(stk.nextToken());
		int m=Integer.parseInt(stk.nextToken());
		
		parent=new int[n+1];
		for(int i=1;i<=n;i++)
			parent[i]=i;
		
		for(int i=0;i<m;i++) {
			stk=new StringTokenizer(bf.readLine());
			int op=Integer.parseInt(stk.nextToken());
			int a=Integer.parseInt(stk.nextToken());
			int b=Integer.parseInt(stk.nextToken());
			
			if(op==0) union(a,b);
			else if(op==1) System.out.println(same(a,b));
		}
	}
}

