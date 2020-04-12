import java.io.*;
import java.util.*;

public class N13023 {
	static int n, m;
	static int[] dp;
	static int[][] rel;
	static boolean[] visited, use;
	
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		dp = new int[n];
		rel = new int[n][n];
		visited = new boolean[n];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			rel[a][0]++;
			rel[a][rel[a][0]] = b;
			rel[b][0]++;
			rel[b][rel[b][0]] = a;
		}
	}
	
	static void solution() {
		for(int i=0; i<n; i++) {
			dfs(i);
		}
		System.out.println(0);
	}
	
	static int dfs(int x) {
		
		if(dp[x]>=5) {
			System.out.println(1); System.exit(0);
		}
		if(visited[x]) return -1000;
		if(rel[x][0]==0) return 0;
		else dp[x] = Math.max(dp[x], 1);
		
		visited[x] = true;
		for(int i=1; i<=rel[x][0]; i++) {
			dp[x] = Math.max(dp[x], dfs(rel[x][i])+1);
		} visited[x] = false;
		
		return dp[x];
	}
	
	static void showArray(int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			} System.out.println();
		}
	}
}