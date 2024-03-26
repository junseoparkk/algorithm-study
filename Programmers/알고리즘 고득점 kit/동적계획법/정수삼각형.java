class Solution {
    public int solution(int[][] t) {
        for(int i=1;i<t.length;i++) {
			for(int j=0;j<=i;j++) {
				if(j==0) 
					t[i][j]+=t[i-1][0];
				else if(i==j) 
					t[i][j]+=t[i-1][i-1];
				else 
					t[i][j]=t[i][j]+Math.max(t[i-1][j-1],t[i-1][j]);
			}
		}
        int max = t[t.length-1][0];
        
        for(int i=0;i<t.length;i++) {
			if(max<=t[t.length-1][i]) max=t[t.length-1][i];
		}
        return max;
    }
}