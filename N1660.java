import java.io.*;
import java.util.*;

public class N1660 {
	static int n, num[] = new int[121], dp[] = new int[300001];
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for(int i=1; i<121; i++) num[i] = i*(i+1)*(i+2)/6;
	}
	
	static void solution() {
		for(int i=1; i<121; i++) dp[num[i]] = 1;
		
		for(int i=2; i<=n; i++) {
			int min = 99999;
			for(int j=1; j<121; j++) {
				if(i-num[j]<=0) break;
				min = Math.min(min, dp[i-num[j]]+1);
			}
			if(dp[i]==0) dp[i] = min;
		}
		System.out.println(dp[n]);
	}
}
