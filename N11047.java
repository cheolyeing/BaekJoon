import java.io.*;
import java.util.*;

public class N11047 {
	static int n, k;
	static int[] coin;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		setting();
		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		coin = new int[n];
		
		for (int i=0; i<n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i=1; i<=n; i++) {
			if(k==0) break;
			int idx = n-i;
			if(coin[idx]<=k) {
				answer += k/coin[idx];
				k -= coin[idx] * (k/coin[idx]);
			}
		} System.out.println(answer);
	}
}