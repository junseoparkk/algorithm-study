import java.util.*;
import java.io.*;

public class Baek_1034{
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk=new StringTokenizer(bf.readLine());
		int N=Integer.parseInt(stk.nextToken());
		int M=Integer.parseInt(stk.nextToken());
		
		String[] lamp=new String[N];
		for(int i=0;i<N;i++)
			lamp[i]=bf.readLine();
		
		int K=Integer.parseInt(bf.readLine());
		
		Map<String,Integer>row=new HashMap<>();
		for(int i=0;i<N;i++) {
			int zero=0;
			for(int j=0;j<M;j++) {
				zero=(lamp[i].charAt(j)=='0')?zero+1:zero;
			}
			if(zero<=K && zero%2==K%2)
				row.put(lamp[i], row.getOrDefault(lamp[i],0)+1);
		}
		
		List<String> str=new ArrayList<>(row.keySet());
		Collections.sort(str,(o1,o2)->row.get(o2).compareTo(row.get(o1)));
		
		if(!str.isEmpty()) System.out.println(row.get(str.get(0)));
		else System.out.println(0);
	}
}