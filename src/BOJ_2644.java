import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2644 {
    public static boolean[] visited;
    public static List<Integer>[] adj_list;

    public int bfs(int start, int end) {
        Queue<int[]> q = new LinkedList<>();
        visited[start] = true;
        q.offer(new int[]{start, 0});

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int n = node[0];
            int d = node[1];

            if (n == end) {
                return d;
            }

            for (int adj_node : adj_list[n]) {
                if (!visited[adj_node]) {
                    visited[adj_node] = true;
                    q.offer(new int[]{adj_node, d + 1});
                }
            }
        }
        return -1;
    }

    public void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        // adj_list, visited 초기화
        adj_list = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            adj_list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adj_list[x].add(y);
            adj_list[y].add(x);
        }

        System.out.println(bfs(start, end));
    }

    public static void main(String[] args) throws Exception {
        new BOJ_2644().solve();
    }
}