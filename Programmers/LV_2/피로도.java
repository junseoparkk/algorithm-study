/*
 * k : 현재 피로도, result : 유저가 탐험할 수 있는 최대 던전 수
 * 던전 입장 조건 : 최소 필요 피로도보다 커야 함
 * 던전 탐험 후 : 소모 피로도만큼 감소
 */

class Solution {
    private int result = 0;
    private boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return result;
    }
    
    private void dfs(int k, int[][] dungeons, int depth) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, depth + 1);
                visited[i] = false;
            } 
        }
        result = Math.max(result, depth);
    }
}