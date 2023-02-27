import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk=new StringTokenizer(bf.readLine()," ");
		int[] arr=new int[5];
		int cnt=0;
		int num=1;
		
		for(int i=0;i<5;i++)
			arr[i]=Integer.parseInt(stk.nextToken());
		
		while(true) {
			cnt=0;
			for(int i=0;i<5;i++) {
				if(num%arr[i]==0)
					cnt++;
			}
			if(cnt>=3)
				break;
			num++;
		}
		System.out.print(num);
	}
}