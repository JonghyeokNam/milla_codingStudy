package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Day2 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        visited = new boolean[N + 1];
        int count = 0;

        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    static void dfs(int start){
        visited[start] = true;

        for(int next : graph[start]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}
