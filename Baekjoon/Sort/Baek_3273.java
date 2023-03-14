package Sort;
import java.util.*;
import java.io.*;

public class Baek_3273{
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(bf.readLine());
		int[] arr=new int[n];
		
		StringTokenizer stk=new StringTokenizer(bf.readLine()," ");
		int x=Integer.parseInt(bf.readLine());
		
		for(int i=0;i<n;i++)
			arr[i]=Integer.parseInt(stk.nextToken());
		
		Arrays.sort(arr);
		
		int first=0;
		int last=arr.length-1;
		
		int cnt=0;
		
		while(first<last) {
			if(arr[first]+arr[last]==x) {
				cnt++;
				first++;
				last--;
			}else if(arr[first]+arr[last]<x) {
				first++;
			}else {
				last--;
			}
		}
		
		System.out.print(cnt);
	}
}