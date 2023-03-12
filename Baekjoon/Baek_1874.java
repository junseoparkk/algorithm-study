import java.util.*;

public class Baek_1874.java{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		Stack<Integer>stk=new Stack<>();
		
		for(int i=0;i<n;i++) 
			arr[i]=sc.nextInt();
		
		int num=1;
		boolean result=true;
		StringBuffer bf=new StringBuffer();
		
		for(int i=0;i<arr.length;i++) {
			int sn=arr[i];
			
			if(sn>=num) {
				while(sn>=num) {
					stk.push(num++);
					bf.append("+\n");
				}
				stk.pop();
				bf.append("-\n");
			}else {
				int a=stk.pop();
				if(a>sn) {
					System.out.println("NO");
					result=false;
					break;
				}else {
					bf.append("-\n");
				}
			}
		}
		if(result) System.out.println(bf.toString());
		
	}
}