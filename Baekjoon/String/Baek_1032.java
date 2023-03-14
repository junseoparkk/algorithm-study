package String;
import java.io.*;

public class Baek_1032{
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(bf.readLine());
		char[] pattern;
		String str=bf.readLine();
		
		pattern=new char[str.length()];
		pattern=str.toCharArray();
		
		for(int i=0;i<N-1;i++) {
			String s=bf.readLine();
			for(int j=0;j<s.length();j++) {
				if(pattern[j]!=s.charAt(j))
					pattern[j]='?';
				else
					continue;
			}
			
		}
		for(char x:pattern)
			System.out.print(x);
	}
}
