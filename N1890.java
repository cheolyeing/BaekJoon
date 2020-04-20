import java.io.*;
import java.util.*;

public class N1890 {
	static int n, ans=0, map[][];
	static long dp[][];
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n]; dp = new long[n][n];
		StringTokenizer st;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static void solution() {
		System.out.println(find(0, 0));
	}
	
	static boolean inRange(int x, int y) {
		return x<n && y<n;
	}
	
	static long find(int x, int y) {
		if(!inRange(x, y)) return 0;
		if(x==n-1 && y==n-1) return 1;
		if(map[x][y]==0) return 0;
		if(dp[x][y]!=0) return dp[x][y];
		dp[x][y] = find(x+map[x][y], y) + find(x, y+map[x][y]);
		return dp[x][y];
	}
}
