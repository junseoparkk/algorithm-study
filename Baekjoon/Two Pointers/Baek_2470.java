import java.util.*;
import java.io.*;

public class Baek_2470{
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(bf.readLine());
		int[]arr=new int[N];
		int MIN=Integer.MAX_VALUE;
		int a=0;
		int b=0;
		
		StringTokenizer stk=new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++)
			arr[i]=Integer.parseInt(stk.nextToken());
		
		Arrays.sort(arr);
	
		int l=0;
		int r=arr.length-1;
		
		while(l<r) {
			int num=Math.abs(arr[l]+arr[r]);
			
			if(num<MIN) {
				MIN=num;
				a=arr[l];
				b=arr[r];
			}
			
			if(arr[l]+arr[r]>0)
				r--;
			else
				l++;
		}
		System.out.println(a+" "+b);
	}
}