import java.io.*;
import java.util.*;

public class N6591 {
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			b = Math.min(b, a-b);
			if(a==0 && b==0) break;
			System.out.println(comb(a, b));
		}
	}
	
	static long comb(int n, int r) {
		long ans = 1;
		for(int i=1; i<=r; i++) {
			ans *= (n+1-i);
			ans /= i;
		}
		return ans;
	}
}