import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split("");
        int[] arr = new int[10];

        for (String s : st) {
            int n = Integer.parseInt(s);
            if (n == 6) {
                arr[9]++;
            } else {
                arr[n]++;
            }

        }

        arr[9] = (int) Math.ceil(arr[9] / 2.0);

        int answer = 0;

        for (int i : arr) {
            if (i > answer) {
                answer = i;
            }
        }
        System.out.println(answer);
    }

    public static class BOJ_1251 {
        public void solve() throws Exception {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            String input = bf.readLine();
            int N = input.length();

            List<String> answers = new ArrayList<>();

            for (int i = 1; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    String part1 = new StringBuilder(input.substring(0, i)).reverse().toString();
                    String part2 = new StringBuilder(input.substring(i, j)).reverse().toString();
                    String part3 = new StringBuilder(input.substring(j, N)).reverse().toString();

                    String combined = part1 + part2 + part3;
                    answers.add(combined);
                }
            }

            Collections.sort(answers);
            System.out.println(answers.get(0));
        }

        public static void main(String[] args) throws Exception {
            new BOJ_1251().solve();
        }
    }
}
