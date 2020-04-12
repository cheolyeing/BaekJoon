import java.io.*;
public class N2193 {
	static int n;
	static long[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new long[n+1][2];
		dp[1][0] = 0; dp[1][1] = 1;
		
		for (int i=2; i<=n; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-1][1];
			dp[i][1] = dp[i-1][0];
		}
		System.out.println(dp[n][0]+dp[n][1]);
	}
}