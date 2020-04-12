import java.io.*;
import java.util.*;

public class N2294 {
	static int n, k, dp[];
	static ArrayList<Integer> coin = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) coin.add(Integer.parseInt(br.readLine()));
		Collections.sort(coin);
		
		for(int i=0; i<coin.size()-1; i++) {
			if(coin.get(i)==coin.get(i+1)) {
				coin.remove(i); i--;
			}
		}
	}
	
	static void solution() {
		dp = new int[k+1];
		Arrays.fill(dp, Integer.MAX_VALUE-1);
		for(int i=0; i<coin.size(); i++) 
			if(coin.get(i)<=k) dp[coin.get(i)] = 1;
		
		for(int i=0; i<=k; i++) {
			for(int j=0; j<coin.size(); j++) {
				if(i-coin.get(j)<0) break;
				dp[i] = Math.min(dp[i], dp[i-coin.get(j)]+1);
			}
		}
		System.out.println(dp[k]==Integer.MAX_VALUE-1 ? -1 : dp[k]);
	}
}
