import java.io.*;
import java.util.*;

public class N1389_RE {
	static int n, m, fr[][];
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		fr = new int[n+1][n+1];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			fr[a][b]++; fr[b][a]++;
		}
	}
	
	static void solution() {
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				if(k==i || fr[i][k]==0) continue;
				for(int j=1; j<=n; j++) {
					if(k==j || fr[k][j]==0) continue;
					if(fr[i][j]==0) fr[i][j] = fr[i][k] + fr[k][j];
					else fr[i][j] = Math.min(fr[i][j], fr[i][k]+fr[k][j]);
				}
			}
		}
		
		int ans=0, min = Integer.MAX_VALUE;
		for(int i=1; i<=n; i++) {
			int sum=0;
			for(int j=1; j<=n; j++) {
				sum += fr[i][j];
			}
			if(min>sum) {
				min = sum; ans=i;
			}
		}
		System.out.println(ans);
	}
}
