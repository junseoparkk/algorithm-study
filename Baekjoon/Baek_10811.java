import java.util.*;
import java.io.*;

public class Main{
	
	static int[] arr;
	
	public static void reverse(int a,int b) {
		List<Integer> list=new ArrayList<>();
		int idx=0;
		
		for(int i=b;i>=a;i--)
			list.add(arr[i]);
		for(int i=a;i<=b;i++)
			arr[i]=list.get(idx++);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk=new StringTokenizer(bf.readLine()," ");
		
		int N=Integer.parseInt(stk.nextToken());
		int M=Integer.parseInt(stk.nextToken());
		
		arr=new int[N+1];
		
		for(int i=1;i<arr.length;i++)
			arr[i]=i;
		
		for(int i=0;i<M;i++) {
			stk=new StringTokenizer(bf.readLine()," ");
			int a=Integer.parseInt(stk.nextToken());
			int b=Integer.parseInt(stk.nextToken());
			
			reverse(a,b);
		}
		
		for(int i=1;i<arr.length;i++)
			System.out.print(arr[i]+" ");
	}
}