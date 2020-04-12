import java.io.*;
import java.util.*;

public class N11376 {
	static int n, m, answer=0;
	static int[][] arr;
	static int[][] B;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n+1][m+1];
		B = new int[m+1][2];
		visited = new boolean[n+1];
		
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			for (int j=1; j<=size; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=1; i<=n; i++) {
			Arrays.fill(visited, false);
			if(dfs1(i)) answer++;
		}
		for (int i=1; i<=n; i++) {
			Arrays.fill(visited, false);
			if(dfs2(i)) answer++;
		}
		System.out.println(answer);
	}
	
	static boolean dfs1(int idx) {
		visited[idx] = true;
		
		for (int i=1; i<=m; i++) {
			if(arr[idx][i]==0) break;
			int v = arr[idx][i];
			if(B[v][0]==0 || (!visited[B[v][0]] && dfs1(B[v][0]))) {
				B[v][0] = idx; return true;
			}
		}
		return false;
	}
	static boolean dfs2(int idx) {
		visited[idx] = true;
		
		for (int i=1; i<=m; i++) {
			if(arr[idx][i]==0) break;
			int v = arr[idx][i];
			if(B[v][0]==0 || (!visited[B[v][0]] && dfs1(B[v][0]))) {
				B[v][0] = idx; return true;
			}
		}
		return false;
	}
	
}