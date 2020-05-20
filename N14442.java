import java.io.*;
import java.util.*;

public class N14442 {
	static int n, m, k, map[][];
	static int[][] d = {{1,0},{0,1},{-1,0},{0,-1}};
	static class Point {
		int x, y, t;
		public Point(int x, int y, int t) {
			this.x = x; this.y = y; this.t = t;
		}
	}
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
	}
	
	static void solution() {
		Queue<Point> q = new LinkedList<Point>();
		boolean[][][] visited = new boolean[n][m][k+1];
		int move = 1;
		q.add(new Point(0, 0, 0));
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0; i<size; i++) {
				Point p = q.poll();
				if(p.x==n-1 && p.y==m-1) {
					System.out.println(move);
					System.exit(0);
				}
				for(int z=0; z<4; z++) {
					Point np = new Point(p.x+d[z][0], p.y+d[z][1], p.t);
					if(!inRange(np)) continue;
					if(map[np.x][np.y]==1) {
						if(++np.t>k) continue;
						if(!visited[np.x][np.y][np.t]) {
							visited[np.x][np.y][np.t] = true; 
							q.add(np);
						}
					} else {
						if(!visited[np.x][np.y][np.t]) {
							visited[np.x][np.y][np.t] = true; 
							q.add(np);
						}
					}
				}
			}
			move++;
		}
		System.out.println(-1);
	}
	
	static boolean inRange(Point p) {
		return 0<=p.x && p.x<n && 0<=p.y && p.y<m;
	}
}
