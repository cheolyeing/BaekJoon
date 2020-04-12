import java.io.*;
import java.util.*;
public class N1405 {
	static int n; 
	static double proE, proW, proS, proN;
	static double answer = 0;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		proE = Integer.parseInt(st.nextToken())/(double)100;
		proW = Integer.parseInt(st.nextToken())/(double)100;
		proS = Integer.parseInt(st.nextToken())/(double)100;
		proN = Integer.parseInt(st.nextToken())/(double)100;
		
		visited = new boolean[2*n+1][2*n+1];
		visited[n][n] = true;
		dfs(0, n, n, 1);
		System.out.println(answer);
	}
	
	static void dfs(int time, int x, int y, double percent) {
		
		if(time==n) {
			answer+=percent; return;
		}
		
		
		if(!visited[x][y+1]) {
			visited[x][y+1] = true;
			dfs(time+1, x, y+1, percent*proE);
			visited[x][y+1] = false;
		}			
		
		if(!visited[x][y-1]) {
			visited[x][y-1] = true;
			dfs(time+1, x, y-1, percent*proW);
			visited[x][y-1] = false;
		}
		
		if(!visited[x+1][y]) {
			visited[x+1][y] = true;
			dfs(time+1, x+1, y, percent*proS);
			visited[x+1][y] = false;
		}
		
		if(!visited[x-1][y]) {
			visited[x-1][y] = true;
			dfs(time+1, x-1, y, percent*proN);
			visited[x-1][y] = false;
		}
	}
}