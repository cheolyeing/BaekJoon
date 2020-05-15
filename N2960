import java.io.*;
import java.util.*;

public class N2960 {
	static int n, k;
	static boolean[] prime;
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		prime = new boolean[n+1];
	}
	
	static void solution() {
		int num=0;
		for(int i=2; i<=n; i++) {
			if(prime[i]) continue;
			for(int j=i; j<=n; j+=i) {
				if(!prime[j]) {
					prime[j] = true;
					num++;
					if(num==k) {
						System.out.println(j);
						return;
					}
				}
			}
		}
	}
}
