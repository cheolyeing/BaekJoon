package Today;

import java.io.*;
import java.util.*;

public class N5557 {
	static int n, num[];
	static long dp[][];
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		num = new int[n];
		dp = new long[n][21];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) num[i] = Integer.parseInt(st.nextToken());
	}
	
	static void solution() {
		dp[0][num[0]] = 1;
		for(int i=1; i<n-1; i++) {
			for(int j=0; j<=20; j++) {
				if(dp[i-1][j]==0) continue;
				int res = j + num[i];
				if(inRange(res)) dp[i][res]+=dp[i-1][j];
				res = j - num[i];
				if(inRange(res)) dp[i][res]+=dp[i-1][j];
			}
		}
		System.out.println(dp[n-2][num[n-1]]);
	}
	
	static boolean inRange(int num) {
		return num>=0 && num<21;
	}
}
