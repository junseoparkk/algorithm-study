import java.util.*;
import java.io.*;

public class Baek_1541{
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk=new StringTokenizer(bf.readLine(),"-");
		
		int result=Integer.MAX_VALUE;
		
		while(stk.hasMoreTokens()) {
			int num=0;
			StringTokenizer tmp=new StringTokenizer(stk.nextToken(),"+");
			while(tmp.hasMoreTokens())
				num+=Integer.parseInt(tmp.nextToken());
			
			if(result==Integer.MAX_VALUE) result=num;
			else result-=num;
		}
		
		System.out.print(result);
	}
}
