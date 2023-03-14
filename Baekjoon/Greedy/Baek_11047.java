package Greedy;
import java.util.*;

public class Baek_11047{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int K=sc.nextInt();
		int[] coin=new int[N];
		
		//코인 입력
		for(int i=0;i<N;i++) 
			coin[i]=sc.nextInt();
		
		int idx=coin.length-1;
		int total=0;
		
		//while(합계!=0) 최대 코인 빼기
		while(K>0) {
			int c=coin[idx];
			if(c>K) idx--;
			else if(c==K) {
				total++;
				break;
			}
			else {
				total+=K/c;
				K%=c;
			}
		}
		System.out.print(total);
	}
}