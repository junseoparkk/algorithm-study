import java.util.*;
import java.io.*;

public class Baek_1075{
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(bf.readLine());
		int F=Integer.parseInt(bf.readLine());
		
		N=N/100*100;
		
		int result=0;
		
		for(int i=0;i<101;i++) {
			if(N%F==0) break;
			else if((N+i)%F==0 && i!=0) {
				result=i;
				break;
			}
		}
		if(result<10) System.out.printf("0%d",result);
		else System.out.print(result);
	}
}