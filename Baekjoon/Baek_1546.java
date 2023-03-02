import java.util.*;
import java.io.*;

public class Baek_1546{
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		List<Integer>score=new ArrayList<>();
		
		int N=Integer.parseInt(bf.readLine());
		StringTokenizer stk=new StringTokenizer(bf.readLine()," ");
		for(int i=0;i<N;i++) 
			score.add(Integer.parseInt(stk.nextToken()));
		
		long sum=0;
		long max=0;
		
		for(int i=0;i<N;i++) {
			if(score.get(i)>=max)
				max=score.get(i);
			sum+=score.get(i);
		}
		System.out.println(sum*100.0/max/N);
	}
}
