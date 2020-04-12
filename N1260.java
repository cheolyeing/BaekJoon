import java.io.*;
import java.util.*;

public class N1260 {
	
	static int n;
	static boolean[][] graph;
	static boolean[] visit;
	static Queue que = new LinkedList<Integer>();
	
	public static void main(String[] args) throws IOException {
		setting();
		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		graph = new boolean[n+1][n+1];
		int m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = true; graph[b][a] = true;
		}
		
		visit = new boolean[n+1];
		dfs(start);
		System.out.println();
		visit = new boolean[n+1];
		bfs(start);
	}
	
	static void dfs(int s) {
		visit[s] = true;
		System.out.print(s+" ");
		for (int i=0; i<=n; i++) {
			if(graph[s][i] && !visit[i]) {
				dfs(i);
			}
		}
	}
	
	static void bfs(int s) {
		
		que.add(s); visit[s] = true;
		
		while(!que.isEmpty()) {
			int num = (int)que.poll();
			System.out.print(num+" ");
			
			for (int i=0; i<=n; i++) {
				if(graph[num][i] && !visit[i]) {
					visit[i] = true; que.add(i);
				}
			}
		}
	}
}
