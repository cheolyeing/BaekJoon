import java.io.*;
import java.util.*;

public class N1389 {
	static int n, m, ans=0;
	static int[][] relation;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		relation = new int[n+1][n+1];
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			relation[a][b] = 1; relation[b][a] = 1;
		}
		
		for (int k=1; k<=n; k++) {
			for (int i=1; i<=n; i++) {
				if(i==k) continue;
				for (int j=1; j<=n; j++) {
					if(i==j || k==j) continue;
					if(relation[i][k]!=0 && relation[k][j]!=0) {
						if(relation[i][j]==0) relation[i][j] = relation[i][k] + relation[k][j];
						else relation[i][j] = Math.min(relation[i][j], relation[i][k]+relation[k][j]);
					}
				}
			}
		}
		
		for (int i=1; i<=n; i++) {
			int sum = 0;
			for (int j=1; j<=n; j++) {
				sum += relation[i][j];
			}
			if(min>sum) {
				min = sum; ans = i;
			}
		}
		System.out.println(ans);
	}
}