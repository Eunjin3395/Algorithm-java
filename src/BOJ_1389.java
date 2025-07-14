import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1389 {
    public static int N;
    public static ArrayList<Integer>[] adj_list;

    public int bfs(int start) {
        Queue<int[]> q = new LinkedList<int[]>();
        boolean[] visited = new boolean[N + 1];
        int ret = 0;

        q.offer(new int[]{start, 0});
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] info = q.poll();
            int node = info[0];
            int depth = info[1];
            ret += depth;

            for (int adj_node : adj_list[node]) {
                if (!visited[adj_node]) {
                    q.offer(new int[]{adj_node, depth + 1});
                    visited[adj_node] = true;
                }
            }

        }
        return ret;
    }

    public void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 각 노드마다 다른 노드 전부를 방문하는데에 걸리는 횟수(depth) 합산
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adj_list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adj_list[i] = new ArrayList<>();
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj_list[a].add(b);
            adj_list[b].add(a);
        }

        int mn_depth = M * N + 1;
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int depth = bfs(i);
            if (depth < mn_depth) {
                mn_depth = depth;
                answer = i;
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new BOJ_1389().solve();
    }
}