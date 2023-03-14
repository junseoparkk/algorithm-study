package Math;
import java.util.*;
import java.io.*;

public class Baek_1292{
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk=new StringTokenizer(bf.readLine()," ");
		
		int a=Integer.parseInt(stk.nextToken());
		int b=Integer.parseInt(stk.nextToken());
		
		List<Integer>list=new ArrayList<>();
		int total=0;
		
		for(int i=1;i<46;i++) {
			for(int j=0;j<i;j++)
				list.add(i);
		}
		for(int i=a-1;i<=b-1;i++)
			total+=list.get(i);
		System.out.print(total);
	}
}