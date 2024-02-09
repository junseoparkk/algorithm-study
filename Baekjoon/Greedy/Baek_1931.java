package Greedy;

import java.io.*;
import java.util.*;

public class Baek_1931 {
    static class Time implements Comparable<Time> {
        int startTime;
        int endTime;

        public Time(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Time t) {
            if (this.endTime == t.endTime) {
                return this.startTime - t.endTime;
            } else {
                return this.endTime - t.endTime;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Time[] times = new Time[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            times[i] = new Time(start, end);
        }

        Arrays.sort(times);

        // 첫 번째 포함
        int result = 0;
        int endTime = -1;

        for (int i = 0; i < N; i++) {
            Time time = times[i];
            if (time.startTime >= endTime) {
                result++;
                endTime = time.endTime;
            }
        }

        System.out.print(result);
    }
}

