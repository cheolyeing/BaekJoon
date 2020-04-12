import java.io.*;
import java.util.*;

public class N2188 {
	
	static int n;
	static int m;
	static int[] B;
	static int[][] cow;
	static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		setting();
		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		cow = new int[n+1][m+1]; visited = new boolean[n+1];
		B = new int[m+1];
		
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			Arrays.fill(cow[i], -1);
			for (int j=1; j<=k; j++) {
				cow[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		
		for (int i=1; i<=n; i++) {
			Arrays.fill(visited, false);
			if(dfs(i)) answer++;
		}
		System.out.println(answer);
		//showB();
	}
	
	static boolean dfs(int start) {
		visited[start] = true;
		for (int i=1; i<=m; i++) {
			if(cow[start][i]==-1) break;
			int v = cow[start][i];
			if(B[v]==0 || (!visited[B[v]] && dfs(B[v]))) {
				B[v] = start;
				return true;
			}
		}
		return false;
	}
	
	static void showB() {
		for (int i=1; i<=m; i++) {
			System.out.print(B[i]+" ");
		}
	}
}