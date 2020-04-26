import java.io.*;
import java.util.*;

public class SWMae1 {
	static int n, arr[], dp[], ans=Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
		System.out.println(solution());
	}
	
	public static int solution() {
		dp[0] = arr[0];
		for(int i=1; i<n; i++) {
			dp[i] = Math.max(dp[i-1], 0) + arr[i];
			ans = Math.max(ans, dp[i]);
		}
		return ans;
	}
}
