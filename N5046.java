import java.io.*;
import java.util.*;
public class N5046 {
	static int n, b, h, w, hotel[][];
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		hotel = new int[h][2];
		for(int i=0; i<h; i++) {
			hotel[i][0] = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int max =0;
			for(int j=1; j<=w; j++) {
				max = Math.max(max, Integer.parseInt(st.nextToken()));
			}
			hotel[i][1] = max;
		}
	}
	
	static void solution() {
		for(int i=0; i<h; i++) {
			if(hotel[i][1]<n) continue;
			if(b<hotel[i][0]*n) continue;
			ans = Math.min(ans, hotel[i][0]*n);
		}
		System.out.println(ans==Integer.MAX_VALUE ? "stay home" : ans);
	}
}
