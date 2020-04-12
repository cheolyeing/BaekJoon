import java.io.*;
import java.util.*;

public class N9466 {
	static int n;
	static int[] team;
	static boolean[] visited;
	static boolean[] answer;
	static int count;
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		
		for (int i=0; i<tc; i++) {
			n = Integer.parseInt(br.readLine());
			team = new int[n+1];
			answer = new boolean[n+1];
			visited = new boolean[n+1];
			st  = new StringTokenizer(br.readLine());
			for (int j=1; j<=n; j++) {
				team[j] = Integer.parseInt(st.nextToken());
			}
			
			count = 0;
			for (int j=1; j<=n; j++) {
				if(!visited[j]) dfs(j);
			}
			System.out.println(n-count);
		}
	}
	
	static void dfs(int idx) {
		visited[idx] = true;
		int next = team[idx];
		if(!visited[next]) dfs(next);
		else if(!answer[next]) {
			for (int i=next; i!=idx; i=team[i])	count++;
			count++;
		}
		answer[idx] = true;
	}
}