import java.io.*;
import java.util.*;

public class N2468 {
	
	static int[][] map;
	static boolean[][] visit;
	static int n;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static void dfs(int x, int y, int depth) {
		visit[x][y] = true;
		
		for (int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(!visit[nx][ny] && map[nx][ny]>depth) {
				dfs(nx, ny, depth);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n+2][n+2]; visit = new boolean[n+2][n+2];
		
		int answer = 1;
		int safety;
		int maxdepth = 0;
		int mindepth = 1;
		
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxdepth = Math.max(maxdepth, map[i][j]);
				mindepth = Math.min(mindepth, map[i][j]);
			}
		}
		
		for (int k=mindepth-1; k<=maxdepth; k++) { 
			visit = new boolean[n+2][n+2]; safety = 0;
			for (int i=1; i<=n; i++) {
				for (int j=1; j<=n; j++) {
					if(map[i][j]>k && !visit[i][j]) {
						safety++; dfs(i, j, k);
					}
				}
			} answer = Math.max(safety, answer);	
		} 
		System.out.println(answer);
	}
}