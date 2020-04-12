import java.io.*;
import java.util.*;

public class N1727 {
	static int n, m, ans = Integer.MAX_VALUE;
	static boolean[] visited;
	static int[] boy, girl;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		boy = new int[n+1]; girl = new int[m+1];
		dp = new int[n+1][m+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) dp[i][0] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=m; i++) dp[0][i] = Integer.parseInt(st.nextToken());
	}
	
	static void solution() {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				dp[i][j] = Math.abs(dp[i][0]-dp[0][j]);
			}
		}
		
		if(n<m) {
			visited = new boolean[m+1];
			backTracking(0, 1, false);
		} else {
			visited = new boolean[n+1];
			backTracking(0, 1, true);
		}
	}
	
	static void backTracking(int sum, int idx, boolean row) {
		if(row) {
			for(int i=1; i<=n; i++) {
				if(!visited[i]) {
					
				}
			}
		}
	}
}