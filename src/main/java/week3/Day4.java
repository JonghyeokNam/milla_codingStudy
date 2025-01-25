package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day4 {
    static final int MAX = 100000; // 문제에서의 최대 위치
    static int[] dist;            // dist[x] = 시작점(N)에서 x까지 이동하는 데 걸린 최소 시간
    static boolean[] visited;     // 이미 방문했는지 여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수빈이의 시작 위치
        int K = Integer.parseInt(st.nextToken()); // 동생의 위치

        // 배열 초기화
        dist = new int[MAX + 1];
        visited = new boolean[MAX + 1];

        // BFS 탐색
        bfs(N, K);

        // 결과 출력: N에서 K로 이동하는 데 걸린 최단 시간
        System.out.println(dist[K]);
    }

    private static void bfs(int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;    // 시작 위치 방문 처리
        dist[start] = 0;         // 시작점에서 시작점까지의 거리는 0

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 만약 현재 위치가 목표 위치(K)라면 종료
            if (current == target) {
                return;
            }

            // 1) current - 1
            if (current - 1 >= 0 && !visited[current - 1]) {
                visited[current - 1] = true;
                dist[current - 1] = dist[current] + 1;
                queue.offer(current - 1);
            }

            // 2) current + 1
            if (current + 1 <= MAX && !visited[current + 1]) {
                visited[current + 1] = true;
                dist[current + 1] = dist[current] + 1;
                queue.offer(current + 1);
            }

            // 3) current * 2
            if (current * 2 <= MAX && !visited[current * 2]) {
                visited[current * 2] = true;
                dist[current * 2] = dist[current] + 1;
                queue.offer(current * 2);
            }
        }
    }
}
