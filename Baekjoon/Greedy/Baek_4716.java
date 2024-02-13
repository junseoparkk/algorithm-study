package Greedy;

import java.util.*;
import java.io.*;

public class Baek_4716 {
	static class Team{
		int distA, distB;
		int balloon;
		
		Team(int distA, int distB, int balloon){
			this.distA=distA;
			this.distB=distB;
			this.balloon=balloon;
		}
	}
	public static void main(String[] args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer stk=new StringTokenizer(bf.readLine());
			
			int N=Integer.parseInt(stk.nextToken());
			int A=Integer.parseInt(stk.nextToken());
			int B=Integer.parseInt(stk.nextToken());
			
			if(N==0 && A==0 && B==0) break;
			
			List<Team> list=new ArrayList<>();
			
			for(int i=0;i<N;i++) {
				stk=new StringTokenizer(bf.readLine());
				
				int K=Integer.parseInt(stk.nextToken());
				int distA=Integer.parseInt(stk.nextToken());
				int distB=Integer.parseInt(stk.nextToken());
				
				list.add(new Team(distA,distB,K));
			}
			
			Collections.sort(list,new Comparator<Team>(){
				@Override
				public int compare(Team t1,Team t2) {
					return Math.abs(t2.distA-t2.distB) - Math.abs(t1.distA-t1.distB);
				}
			});
			
			int result=0;
			
			for(int i=0;i<N;i++) {
				Team team=list.get(i);
				// A가 더 가까운 경우
				if(team.distA < team.distB) {
					// A,B 모두 사용하는 경우
					if(A < team.balloon) {
						result += A * team.distA;
						team.balloon -= A;
						
						// A 모두 사용했음
						A=0;
						result += team.balloon * team.distB;
						B -= team.balloon;
					}else {
						A -= team.balloon;
						result += team.balloon * team.distA;
					}
				}else {
					if(B < team.balloon) {
						result += B * team.distB;
						team.balloon -= B;
						
						// B 모두 사용했음
						B = 0;
						result += team.balloon * team.distA;
						A -= team.balloon;
					}
					else {
						B -= team.balloon;
						result += team.balloon * team.distB;
					}
				}
			}
			System.out.println(result);
		}
	}
}