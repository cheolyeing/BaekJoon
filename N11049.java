import java.io.*;
import java.util.*;

public class N11049 {
	static int n;
	static int[][] arr;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		setting();
		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][2];
		dp = new int[n][n];
		
		for (int i=0; i<n; i++) {
			Arrays.fill(dp[i], -1);
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		System.out.println(func(0, n-1));
	}
	
	static int func(int x, int y) {
		if(x==y) return 0;
		if(dp[x][y]!=-1) return dp[x][y];
		
		int mm = Integer.MAX_VALUE;
		
		for(int i=x; i<y; i++) {
			mm = Math.min(mm, func(x, i) + func(i+1, y) + arr[x][0]*arr[i][1]*arr[y][1]);
		}
		dp[x][y] = mm;
		return mm;
	}
}