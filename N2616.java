import java.io.*;
import java.util.*;

public class N2616 {
	static int n, train[], lead, dp[][];
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		train = new int[n];
		dp = new int[n-lead+1][4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) train[i] = Integer.parseInt(st.nextToken());
		lead = Integer.parseInt(br.readLine());
	}
	
	static void solution() {
		int num=0;
		int val=0;
		int idx=0;
		for(int i=0; i<n; i++) {
			num++;
			val+=train[i];
			if(num>=lead) {
				dp[idx++][0] = val;
				val -= train[i-lead+1];
			}
		}
		
		for(int i=0; i<lead; i++) {
			dp[i][1] = Math.max(dp[i][1], dp[i][0]);
		}
		for(int i=lead; i<n-lead+1; i++) {
			dp[i][1] = Math.max(dp[i][0], dp[i-1][1]);
			dp[i][2] = Math.max(dp[i-1][2], dp[i-lead][1]+dp[i][0]);
			dp[i][3] = Math.max(dp[i-1][3], dp[i-lead][2]+dp[i][0]);
		}
		
		System.out.println(dp[n-lead][3]);
	}
}
