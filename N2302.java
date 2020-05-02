import java.io.*;

public class N2302 {
	static int n, m, ans=1, dp[];
	public static void main(String[] args) throws IOException {
		setDP();
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		int start = 1;
		for(int i=0; i<m; i++) {
			int now = Integer.parseInt(br.readLine());
			ans *= dp[now-start];
			start = now+1;
		}
		ans *= dp[n-start+1];
		System.out.println(ans);
	}
	
	static void setDP() {
		dp = new int[41];
		dp[0] = 1;
		dp[1] = 1;
		for(int i=2; i<41; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
	}
	
	static void solution() {
		
	}
}
