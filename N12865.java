import java.io.*;
import java.util.*;

public class N12865 {
	static int n, k, w[], v[], dp[][];	
	
	public static void main(String[] args) throws IOException {
		setting();
		dp();
		System.out.println(dp[n][k]);
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		w = new int[n+1]; v = new int[n+1]; dp = new int[n+1][k+1];
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
			if(w[i]<=k)	dp[i][w[i]] = v[i];
		}
	}
	
	static void dp() {
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=k; j++) {
				if(j<w[i]) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					continue;
				}
				dp[i][j] = Math.max(Math.max(dp[i][j], dp[i-1][j]), dp[i-1][j-w[i]] + v[i]);
			}
		}
	}
	
	static void show() {
		for(int i=1; i<=n; i++) {
			for (int j=1; j<=k; j++) {
				System.out.print(dp[i][j]+" ");
			} System.out.println();
		}
	}
}