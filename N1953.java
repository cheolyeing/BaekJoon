import java.io.*;
import java.util.*;
public class N1953 {
	static int n;
	static int[][] hater;
	static boolean[] team;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		input();
	}
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		hater = new int[n+1][n+1];
		team = new boolean[n+1]; visited = new boolean[n+1];
		for (int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j=1; j<=num; j++) {
				hater[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i=1; i<=n; i++) {
			if(!visited[i]) dfs(i);
		}
		printAnswer();
	}
	
	static void dfs(int start) {
		visited[start] = true;
		for(int i=1; i<=n; i++) {
			if(hater[start][i]==0) return;
			if(!visited[hater[start][i]]) {
				team[hater[start][i]] = !team[start];
				dfs(hater[start][i]);
			}
		}
	}
	
	static void printAnswer() {
		int teamA=0, teamB=0;
		String memberA="", memberB="";
		for(int i=1; i<=n; i++) {
			if(team[i]) {
				teamA++; memberA += i+" ";
			} else {
				teamB++; memberB += i+" ";
			}
		}
		System.out.println(teamA+"\n"+memberA);
		System.out.println(teamB+"\n"+memberB);
	}
}