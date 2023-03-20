import java.util.*;
import java.io.*;

public class Baek_2661{
	static int N;
	
	public static void DFS(String seq) {
		if(seq.length()==N) {
			System.out.print(seq);
			System.exit(0);
		}else {
			for(int i=1;i<=3;i++) {
				if(isGood(seq+i))
					DFS(seq+i);
			}
		}
	}
	
	public static boolean isGood(String seq) {
		int l=seq.length()/2;
		
		for(int i=1;i<=l;i++) {
			if(seq.substring(seq.length()-i).equals(seq.substring(seq.length()-2*i, seq.length()-i)))
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
	
		DFS("");
	}
}