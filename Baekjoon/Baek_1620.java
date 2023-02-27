import java.util.*;
import java.io.*;;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk=new StringTokenizer(bf.readLine()," ");
		
		int N=Integer.parseInt(stk.nextToken());
		int M=Integer.parseInt(stk.nextToken());
		
		Map<String,String> dic=new HashMap<>();
		Map<String,String> dic2=new HashMap<>();
		
		for(int i=0;i<N;i++) {
			String str=bf.readLine();
			dic.put(str, Integer.toString(i+1));
			dic2.put(Integer.toString(i+1), str);
		}
		
		
		for(int i=0;i<M;i++) {
			String str=bf.readLine();
			if(str.charAt(0)<='9') {
				System.out.println(dic2.get(str));
			}else {
				System.out.println(dic.get(str));
			}
		}
	}
}