import java.io.*;

public class Baek_9663{
	static int N;
	static int[] chess;
	static int result=0;
	
	public static boolean posible(int col) {
		for(int i=0;i<col;i++) {
			if(chess[i]==chess[col])
				return false;
			else if(Math.abs(col-i)==Math.abs(chess[col]-chess[i]))
				return false;
		}
		return true;
	}
	
	public static void dfs(int depth) {
		if(depth==N) {
			result++;
			return;
		}
		
		for(int i=0;i<N;i++) {
			chess[depth]=i;
			if(posible(depth))
				dfs(depth+1);	//열 이동
			
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		
		chess=new int[N];
		
		dfs(0);
		System.out.println(result);
	}
}