import java.util.*;
import java.io.*;

public class Baek_11478{
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String str=bf.readLine();
		
		Set<String> set=new HashSet<>();
		
		for(int i=0;i<str.length();i++) {
			for(int j=i+1;j<=str.length();j++) {
				String sub=str.substring(i, j);
				set.add(sub);
			}
		}
		System.out.print(set.size());
	}
}