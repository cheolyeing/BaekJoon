import java.io.*;
import java.util.*;

public class N1937 {
	static int n, map[][], dp[][], ans=0;
	static int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n]; dp = new int[n][n];
		for(int i=0; i<n; i++) {
			Arrays.fill(dp[i], 1);
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solution() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				ans = Math.max(ans, start(i, j));
			}
		}
		System.out.println(ans);
	}
	
	static int start(int x, int y) {
		if(dp[x][y]!=1) return dp[x][y];
		
		for(int i=0; i<4; i++) {
			int nx = x + d[i][0];
			int ny = y + d[i][1];
			if(inRange(nx, ny) && map[x][y]>map[nx][ny]) {
				if(dp[x][y]<start(nx, ny)+1) dp[x][y] = start(nx, ny)+1;
			}
		}
		
		return dp[x][y];
	}
	
	static boolean inRange(int x, int y) {
		return x>=0 && y>=0 && x<n && y<n;
	}
}
