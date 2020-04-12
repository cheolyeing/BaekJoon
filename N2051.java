import java.io.*;
import java.util.Arrays;

public class N2051 {
	
	static int n, m;
	static int[] B;
	static int[][] vertex;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		setting();
		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		vertex = new int[n+1][m+1];
		visit = new boolean[n+1];
		B = new int[m+1];
		
		for (int i=1; i<=n; i++) {
			input = br.readLine().split(" ");
			for (int j=1; j<=Integer.parseInt(input[0]); j++) {
				vertex[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		int answer = 0;
		
		for (int i=1; i<=n; i++) {
			Arrays.fill(visit, false);
			if(dfs(i)) answer++;
		}
	}
	
	static boolean dfs(int idx) {
		visit[idx] = true;
		for (int i=1; i<=m; i++) {
			int v = vertex[idx][i];
			if(v==0) break;
			if(B[v]==0 || (!visit[B[v]]&&dfs(B[v]))) {
				B[v] = idx; return true;
			}
		}
		return false;
	}
}
