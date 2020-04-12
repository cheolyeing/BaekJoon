import java.io.*;

public class N9095 {
	static int n;
	static int[] input;
	static int max = 0;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		setting();
		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		input = new int[n];
		
		for (int i=0; i<n; i++) {
			input[i] = Integer.parseInt(br.readLine());
			if(max<input[i]) max = input[i];
		}
		dp();
		
		for (int i=0; i<n; i++) {
			System.out.println(dp[input[i]]);
		}
	}
	
	static void dp() {
		dp = new int[max+1];
		dp[1] = 1; dp[2] =2; dp[3] = 4;
		for(int i=4; i<=max; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
	}
}
