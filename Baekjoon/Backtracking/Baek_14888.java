import java.util.*;
import java.io.*;

public class Baek_14888{
	static int N;
	static int op[];	//연산자
	static int num[];	//수
	static int MAX=Integer.MIN_VALUE;
	static int MIN=Integer.MAX_VALUE;
	
	
	public static void DFS(int number,int depth) {
		if(depth==N) {
			MAX=Math.max(MAX,number);
			MIN=Math.min(MIN, number);
			return;
		}
		
		for(int i=0;i<4;i++) {
			if(op[i]>0) {
				op[i]--;
				switch(i) {
				case 0:
					DFS(number+num[depth],depth+1);
					break;
				case 1:
					DFS(number-num[depth],depth+1);
					break;
				case 2:
					DFS(number*num[depth],depth+1);
					break;
				case 3:
					DFS(number/num[depth],depth+1);
					break;
				}
				op[i]++;
			}
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		
		op=new int[4];
		num=new int[N];
		
		StringTokenizer stk=new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++)
			num[i]=Integer.parseInt(stk.nextToken());
		
		stk=new StringTokenizer(bf.readLine());
		for(int i=0;i<4;i++)
			op[i]=Integer.parseInt(stk.nextToken());
		
		DFS(num[0],1);
		
		System.out.print(MAX+"\n"+MIN);
	}
}