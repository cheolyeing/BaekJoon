import java.io.*;
import java.util.*;

public class N1477 {
	static int n, m, l;
	static int[] rest;
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		rest = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) rest[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(rest);
	}
	
	static void solution() {
		int start = l/(n+m+1);
		for(int i=start; i<l; i++) {
			int s = 0, build=0, idx=0;
			while(s+i<l) {
				if(idx<n && rest[idx]<=s+i) {
					s = rest[idx++];
				} else {
					build++; s+=i;
				}
				if(build>m) break;
			}
			if(build<=m) {
				System.out.println(i); System.exit(0);
			}
		}
	}
}
