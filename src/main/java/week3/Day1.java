package week3;

import java.util.*;

public class Day1 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    // DFS 함수
    public static void dfs(int x) {
        visited[x] = true;      // 현재 노드 방문 처리
        System.out.print(x + " ");

        // 현재 노드와 연결된 다른 노드를 재귀적으로 방문
        for (int y : graph.get(x)) {
            if (!visited[y]) {
                dfs(y);
            }
        }
    }

    // BFS 함수
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;  // 시작 노드 방문 처리

        while (!queue.isEmpty()) {
            int x = queue.poll();
            System.out.print(x + " ");

            // 현재 노드와 연결된(인접한), 아직 방문하지 않은 노드들 큐에 삽입
            for (int y : graph.get(x)) {
                if (!visited[y]) {
                    visited[y] = true;
                    queue.offer(y);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 입력 받기
        int N = sc.nextInt();  // 정점의 개수
        int M = sc.nextInt();  // 간선의 개수
        int V = sc.nextInt();  // 시작 정점 번호

        // 2. 그래프 초기화 (인덱스를 1 ~ N까지 사용하기 위해 N+1 크기로 생성)
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 3. 간선 정보 입력 받아 그래프 인접 리스트에 저장 (무방향 그래프)
        //    주어진 간선이 (a, b)라면 a -> b, b -> a 둘 다 저장
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 4. 문제에서 방문할 수 있는 정점이 여러 개인 경우 "정점 번호가 작은 것을 먼저 방문"
        //    즉, 오름차순 방문을 위해 각 리스트를 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        // 5. DFS 수행
        visited = new boolean[N+1];  // 방문 배열 초기화
        dfs(V);
        System.out.println();        // 줄바꿈

        // 6. BFS 수행
        visited = new boolean[N+1];  // BFS를 위해 다시 방문 배열 초기화
        bfs(V);
        System.out.println();        // 줄바꿈

        sc.close();
    }
}
