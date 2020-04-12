import java.io.*;
import java.util.*;

public class N2178 {
	
	static int m, n;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static int answer = 1;
	static Queue<Integer[]> q = new LinkedList<Integer[]>();
	
	static boolean bfs()
	{
		boolean finish = false;
		int L = q.size();
		
		for (int i=0; i<L; i++) {
			Integer[] now = q.poll();
			int x = now[0], y = now[1];
			if(x==m-1 && y==n-1) { finish = true; break;}
			
			for(int j=0; j<4; j++) {
				int nx = x + dx[j], ny = y + dy[j];
				if(next(nx, ny)) {
					Integer[] tmp = {nx, ny};
					q.offer(tmp);
				}
			}
		}
		return finish;
	}
	
	static boolean inrange(int x, int y) {
		if(x>=0 && x<m && y>=0 && y<n) { return true; }
		else { return false; }
	}
	
	static boolean next(int x, int y) {
		if(inrange(x, y) && map[x][y]==1 && !visit[x][y]) {
			visit[x][y] = true; return true;
		} else { return false; }
	}
	
	static void setting() {
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				map[i][j] = 0; visit[i][j]=false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[m][n]; visit = new boolean[m][n];
		setting();
		
		for (int i=0; i<m; i++) {
			
			String input = br.readLine();
			
			for (int j=0; j<n; j++) {
				map[i][j] = input.charAt(j)-'0';
			}
		}
		
		Integer[] tmp = {0, 0};
		q.offer(tmp);
		
		while(!bfs()) {
			answer++;
		}
		System.out.println(answer);
	}
}