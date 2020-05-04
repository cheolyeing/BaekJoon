import java.io.*;
import java.util.*;
import java.awt.*;

public class N17472 {
	static int n, m, island=0, ans=Integer.MAX_VALUE;
	static int[][] map, bridge;
	static int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean[][] visited;
	static boolean[] connected;
	
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+2][m+2];
		visited = new boolean[n+2][m+2];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static void solution() {
		findIsland();
		bridge = new int[island+1][island+1];
		makeBridge();
		//showMap();
		//showBridge();
		connected = new boolean[island+1];
		connected[1] = true;
		connectDFS(0);
		System.out.println(ans==Integer.MAX_VALUE ? -1 : ans);
	}
	
	static boolean allConnected() {
		for(int i=1; i<=island; i++) {
			if(!connected[i]) return false;
		} return true;
	}
	
	static void connectDFS(int len) {
		if(allConnected()) {
			ans = Math.min(ans, len);
			return;
		}
		for(int a=1; a<=island; a++) {
			if(connected[a]) {
				for(int i=1; i<=island; i++) {
					if(a==i) continue;
					if(bridge[a][i]!=0 && !connected[i]) {
						//System.out.println("connect : "+a+"-"+i);
						connected[i] = true;
						connectDFS(len+bridge[a][i]);
						connectDFS(len+bridge[a][i]);
						connected[i] = false;
					}
				}
			}
		}
	}
	
	static void findIsland() {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(map[i][j]!=0 && !visited[i][j]) {
					bfs(new Point(i, j));
				}
			}
		}
	}
	
	static void bfs(Point p) {
		island++;
		Queue<Point> q = new LinkedList<Point>();
		visit(p);
		q.add(p);
		
		while(!q.isEmpty()) {
			int s = q.size();
			for(int i=0; i<s; i++) {
				p = q.poll();
				map[p.x][p.y] = island; 
				for(int k=0; k<4; k++) {
					Point np = new Point(p.x+d[k][0], p.y+d[k][1]);
					if(map[np.x][np.y]!=0 && !visited(np)) {
						visit(np);
						q.add(np);
					}
				}
			}
		}
	}
	
	static void makeBridge() {
		for(int i=1; i<=island; i++) {
			for(int j=i+1; j<=island; j++) {
				lenBridge(i, j);
			}
		}
	}
	
	static void lenBridge(int a, int b) {
		int L = Integer.MAX_VALUE;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(map[i][j]==a) {
					for(int k=0; k<4; k++) {
						Point p = new Point(i+d[k][0], j+d[k][1]);
						if(map[p.x][p.y]==0) {
							int l = dfs(b, 0, p, k);
							if(l>1) L = Math.min(L, l);
						}
					}
				}
			}
		}
		bridge[a][b] = L==Integer.MAX_VALUE ? 0 : L;
		bridge[b][a] = L==Integer.MAX_VALUE ? 0 : L;
	}
	
	static int dfs(int tar, int len, Point p, int dir) {
		if(!inRange(p)) return 0;
		if(len!=0 && map[p.x][p.y]!=0 && map[p.x][p.y]!=tar) return 0;
		if(map[p.x][p.y]==tar) return len==1 ? 0 : len;
		Point np = new Point(p.x+d[dir][0], p.y+d[dir][1]);
		return dfs(tar, len+1, np, dir);
	}
	
	static void showMap() {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				System.out.print(map[i][j]+" ");
			} System.out.println();
		} System.out.println("---------------");
	}
	
	static void showBridge() {
		for(int i=1; i<=island; i++) {
			for(int j=1; j<=island; j++) {
				System.out.print(bridge[i][j]+" ");
			} System.out.println();
		} System.out.println("--------------");
	}
	
	static boolean inRange(Point p) {
		return 0<p.x && p.x<=n && 0<p.y && p.y<=m;
	}
	
	static void visit(Point p) {
		visited[p.x][p.y] = true; 
	}
	
	static boolean visited(Point p) {
		return visited[p.x][p.y];
	}
}
