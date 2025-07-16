import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_30804 {

    public void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] fruits = new int[N];
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int answer = 0;

        for (int right = 0; right < N; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            // 과일 종류가 3가지 이상이면, 2가지가 될 떄까지 map에서 제거
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            answer = Math.max(answer, right - left + 1);
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new BOJ_30804().solve();
    }
}