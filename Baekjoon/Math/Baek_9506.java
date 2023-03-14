package Math;
import java.util.*;

public class Baek_9506{
	
	public static void show(List<Integer> list,int n) {
		System.out.print(n+" = ");
		for(int i=0;i<list.size()-1;i++) 
			System.out.print(list.get(i)+" + ");
		System.out.println(list.get(list.size()-1));
	}
	
	public static void solve(int n) {
		List<Integer> arr=new ArrayList<>();
		int total=0;
		
		for(int i=1;i<n;i++) {
			if(n%i==0) {
				arr.add(i);
				total+=i;
			}
		}
		if(total==n) show(arr,n);
		else System.out.println(n+" is NOT perfect.");
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			int num=sc.nextInt();
			
			if(num==-1)
				break;
			
			solve(num);
		}
	}
}