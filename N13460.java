import java.io.*;
import java.util.*;
import java.awt.*;
public class N13460 {
	static int n, m;
	static boolean finish = false;
	static char[][] map;
	static boolean[][][][] visited;
	static Point[] d = {new Point(1,0), new Point(-1,0), new Point(0,1), new Point(0,-1)};
	
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visited = new boolean[n][m][n][m];
		Point red=new Point(0,0), blue=new Point(0,0);
		for (int i=0; i<n; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j=0; j<m; j++) {
				map[i][j] = input[j];
				
				if(map[i][j]=='R') {
					map[i][j] = '.';
					red = new Point(i, j);
				}
				else if(map[i][j]=='B') {
					map[i][j] = '.';
					blue = new Point(i, j);
				}
			}
		}
		bfs(red, blue);
	}
	
	static boolean inRange(Point p) {
		if(p.x>=0 && p.x<n && p.y>=0 && p.y<m) return true;
		else return false;
	}
	
	static Point[] move(int direct, Point red, Point blue) {
		if(direct<=1) {
			if(red.y==blue.y) {
				if(direct==0) {
					if(red.x>blue.x) {
						red = movePoint(direct, red);
						blue = movePoint(direct, blue);
						if(red.equals(blue)) blue.x--;
					} else {
						blue = movePoint(direct, blue);
						red = movePoint(direct, red);
						if(red.equals(blue)) red.x--;
					}
				} else {
					if(red.x>blue.x) {
						red = movePoint(direct, red);
						blue = movePoint(direct, blue);
						if(red.equals(blue)) red.x++;
					} else {
						blue = movePoint(direct, blue);
						red = movePoint(direct, red);
						if(red.equals(blue)) blue.x++;
					}
				}
			} else {
				red = movePoint(direct, red);
				blue = movePoint(direct, blue);
			}
		} else {
			if(red.x==blue.x) {
				if(direct==2) {
					if(red.y>blue.y) {
						red = movePoint(direct, red);
						blue = movePoint(direct, blue);
						if(red.equals(blue)) blue.y--;
					} else {
						blue = movePoint(direct, blue);
						red = movePoint(direct, red);
						if(red.equals(blue)) red.y--;
					}
				} else {
					if(red.y>blue.y) {
						red = movePoint(direct, red);
						blue = movePoint(direct, blue);
						if(red.equals(blue)) red.y++;
					} else {
						blue = movePoint(direct, blue);
						red = movePoint(direct, red);
						if(red.equals(blue)) blue.y++;
					}
				}
			} else {
				red = movePoint(direct, red);
				blue = movePoint(direct, blue);
			}
		}
		Point[] res = {red, blue};
		return res;
	}
	
	static boolean sameLine(int direct, Point red, Point blue) {
		if(direct<=1) return red.y==blue.y;
		else return red.x==blue.x;
	}
	
	static Point movePoint(int direct, Point p) {
		Point np = new Point(p.x, p.y);
		int nx = p.x, ny = p.y;
		
		while (true) {
			np = new Point(nx, ny);
			nx += d[direct].x;
			ny += d[direct].y;
			if(map[nx][ny]=='O') return new Point(-1, -1);
			if(!inRange(new Point(nx,ny)) || !(map[nx][ny]=='.')) break;
			
		}
		return np;
	}
	
	static void bfs (Point r, Point b) {
		Queue<Point[]> q = new LinkedList<Point[]>();
		Point[] tmp = {r, b};
		q.add(tmp);
		visited[r.x][r.y][b.x][b.y] = true;
		int time = 0;
		
		Loop:
		while(!q.isEmpty()) {
			int size = q.size();
			if(time==10) break Loop;
			for (int i=0; i<size; i++) {
				tmp = q.poll();
				
				for (int k=0; k<4; k++) {
					Point[] res = move(k, tmp[0], tmp[1]);
					if(res[0].x==-1 && res[0].y==-1) {
						if(!(res[1].x==-1 || res[1].y==-1)) {
							System.out.println(time+1); System.exit(0);
						} else continue;
					}
					if(res[1].x==-1 || res[1].y==-1) continue;
					if(!visited[res[0].x][res[0].y][res[1].x][res[1].y]) {
						visited[res[0].x][res[0].y][res[1].x][res[1].y] = true;
						q.add(res);
					}
				}
			}
			time++;
		}
		System.out.println(-1);
	}
}