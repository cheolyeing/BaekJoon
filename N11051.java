import java.io.*;
import java.util.*;

public class Main {
	static int n, k;
	static final int mod = 10007;
	
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
	}
	
	static void solution() {
		int[][] Triangle = new int[n+1][n+1];
        
		for(int N=0; N<=n; N++) {
			for(int K=0; K<=N; K++) {
				if(K==0 || K==N) {
					Triangle[N][K] = 1;
				} else {
					Triangle[N][K] = (Triangle[N-1][K-1] + Triangle[N-1][K]) % mod;
				}
			}
		}
		System.out.println(Triangle[n][k]);
	}
}
