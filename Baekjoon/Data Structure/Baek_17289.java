import java.util.*;
import java.io.*;

public class Baek_17289{
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(bf.readLine());
		Stack<Integer>stack=new Stack<>();
		
		int[] arr=new int[N];
		
		StringTokenizer stk=new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) 
			arr[i]=Integer.parseInt(stk.nextToken());
		
		
		for(int i=0;i<N;i++) {
			while(!stack.isEmpty()&&arr[stack.peek()]<arr[i]) 
				arr[stack.pop()]=arr[i];

			stack.push(i);
		}
		
		while(!stack.isEmpty())
			arr[stack.pop()]=-1;
		
		StringBuilder sb=new StringBuilder("");
		for(int x:arr)
			sb.append(x+" ");
		System.out.print(sb);
	}
}