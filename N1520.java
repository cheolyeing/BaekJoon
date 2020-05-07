import java.io.*;
import java.util.*;

public class N1520 {
	static int m, n;
	static int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
	static int[][] map, dp;
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[m][n];
		dp = new int[m][n];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static void memset() {
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				dp[i][j] = -1;
			}
		}
	}
	
	static void solution() {
		memset();
		dp[0][0] = 1;
		System.out.println(dp(m-1, n-1));
	}
	
	static int dp(int x, int y) {
		if(dp[x][y]!=-1) return dp[x][y];
		
		dp[x][y] = 0;
		for(int k=0; k<4; k++) {
			int nx = x + d[k][0];
			int ny = y + d[k][1];
			if(!inRange(nx, ny)) continue;
			if(map[nx][ny]>map[x][y]) {
				dp[x][y] += dp(nx, ny);
			}
		}
		return dp[x][y];
	}
	
	static boolean inRange(int x, int y) {
		return 0<=x && x<m && 0<=y && y<n;
	}
}
