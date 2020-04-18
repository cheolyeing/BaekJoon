import java.io.*;
import java.util.*;

public class N1940 {
	static int n, m, arr[];
	
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
	}
	
	static void solution() {
		int ans = 0;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				if(arr[i] + arr[j] == m) {
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}
