package Divide_and_conquer;

import java.util.*;
import java.io.*;

public class Back_16438{
	static char[][]monkeys;
	
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(bf.readLine());
		
		monkeys=new char[7][N];
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<N;i++) sb.append('B');
		
		merge(0,0,N);
		
		for(int i=0;i<7;i++) {
			String str=new String(monkeys[i]);
			if(str.equals(sb.toString()))
				monkeys[i][0]='A';
			
			for(int j=0;j<N;j++)
				System.out.print(monkeys[i][j]);
			
			System.out.println();
		}
		
	}
	
	public static void merge(int day,int start,int end) {
		if(day==7)
			return;
	
		int mid=(start+end)/2;
		
		for(int i=start;i<mid;i++)
			monkeys[day][i]='A';
		
		for(int i=mid;i<end;i++)
			monkeys[day][i]='B';
		
		merge(day+1,start,mid);
		merge(day+1,mid,end);
	}
}
