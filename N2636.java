import java.io.*;
import java.util.*;
import java.awt.*;

public class N2636 {
	static int r, c, cheese;
	static int[][] map;
	static boolean[][] visited;
	static Point[] d = {new Point(1,0), new Point(-1,0), new Point(0,1), new Point(0,-1)};
	
	public static void main(String[] args) throws IOException {
		input();
		solution();
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		
		for (int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) cheese++;
			}
		}
	}
	
	static void solution() {
		int remain = 0, time = 0;;
		while(cheese!=0) {
			remain = bfs();
			cheese -= remain;
			time++;
		}
		System.out.println(time+"\n"+remain);
	}
	
	static int bfs() {
		int delete = 0;
		visited = new boolean[r][c];
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(0, 0)); visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i=0; i<size; i++) {
				Point p = q.poll();
				for (int j=0; j<4; j++) {
					Point np = new Point(p.x+d[j].x, p.y+d[j].y);
					
					if(inRange(np) && !visited[np.x][np.y]) {
						visited[np.x][np.y] = true;
						if(map[np.x][np.y]==0) q.add(np);
						else {
							delete++;
							map[np.x][np.y] = 0; 
						}
					}
				}
			}
		}
		return delete;
	}
	
	static boolean inRange(Point p) {
		if(p.x>=0 && p.x<r && p.y>=0 && p.y<c) return true;
		else return false;
	}
}