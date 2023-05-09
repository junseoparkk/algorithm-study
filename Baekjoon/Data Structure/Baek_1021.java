import java.util.*;
import java.io.*;

public class Baek_1021{
	static Deque<Integer>dq=new ArrayDeque<>();
	static int result=0;
	
	public static int getIndex(int target) {
		int idx=0;
		Iterator<Integer>itr=dq.iterator();
		while(itr.hasNext()) {
			int tmp=itr.next();
			if(tmp==target) {
				break;
			}
			idx++;
		}
		return idx;
	}
	
	public static int getHalf() {
		return (dq.size()%2==0) ? dq.size()/2-1 : dq.size()/2;
	}
	
	public static void moveToBack(int idx) {
		for(int i=0;i<idx;i++) {
			int num=dq.pollFirst();
			dq.offerLast(num);
			result++;
		}
	}
	
	public static void moveToFront(int idx) {
		for(int i=0;i<dq.size()-idx;i++) {
			int num=dq.pollLast();
			dq.offerFirst(num);
			result++;
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk=new StringTokenizer(bf.readLine());
		
		int N=Integer.parseInt(stk.nextToken());
		int M=Integer.parseInt(stk.nextToken());
		
		//dq 초기화
		for(int i=0;i<N;i++)
			dq.add(i+1);
		
		//순서 리스트
		List<Integer>list=new ArrayList<>();
		stk=new StringTokenizer(bf.readLine());
		while(stk.hasMoreTokens()) 
			list.add(Integer.parseInt(stk.nextToken()));
		
		for(int i=0;i<list.size();i++) {
			int target=list.get(i);
			
			int target_idx=getIndex(target);
			int half_idx=getHalf();
			
			if(target_idx <= half_idx)
				moveToBack(target_idx);
			else
				moveToFront(target_idx);
			
			dq.pollFirst();
		}
		
		System.out.println(result);
	}
}
