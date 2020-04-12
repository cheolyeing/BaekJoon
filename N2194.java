import java.io.*;
import java.util.*;
import java.awt.*;

public class N2194 {
	static int n, m, a, b, k;
	static boolean[][] visited;
	static boolean[][] map;
	static Point[] d = {new Point(1,0), new Point(-1,0), new Point(0,1), new Point(0,-1)};
	static Point start, finish;
	
	public static void main(String[] args) throws IOException {
		setting();
		bfs();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		visited = new boolean[n+1][m+1];
		map = new boolean[n+1][m+1];
		
		for (int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
		}
		
		st = new StringTokenizer(br.readLine());
		start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		st = new StringTokenizer(br.readLine());
		finish = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
	}
	
	static void bfs() {
		Queue<Point> q = new LinkedList();
		q.add(start);
		visit(start);
		int time = 0;
		
		while(!q.isEmpty()) {

			int size = q.size();
			for (int z=0; z<size; z++) {
				Point p = q.poll();
				
				if(p.equals(finish)) {
					System.out.println(time); System.exit(0);
				}
				
				for (int i=0; i<4; i++) {
					Point np = new Point(p.x+d[i].x, p.y+d[i].y);
					if(inRange(np) && bodyCheck(np) && !visited(np)) {
						q.add(np); visit(np);
					}
				}
			}
			time++;
		}
		System.out.println(-1);
	}
	
	static boolean bodyCheck(Point p) {
		Point end = new Point(p.x+a-1, p.y+b-1);
		if(!inRange(end)) return false;
		
		for (int i=0; i<a; i++) {
			for (int j=0; j<b; j++) {
				if(map[p.x+i][p.y+j]) return false;
			}
		}
		return true;
	}
	
	static boolean inRange(Point p) {
		if(0<p.x && p.x<=n && 0<p.y && p.y<=m) return true;
		else return false;
	}
	
	static void visit(Point p) {
		visited[p.x][p.y] = true; 
	}
	
	static boolean visited(Point p) {
		return visited[p.x][p.y];
	}
}