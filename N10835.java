import java.io.*;
import java.util.*;

public class N10835 {
	static int n, max=0, left[], right[], dp[][];
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		left = new int[n];
		right = new int[n];
		dp = new int[n][n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) left[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) right[i] = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) for(int j=0; j<n; j++) dp[i][j] = -1;	
	}
	
	static void solution() {
		System.out.println(DP(0, 0));
	}
	
	static int DP(int x, int y) {
		if(x>=n || y>=n) return 0;
		if(dp[x][y]!=-1) return dp[x][y];
		if(left[x]>right[y]) {
			dp[x][y] = Math.max(dp[x][y], DP(x, y+1)+right[y]);
		}
		dp[x][y] = Math.max(dp[x][y], DP(x+1, y));
		dp[x][y] = Math.max(dp[x][y], DP(x+1, y+1));
		return dp[x][y];
	}
}
