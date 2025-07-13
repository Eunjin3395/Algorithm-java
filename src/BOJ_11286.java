import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11286 {
    public static boolean[] visited;
    public static int F;
    public static int U;
    public static int D;

    public String bfs(int start, int target) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int curr_f = curr[0];
            int curr_d = curr[1];
            if (curr_f == target) {
                return String.valueOf(curr_d);
            }

            if (curr_f + U <= F) {
                if (!visited[curr_f + U]) {
                    q.offer(new int[]{curr_f + U, curr_d + 1});
                    visited[curr_f + U] = true;
                }
            }

            if (curr_f - D >= 1) {
                if (!visited[curr_f - D]) {
                    q.offer(new int[]{curr_f - D, curr_d + 1});
                    visited[curr_f - D] = true;
                }
            }
        }
        return "use the stairs";
    }

    public void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new boolean[F + 1];

        System.out.println(bfs(S, G));
    }

    public static void main(String[] args) throws Exception {
        new BOJ_11286().solve();
    }
}