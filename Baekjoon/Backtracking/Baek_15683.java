import java.io.*;
import java.util.*;

public class Baek_15683 {
    static class CCTV {
        int x, y;
        int num;

        public CCTV(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    static int N, M;
    static int[][] room;
    static int[][] copyRoom;
    static int[] directions;
    static List<CCTV> cctv;
    static int result = Integer.MAX_VALUE;

    // 상, 우, 하, 좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        room = new int[N][M];
        cctv = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(stk.nextToken());
                if (room[i][j] != 0 && room[i][j] != 6) {
                    cctv.add(new CCTV(i, j, room[i][j]));
                }
            }
        }

        directions = new int[cctv.size()];
        permutation(0, cctv.size());

        System.out.print(result);
    }

    private static void permutation(int depth, int number) {
        if (depth == number) {
            copyRoom = new int[N][M];
            for (int i = 0; i < room.length; i++) {
                System.arraycopy(room[i], 0, copyRoom[i], 0, room[i].length);
            }

            for (int i = 0; i < cctv.size(); i++) {
                setDirection(cctv.get(i), directions[i]);
            }

            calBlindSpot();
            return;
        }

        for (int i = 0; i < 4; i++) {
            directions[depth] = i;
            permutation(depth + 1, number);
        }
    }

    private static void setDirection(CCTV cctv, int dir) {
        int cctvNumber = cctv.num;

        if (cctvNumber == 1) {
            if (dir == 0) {
                watch(cctv, 0);   // 상
            }
            else if (dir == 1) {
                watch(cctv, 1);  // 우
            }
            else if (dir == 2) {
                watch(cctv, 2);  // 하
            }
            else if (dir == 3) {
                watch(cctv, 3);  // 좌
            }
        } else if (cctvNumber == 2) {
            if (dir == 0 || dir == 2) {
                watch(cctv, 0); // 상
                watch(cctv, 2); // 하
            } else {
                watch(cctv, 1); // 우
                watch(cctv, 3); // 좌
            }
        } else if (cctvNumber == 3) {
            if (dir == 0) {
                watch(cctv, 0); // 상
                watch(cctv, 1); // 우
            } else if (dir == 1) {
                watch(cctv, 1); // 우
                watch(cctv, 2); // 하
            } else if (dir == 2) {
                watch(cctv, 2); // 하
                watch(cctv, 3); // 좌
            } else if (dir == 3) {
                watch(cctv, 0); // 좌
                watch(cctv, 3); // 상
            }
        } else if (cctvNumber == 4) {
            if (dir == 0) {
                watch(cctv, 0);
                watch(cctv, 1);
                watch(cctv, 3);
            } else if (dir == 1) {
                watch(cctv, 0);
                watch(cctv, 1);
                watch(cctv, 2);
            } else if (dir == 2) {
                watch(cctv, 1);
                watch(cctv, 2);
                watch(cctv, 3);
            } else if (dir == 3) {
                watch(cctv, 0);
                watch(cctv, 2);
                watch(cctv, 3);
            }
        } else if (cctvNumber == 5) {
            watch(cctv, 0);
            watch(cctv, 1);
            watch(cctv, 2);
            watch(cctv, 3);
        }
    }

    private static void watch(CCTV cctv, int dir) {
        Queue<CCTV> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        q.add(cctv);
        visited[cctv.x][cctv.y] = true;

        while (!q.isEmpty()) {
            CCTV now = q.poll();
            int nx = now.x + dx[dir];
            int ny = now.y + dy[dir];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M || copyRoom[nx][ny] == 6) {
                break;
            }

            if (copyRoom[nx][ny] == 0) {
                copyRoom[nx][ny] = -1;
                q.add(new CCTV(nx, ny, cctv.num));
            } else {
                q.add(new CCTV(nx, ny, cctv.num));
            }
        }
    }

    private static void calBlindSpot() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyRoom[i][j] == 0) {
                    cnt++;
                }
            }
        }
        result = Math.min(result, cnt);
    }
}
