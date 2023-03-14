package Backtrackiing;
import java.util.*;

public class Baek_13023{
	static boolean visited[];
	static ArrayList<Integer>[] people;
	static boolean arrive;
	
	public static void dfs(int x,int depth) {
		if(depth==5 || arrive) {
			arrive=true;
			return;
		}
		visited[x]=true;
		for(int i:people[x]) {
			if(!visited[i])
				dfs(i,depth+1);
		}
		visited[x]=false;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		
		people=new ArrayList[N];
		visited=new boolean[N];
		arrive=false;
		
		for(int i=0;i<N;i++)
			people[i]=new ArrayList<Integer>();
		
		for(int i=0;i<M;i++) {
			int S=sc.nextInt();
			int E=sc.nextInt();
			
			people[S].add(E);
			people[E].add(S);
		}
		
		for(int i=0;i<N;i++) {
			dfs(i,1);
			if(arrive) break;
		}
		
		if(arrive) System.out.print("1");
		else System.out.print("0");
	}
}