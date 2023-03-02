import java.util.*;
import java.io.*;
public class Baek_1940 {
  public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(bf.readLine());
		int M=Integer.parseInt(bf.readLine());
		
		int[]arr=new int[N];
		StringTokenizer stk=new StringTokenizer(bf.readLine()," ");
		for(int i=0;i<N;i++) 
			arr[i]=Integer.parseInt(stk.nextToken());
		
		Arrays.sort(arr);
		
		int first=0;
		int last=arr.length-1;
		int total=0;
		
		while(first<last) {
			if(arr[first]+arr[last]==M) {
				total++;
				first++;
				last--;
			}else if(arr[first]+arr[last]<M) {
				first++;
			}else {
				last--;
			}
		}
		System.out.println(total);
	}
}
