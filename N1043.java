import java.io.*;
import java.util.*;

public class N1043 {
	static int n, m;
	static boolean[] visited;
	static boolean[] truth;
	static boolean[][] party;
	
	public static void main(String[] args) throws IOException {
		setting();
		System.out.println(solution());
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		truth = new boolean[n+1];
		party = new boolean[m][n+1];
		visited = new boolean[m];
		
		st = new StringTokenizer(br.readLine());
		int know = Integer.parseInt(st.nextToken());
		for (int i=0; i<know; i++) {
			truth[Integer.parseInt(st.nextToken())] = true;
		}
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			for (int j=0; j<p; j++) {
				int per = Integer.parseInt(st.nextToken());
				party[i][per] = true;
				if(truth[per]) party[i][0] = true;
			}
		}
	}
	
	static void dfs(int p) {
		visited[p] = true;
		for(int i=1; i<=n; i++) {
			if(party[p][i]) {
				for(int j=0; j<m; j++) {
					if(party[j][i] && !visited[j]) {
						party[j][0] = true;
						dfs(j);
					}
				}
			}
		}
	}
	
	static int solution() {
		for (int i=0; i<m; i++) {
			if(party[i][0]) {
				dfs(i);
			}
		}
		int res=0;
		for (int i=0; i<m; i++) {
			if(!party[i][0]) res++;
		}
		return res;
	}
}