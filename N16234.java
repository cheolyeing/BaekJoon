import java.io.*;
import java.util.*;
import java.awt.*;

public class N16234 {
	static boolean moved = false;
	static int n, l, r, ans=0;
	static int[][] pylon;
	static boolean[][] visited;
	static Point[] d = {new Point(1,0), new Point(0,1), new Point(-1,0), new Point(0,-1)};
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		pylon = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				pylon[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static void solution() {
		
		while(true) {
			moved = false;
			visited = new boolean[n+1][n+1];
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(!visited[i][j]) {
						bfs(new Point(i, j));
					}
				}
			}
			if(moved) ans++;
			else break;
			//System.out.println(ans);
			//showArr(pylon);
		}
		System.out.println(ans);
	}
	
	static boolean openable(Point P1, Point P2) {
		int gap = Math.abs(pylon[P1.x][P1.y]-pylon[P2.x][P2.y]);
		return (gap>=l && gap<=r);
	}
	
	static void bfs(Point p) {
		Queue<Point> q = new LinkedList<Point>();
		ArrayList<Point> list = new ArrayList<Point>();
		list.add(p);
		q.add(p);
		visit(p);
		int sum = pylon[p.x][p.y];
		
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			for(int i=0; i<4; i++) {
				Point np = new Point(tmp.x+d[i].x, tmp.y+d[i].y);
				
				if(inRange(np) && !visited(np) && openable(tmp, np)) {
					visit(np);
					q.add(np);
					list.add(np);
					sum += pylon[np.x][np.y];
				}
			}
		}
		
		for(int i=0; i<list.size(); i++) {
			Point tmp = list.get(i);
			if(list.size()>=2) {
				moved = true;
				pylon[tmp.x][tmp.y] = sum/list.size();
			} else visit(tmp);
		}
		
	}
	
	static boolean visited(Point p) {
		return visited[p.x][p.y];
	}
	
	static void visit(Point p) {
		visited[p.x][p.y] = !visited[p.x][p.y]; 
	}
	
	static boolean inRange(Point p) {
		return (p.x>0 && p.x<=n) && (p.y>0 && p.y<=n);
	}
	
	static void showArr(int[][] arr) {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				System.out.print(String.format("%3d", arr[i][j])+" ");
			} System.out.println();
		} System.out.println("--------------------------");
	}
}