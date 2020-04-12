import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1904 {
	static int n;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
	}
	
	static void solution() {
		dp[0] = 1;
		dp[1] = 1;
		for(int i=2; i<=n; i++) {
			dp[i] = dp[i-1]+dp[i-2];
			dp[i] %= 15746;
		}
		System.out.println(dp[n]);
	}
}