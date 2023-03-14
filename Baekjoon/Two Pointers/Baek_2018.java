import java.io.*;

public class Baek_2018 {
  public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(bf.readLine());
		
		int first=1;
		int last=1;
		int cnt=1;
		int sum=1;
		
		while(last!=N) {
			if(sum==N) {
				cnt++;
				last++;
				sum+=last;
			}else if(sum>N) {
				sum-=first;
				first++;
			}else {
				last++;
				sum+=last;
			}
		}
		System.out.print(cnt);
	}
}
