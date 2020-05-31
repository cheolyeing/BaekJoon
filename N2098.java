import java.io.*;
import java.util.*;

public class N2098 {
	static final int INF = 1000000000;
	static int n, cost[][], dp[][];
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		cost = new int[n][n];
		dp = new int[n][1<<n];
		
		for(int i=0; i<n; i++) {
			Arrays.fill(dp[i], -1);
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static void solution() {
		System.out.println(DP(0, 1));
	}
	
	static int DP(int pos, int route) {
		if(route==(1<<n)-1) {
			if(cost[pos][0]!=0) return cost[pos][0];
			else return INF;
		}
		
		if(dp[pos][route]!=-1) return dp[pos][route];
		
		int m = INF;
		for(int i=1; i<n; i++) {
			if((route&1<<i)==0 && cost[pos][i]!=0) {
				m = Math.min(DP(i, (route|1<<i))+cost[pos][i], m);
			}
		}
		
		return dp[pos][route] = m;
	}
}
