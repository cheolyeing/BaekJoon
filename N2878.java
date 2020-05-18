import java.io.*;
import java.util.*;

public class N2878 {
	static int m, n;
	static int[] want;
	static long sum = 0;
	static final long mod = (long)Math.pow(2, 64);
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		want = new int[n];
		sum = -m;
		for(int i=0; i<n; i++) {
			want[i] = Integer.parseInt(br.readLine());
			sum += want[i];
		}
	}
	
	static void solution() {
		Arrays.sort(want);
		long ans = 0;
		for(int i=0; i<n; i++) {
			long w = Math.min(want[i], sum/(n-i));
			ans += w*w;
			ans %= mod;
			sum -= w;
		}
		System.out.println(ans);
	}
}
