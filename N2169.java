import java.io.*;
import java.util.*;

public class N2169 {
	static final int INF = -2000000000;
	static int n, m, map[][], dp[][];
	static int[] L2R, R2L;
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		dp = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = INF;
			}
		}
	}
	
	static void setLine(int idx) {
		L2R = new int[m];		
		L2R[0] = map[idx][0];
		for(int i=1; i<m; i++) L2R[i] = L2R[i-1]+map[idx][i];
		
		R2L = new int[m];
		R2L[m-1] = map[idx][m-1];
		for(int i=m-2; i>=0; i--) R2L[i] = R2L[i+1]+map[idx][i];
	}
	
	static void solution() {
		for(int i=0; i<n; i++) setDP(i);
		System.out.println(dp[n-1][m-1]);
	}
	
	static void setDP(int line) {
		if(line==0) {
			setLine(0);
			for(int i=0; i<m; i++) dp[0][i] = L2R[i];
		} else {
			setLine(line);
			for(int i=0; i<m; i++) {
				int left=i, right=i;
				while(true) {
					if(left<0) break;
					int tmp = dp[line-1][left] + L2R[i];
					if(left!=0) tmp -= L2R[left-1];
					dp[line][i] = Math.max(dp[line][i], tmp);
					left--;
				}
				while(true) {
					if(right>=m) break;
					int tmp = dp[line-1][right] + R2L[i];
					if(right!=m-1) tmp -= R2L[right+1];
					dp[line][i] = Math.max(dp[line][i], tmp);
					right++;
				}
			}
		}
	}
}
