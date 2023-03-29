package Graph;

#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#define MAX 21
using namespace std;

char map[MAX][MAX];
bool visited[26];		//지나온 알파벳 저장

int dx[4] = { 0,1,0,-1 };
int dy[4] = { 1,0,-1,0 };
string s;

int R, C;
int ans=1;


void dfs(int y, int x, int cnt) {
	ans = max(ans, cnt);
	for (int i = 0; i<4; i++) {
		int xx = x + dx[i];
		int yy = y + dy[i];

		if (yy >= 0 && xx >= 0 && yy < R && xx < C) {
			if (!visited[map[yy][xx]-'A']) {
				visited[map[yy][xx] - 'A'] = true;
				dfs(yy,xx, cnt + 1);
				visited[map[yy][xx] - 'A'] = false;
			}
		}
	}
}

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> R >> C;
	for (int i = 0; i < R; i++) {
		cin >> s;
		for (int j = 0; j < C; j++)
			map[i][j] = s[j];
	}
	visited[map[0][0] - 'A'] = true;
	dfs(0,0,1);
	cout << ans;
}
