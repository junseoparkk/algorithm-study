package Greedy;
import java.util.*;

public class Baek_1744{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int total=0;
		
		PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> mq=new PriorityQueue<>();
		int one=0;
		int zero=0;
		
		for(int i=0;i<N;i++) {
			int num=sc.nextInt();
			if(num>1) pq.add(num);
			else if(num==1) one++;
			else if(num==0) zero++;
			else mq.add(num);
		}
		
		//양수 처리
		while(pq.size()>1) {
			int a=pq.remove();
			int b=pq.remove();
			total+=a*b;
		}
		if(!pq.isEmpty())
			total+=pq.remove();
		
		//음수 처리
		while(mq.size()>1) {
			int a=mq.remove();
			int b=mq.remove();
			total+=a*b;
		}
		if(!mq.isEmpty()) {
			if(zero==0) total+=mq.remove();
		}
		
		System.out.print(total+one);
	}
}