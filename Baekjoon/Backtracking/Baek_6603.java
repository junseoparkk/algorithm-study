import java.util.*;
import java.io.*;

public class Baek_6603{
	static int k;
	static int lotto[];
	static boolean check[];
	
	private static void DFS(int depth,int idx) {
		if(depth==6) {
			for(int i=0;i<k;i++) {
				if(check[i])
					System.out.print(lotto[i]+" ");
			}
			System.out.println();
		}
		
		for(int i=idx;i<k;i++) {
			check[i]=true;
			DFS(depth+1,i+1);
			check[i]=false;
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str=bf.readLine();
			if(str.equals("0")) break;
			
			String[] select=str.split(" ");
			k=Integer.parseInt(select[0]);
			
			lotto=new int[k];
			check=new boolean[k];
			
			for(int i=0;i<k;i++)
				lotto[i]=Integer.parseInt(select[i+1]);
			
			DFS(0,0);
			System.out.println();
		}
	}
}
