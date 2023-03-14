package String;
import java.util.*;
import java.io.*;

public class Baek_1264{
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int cnt=0;
			String str=bf.readLine();
			if(str.equals("#")) break;
			for(int i=0;i<str.length();i++) {
				char ch=str.charAt(i);
				if(ch=='a'||ch=='A'||ch=='e'||ch=='E'||ch=='i'||ch=='I'||
						ch=='o'||ch=='O'||ch=='u'||ch=='U') {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}