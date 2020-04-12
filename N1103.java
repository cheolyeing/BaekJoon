import java.io.*;
import java.util.*;
import java.awt.*;

public class N1103 {
	static int n, m;
	static boolean cycle = false;
	static int[][] map;
	static int[][] dp;
	static int[][] d = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		dp = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			for(int j=0; j<m; j++) {
				int t = input.charAt(j) - '0';
				map[i][j] = t < 10 ? t : 0;
			}
		}
		System.out.println(dfs(0, 0));
	}
	
	static int dfs(int x, int y) {
		if(!inRange(x,y) || map[x][y]==0) return 0;
		if(visited[x][y]) {
			System.out.println(-1);
			System.exit(0);
		}
		if(dp[x][y]!=0) return dp[x][y];
		
		visited[x][y] = true;
		for (int i=0; i<4; i++) {
			int nx = x + map[x][y]*d[i][0];
			int ny = y + map[x][y]*d[i][1];
			dp[x][y] = Math.max(dp[x][y], dfs(nx, ny)+1);
		}
		visited[x][y] = false;
		
		return dp[x][y];
	}
	
	static boolean inRange(int x, int y) {
		return (x>=0 && y>=0 && x<n && y<m);
	}
}