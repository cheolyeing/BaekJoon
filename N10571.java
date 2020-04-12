import java.io.*;
import java.util.*;

public class N10571 {
	static int n, ans;
	static int[] dp;
	static float[][] diamond;
	final static int weight = 0;
	final static int clear = 1;
	
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int testCase=1; testCase<=tc; testCase++) {
			n = Integer.parseInt(br.readLine());
			diamond = new float[n][2];
			for (int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				diamond[i][weight] = Float.parseFloat(st.nextToken());
				diamond[i][clear] = Float.parseFloat(st.nextToken());
			}
			dp = new int[n]; ans = 0;
			
			for (int i=0; i<n; i++) {
				dp[i] = 1;
				for (int j=0; j<i; j++) {
					if(diamond[j][weight]<diamond[i][weight] && diamond[j][clear]>diamond[i][clear])
						dp[i] = Math.max(dp[j]+1, dp[i]);
				}
				ans = Math.max(ans, dp[i]);
			}
			System.out.println(ans);
		}
	}
}