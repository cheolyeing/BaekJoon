import java.io.*;
import java.util.*;

public class N14503 {
	static int n, m, ans=0;
	static int[][] map;
	static boolean[][] visited;
	static boolean robotStop = false;
	static class Point {
		int x;
		int y;
		int d;
		public Point(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	static Point[] next = {new Point(-1, 0, 3), new Point(0, 1, 0), new Point(1, 0, 1), new Point(0, -1, 2)};
	
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = s2i(st.nextToken());
		m = s2i(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		
		st = new StringTokenizer(br.readLine());
		Point now = new Point(s2i(st.nextToken()), s2i(st.nextToken()), s2i(st.nextToken()));
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++) map[i][j] = s2i(st.nextToken());
		}
		bfs(now);
	}
	
	static int status(Point p) {
		return map[p.x][p.y];
	}
	
	static Point action1(Point p) {
		if(status(p)==0 && !visited(p)) {
			//System.out.println(p.x+" "+p.y);
			visit(p); ans++;
		}
		return p;
	}
	
	static Point action2(Point p) {
		boolean noWhere = true;
		Point np = new Point(0, 0, 0);
		
		for (int i=0; i<4; i++) {
			np = new Point(p.x+next[i].x, p.y+next[i].y, next[i].d);
			if(inRange(np) && status(np)==0 && !visited(np)) {
				noWhere = false; break;
			}
		}
		if(noWhere) {
			np = new Point(p.x-next[p.d].x, p.y-next[p.d].y, p.d);
			//System.out.println("NoWhere : "+ np.x+" "+np.y+" "+np.d);
			if(inRange(np) && status(np)==0) {
				return action2(np);
			} else {
				System.out.println(ans); System.exit(0);
			}
		} else {
			np = new Point(p.x+next[(p.d+3)%4].x, p.y+next[(p.d+3)%4].y, next[p.d].d);
			if(inRange(np) && status(np)==0 && !visited(np)) {
				return action1(np);
			} else {
				p.d = np.d;
				return action2(p);
			}
		}
		
		
		return p; 
	}
	
	static void bfs (Point p) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(p);
		
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i=0; i<size; i++) {
				Point tmp = q.poll();
				if(visited(tmp)) q.add(action2(tmp));
				else q.add(action1(tmp));
			}
		}
		System.out.println(ans);
	}
	
	static boolean inRange(Point p) {
		if(p.x>=0 && p.x<n && p.y>=0 && p.y<m) return true;
		else return false;
	}
	
	static boolean visited(Point p) {
		return visited[p.x][p.y];
	}
	
	static void visit(Point p) {
		visited[p.x][p.y] = true; 
	}
	
	static int s2i(String s) {
		return Integer.parseInt(s);
	}
}
