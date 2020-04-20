import java.io.*;
import java.util.*;

public class N2629 {
	static int n, m, sum=0, weight[], bead[], dp[][];
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		weight = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
			sum += weight[i];
		}
		
		m = Integer.parseInt(br.readLine());
		bead = new int[m+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=m; i++) bead[i] = Integer.parseInt(st.nextToken());
		
		dp = new int[n+1][sum+1];
	}
	
	static void solution() {
		dfs(0, 0);
		
		for(int i=1; i<=m; i++) {
			if(bead[i]>sum) System.out.print("N ");
			else {
				System.out.print(dp[n][bead[i]]==1 ? "Y " : "N ");
			}
		}
	}
	
	static void dfs(int sum, int idx) {
		if(idx>n || dp[idx][sum]!=0) return;
		dp[idx][sum] = 1;
		dfs(sum+weight[idx], idx+1);
		dfs(Math.abs(sum-weight[idx]), idx+1);
		dfs(sum, idx+1);
	}
}
