import java.io.*;
import java.util.*;

public class N1867 {
	static int n;
	static int k;
	static int[][] map;
	static boolean[] visit;
	static int[] B;
	
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1]; 
		visit = new boolean[n+1]; B = new int[n+1];
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for(int j=1; j<=n; j++) {
				if(map[a][j]==0) {
					map[a][j] = b; break;
				}
			}
		}
		
		int answer = 0;
		
		for (int i=1; i<=n; i++) {
			Arrays.fill(visit, false);
			if(dfs(i)) answer++;
		} System.out.println(answer);
	}
	
	static boolean dfs(int start) {
		visit[start] = true;
		for (int i=1; i<=n; i++) {
			if(map[start][i]==0) break;
			int v = map[start][i];
			if(B[v]==0 || (!visit[B[v]] && dfs(B[v]))) {
				B[v] = start;
				return true;
			}
		}
		return false;
	}
}