import java.util.*;

public class Baek_1715{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		
		for(int i=0;i<N;i++)
			pq.add(sc.nextInt());
		
		int n1=0;
		int n2=0;
		int total=0;
		
		while(pq.size()!=1) {
			n1=pq.remove();
			n2=pq.remove();
			total+=n1+n2;
			pq.add(n1+n2);
		}
		System.out.print(total);
	}
}