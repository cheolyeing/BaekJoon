import java.io.*;
import java.util.*;

public class N1727 {
	static int n, m, ans = Integer.MAX_VALUE;
	static boolean[] visited;
	static int[] boy, girl;
	static long[][] dp;
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		boy = new int[n+1]; girl = new int[m+1];
		dp = new long[n+1][m+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) boy[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=m; i++) girl[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(boy); Arrays.sort(girl);
	}
	
	static void solution() {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				dp[i][j] = dp[i-1][j-1] + Math.abs(boy[i]-girl[j]);
				if(i>j) dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
				if(j>i) dp[i][j] = Math.min(dp[i][j], dp[i][j-1]);
			}
		}
		System.out.println(dp[n][m]);
	}
}
