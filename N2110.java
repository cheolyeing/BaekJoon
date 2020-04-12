import java.io.*;
import java.util.*;

public class N2110 {
	static int n, c;
	static int[] pos;
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		pos = new int[n];
		for(int i=0; i<n; i++) pos[i] = Integer.parseInt(br.readLine());
		Arrays.sort(pos);
	}
	
	static void solution() {
		int left = 1;
		int right = pos[n-1] - pos[0];
		int d = 0;
		int ans = 0;
		
		while(left<=right) {
			int mid = (left + right) / 2;
			int start = pos[0];
			int cnt = 1;
			
			for(int i=1; i<n; i++) {
				d = pos[i] - start;
				if(mid<=d) {
					++cnt;
					start = pos[i];
				}
			}
			
			if(cnt>=c) {
				ans = mid;
				left = mid+1;
			} else {
				right = mid-1;
			}
		}
		System.out.println(ans);
	}
}