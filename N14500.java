import java.io.*;
import java.util.*;

public class N14500 {
	static int n, m;
	static int[][] point;
	static int[][] d = {{1,0},{0,1},{-1,0},{0,-1}};
	static int answer = 0;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		setting();
		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		point = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++) {
				point[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				visited[i][j] = true;
				dfs(1, i, j, point[i][j]);
				visited[i][j] = false;
			}
		}
		
		for (int i=1; i<n-1; i++) {
			for (int j=0; j<m; j++) {
				shape1(i, j);
			}
		}
		
		for (int i=0; i<n; i++) {
			for (int j=1; j<m-1; j++) {
				shape2(i, j);
			}
		}
		System.out.println(answer);
	}
	
	static void dfs (int depth, int x, int y, int sum) {
		if(depth==4) {
			if(answer<sum) answer = sum;
			return;
		}
		for (int i=0; i<4; i++) {
			int nx = x + d[i][0];
			int ny = y + d[i][1];
			if(0<=nx && 0<=ny && nx<n && ny<m && !visited[nx][ny]) {
				visited[nx][ny] = true;
				dfs(depth+1, nx, ny, sum+point[nx][ny]);
				visited[nx][ny] = false;
			}
		}
	}
	
	static void shape1(int x, int y) {
		int sum = point[x][y] + point[x-1][y] + point[x+1][y];
		if(y!=0) {
			if(answer<sum+point[x][y-1]) answer = sum + point[x][y-1];
		}
		if(y!=m-1) {
			if(answer<sum+point[x][y+1]) answer = sum + point[x][y+1];
		}
	}
	
	static void shape2(int x, int y) {
		int sum = point[x][y] + point[x][y-1] + point[x][y+1];
		if(x!=0) {
			if(answer<sum+point[x-1][y]) answer = sum + point[x-1][y];
		}
		if(x!=n-1) {
			if(answer<sum+point[x+1][y]) answer = sum + point[x+1][y];
		}
	}
}