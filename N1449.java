import java.io.*;
import java.util.*;

public class N1449 {
	static int n, l, ans=1;
	static int[] water;
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		water = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) water[i] = Integer.parseInt(st.nextToken());
	}
	
	static void solution() {
		Arrays.sort(water);
		int start = water[0];
		for(int i=1; i<n; i++) {
			if(water[i]-start+1<=l) {
				
			} else {
				start = water[i]; ans++;
			}
		}
		System.out.println(ans);
	}
}
