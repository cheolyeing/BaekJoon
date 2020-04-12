import java.io.*;
import java.util.*;
import java.awt.*;

public class N17135 {
	static int n, m, d, ans=0;
	static int[][] map;
	static int[][] next = {{0,-1}, {-1,0}, {0,1}};
	static boolean[][][] defender;
	
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting() throws IOException {
		InputStreamReader sr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(sr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		map = new int[n+1][m];
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] arr = new int[3];
		backTracking(0, 0, arr);
		System.out.println(ans);
	}
	
	static Point archer(Point start, boolean[][] visited) {
		Point dest = new Point(n, m);
		int dist = 1;
		Queue<Point> q = new LinkedList<Point>();
		q.add(start);
		while(!q.isEmpty()) {
			if(dist>d) {q.clear(); return dest;}
			int size = q.size();
			for (int i=0; i<size; i++) {
				Point p = q.poll();
				if(map[p.x][p.y]==1 && !visited[p.x][p.y]) {q.clear(); return p;}
				for (int j=0; j<3; j++) {
					Point np = new Point(p.x+next[j][0], p.y+next[j][1]);
					if(inRange(np)) q.add(np);
				}
			} 
			dist++;
		}
		q.clear();
		return dest;
	}
	
	static int game(int[] arr) {
		boolean[][] visited = new boolean[n+1][m+1];
		
		for (int i=1; i<=n; i++) {
			Point[] start = new Point[3];
			Point[] finish = new Point[3];
			
			for (int a=0; a<3; a++) {
				start[a] = new Point(n-i, arr[a]);
				finish[a] = archer(start[a], visited);
			}
			for (int a=0; a<3; a++) visited[finish[a].x][finish[a].y] = true;
		}
		
		int res = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if(visited[i][j]) res++;
			}
		}
		return res;
	}
	
	static void backTracking(int num, int idx, int[] arr) {
		if(num>=3) {
			ans = Math.max(ans, game(arr)); return;
		}
		
		for (int i=idx; i<m; i++) {
			arr[num] = i;
			backTracking(num+1, idx+1, arr);
		}
	}
	
	static boolean inRange(Point p) {
		if(p.x>=0 && p.y>=0 && p.y<m) return true;
		else return false;
	}
}