import java.io.*;
import java.util.*;

public class N1242 {
	static int n, k, m;
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
	}
	
	static void solution() {
		int time = 0;
		while(true) {
			time++;
			int K = k % n;
			if(K==m || (K==0 && m==n)) break;
			if(K<m) m -= K;
			else {
				m += n - K;
			}
			n--;
			if(n==0) break;
		}
		System.out.println(time);
	}
}
