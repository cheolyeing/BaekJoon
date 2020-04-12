import java.io.*;
import java.util.*;

public class N2293 {
	
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] val = new int[n+1];
		
		for (int i=1; i<=n; i++) {
			val[i] = Integer.parseInt(br.readLine());
		} br.close();
		
		int[] dp = new int[k+1];
		dp[0] = 1;
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=k; j++) {
				if(j-val[i]>=0) {
					dp[j] += dp[j-val[i]];
				}
			}
		} System.out.println(dp[k]);
	}
}