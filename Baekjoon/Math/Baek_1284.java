package Math;
import java.io.*;

public class Baek_1284{
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int total=0;
			String num=bf.readLine();
			if(num.equals("0")) break;
			char[] arr=num.toCharArray();
			
			for(int i=0;i<arr.length;i++) {
				if(arr[i]=='1') total+=2;
				else if(arr[i]=='0') total+=4;
				else total+=3;
			}
			System.out.println(total+2+(arr.length-1));
		}
	}
}