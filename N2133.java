import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int dp[];

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
    }

    static void solution() {
        dp = new int[n + 1];

        int answer = 0;
        if (n % 2 == 0) {
            dp[2] = 3;
            dp[0] = 1;
            for (int i = 4; i <= n; i += 2) {
                for (int j = 2; j <= i; j += 2) {
                    int standard = j == 2 ? 3 : 2;
                    dp[i] += standard * dp[i - j];
                }
            }
            answer = dp[n];
        }
        System.out.println(answer);
    }
}
