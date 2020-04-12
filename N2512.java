import java.io.*;
import java.util.*;

public class N2512 {
	static int n, m;
	static int[] req;
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		req = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) req[i] = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());
		Arrays.sort(req);
	}
	
	static void solution() {
		
		int paid = 0, idx = 0;
		
		for(int i=0; i<n; i++) {
			if(req[i]*(n-i)<=m-paid) {
				paid += req[i];
			} else {
				idx = i;
				break;
			}
			if(i==n-1) {
				System.out.println(req[n-1]); System.exit(0);
			}
		}
		System.out.println((m-paid)/(n-idx));
	}
}