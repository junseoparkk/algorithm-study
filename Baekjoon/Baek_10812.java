import java.util.*;
import java.io.*;

public class Baek_10812{
	static int[] bucket;
	
	public static void change(int i,int j,int k) {
		int[] front=Arrays.copyOfRange(bucket, i, k);
		int[] back=Arrays.copyOfRange(bucket, k, j+1);
		
		int idx=i;
		int fi=0;
		int bi=0;
		for(int t=0;t<back.length;t++)
			bucket[idx++]=back[bi++];
		
		idx=i+back.length;
		for(int t=0;t<front.length;t++)
			bucket[idx++]=front[fi++];
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk=new StringTokenizer(bf.readLine());
		int N=Integer.parseInt(stk.nextToken());
		int M=Integer.parseInt(stk.nextToken());
		
		bucket=new int[N+1];
		for(int i=1;i<N+1;i++)
			bucket[i]=i;
		
		for(int idx=0;idx<M;idx++) {
			stk=new StringTokenizer(bf.readLine());
			int i=Integer.parseInt(stk.nextToken());
			int j=Integer.parseInt(stk.nextToken());
			int k=Integer.parseInt(stk.nextToken());
			
			change(i,j,k);
		}
		for(int i=1;i<bucket.length;i++)
			System.out.print(bucket[i]+" ");
	}
}