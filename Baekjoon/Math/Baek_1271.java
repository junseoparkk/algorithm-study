package Math;
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Baek_1271{
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk=new StringTokenizer(bf.readLine()," ");
		
		BigInteger b1=new BigInteger(stk.nextToken());
		BigInteger b2=new BigInteger(stk.nextToken());
		
		System.out.println(b1.divide(b2));
		System.out.println(b1.remainder(b2));
	}
}
