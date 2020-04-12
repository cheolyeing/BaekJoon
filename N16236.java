import java.io.*;
import java.awt.*;
import java.util.*;
public class N16236 {
	static int n, shark=2, eat=0, answer=0;
	static int[][] map;
	static Point sharkPos, targetPos;
	static boolean[][] visited;
	static Point[] d = {new Point(1,0), new Point(-1,0), new Point(0,1), new Point(0,-1)};
	public static void main(String[] args) throws IOException {
		setting();
		eat();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		for (int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9) sharkPos = new Point(i, j);
			}
		}
	}
	
	static void eat() {
		int dist = bfs();
		if(dist==Integer.MAX_VALUE) {
			System.out.println(answer); System.exit(0);
		} else {
			map[sharkPos.x][sharkPos.y] = 0;
			map[targetPos.x][targetPos.y] = 9;
			sharkPos = targetPos;
			eat++;
			if(eat==shark) {
				shark++; eat = 0;
			}
			answer += dist;
		}
		eat();
	}
	
	static int bfs() {
		visited = new boolean[n][n];
		Queue<Point> q = new LinkedList<Point>();
		q.add(sharkPos); visit(sharkPos);
		int dist = 0;
		boolean find = false;
		targetPos = new Point(n, n);
		
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i=0; i<size; i++) {
				Point p = q.poll();
				if(!p.equals(sharkPos) && map[p.x][p.y]!=0 && map[p.x][p.y]<shark) {
					find = true;
					if(targetPos.x>p.x) targetPos = p;
					else if(targetPos.x==p.x && targetPos.y>p.y) targetPos = p;
				}
				if(!find) {
					for (int k=0; k<4; k++) {
						Point np = new Point(p.x+d[k].x, p.y+d[k].y);
						if(inRange(np) && !visited(np) && map[np.x][np.y]<=shark) {
							visit(np); q.add(np);
						}
					}
				}
			}
			if(find) break; dist++;
		}
		return find ? dist : Integer.MAX_VALUE;
	}
	
	static void visit(Point p) {
		visited[p.x][p.y] = true; 
	}
	
	static boolean visited(Point p) {
		return visited[p.x][p.y];
	}
	
	static boolean inRange(Point p) {
		if(p.x>=0 && p.x<n && p.y>=0 && p.y<n) return true;
		else return false;
	}
}