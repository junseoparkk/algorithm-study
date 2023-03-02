import java.util.*;
import java.io.*;

public class Baek_11659{
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk=new StringTokenizer(bf.readLine()," ");
		int N=Integer.parseInt(stk.nextToken());
		int M=Integer.parseInt(stk.nextToken());
		
		long[]S=new long[N+1];
		stk=new StringTokenizer(bf.readLine()," ");
		for(int i=1;i<N+1;i++) {
			S[i]=S[i-1]+Integer.parseInt(stk.nextToken());
		}
		for(int q=0;q<M;q++) {
			stk=new StringTokenizer(bf.readLine()," ");
			int i=Integer.parseInt(stk.nextToken());
			int j=Integer.parseInt(stk.nextToken());
			System.out.println(S[j]-S[i-1]);
		}
	}
}