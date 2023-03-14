package Sort;
import java.util.*;
import java.io.*;

class data implements Comparable<data>{
	int value;
	int idx;
	
	public data(int value,int idx) {
		this.value=value;
		this.idx=idx;
	}

	@Override
	public int compareTo(data o) {
		return this.value-o.value;
	}
	
}

public class Baek_1377{
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(bf.readLine());
		data[] arr=new data[N];
		for(int i=0;i<N;i++) {
			arr[i]=new data(Integer.parseInt(bf.readLine()),i);
		}
		Arrays.sort(arr);
		int max=0;
		
		for(int i=0;i<N;i++) {
			if(max<arr[i].idx-i)
				max=arr[i].idx-i;
		}
		System.out.print(max+1);
		
	}
}