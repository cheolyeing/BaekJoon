import java.io.*;
import java.util.*;
import java.util.List;
import java.awt.*;


public class N14502 {
	static int n, m;
	static int[][] lab;
	static boolean[][] visit;
	static int answer = 0, wall = 0;
	static int[][] d = { {1,0}, {-1,0}, {0,1}, {0,-1} };
	static List<Point> fq = new ArrayList<>();
	
	static void bfs() {
		Queue<Point> q = new LinkedList();
		int virus = fq.size();
		
		for (Point p : fq) { 
			q.add(p);
			visit[p.x][p.y] = true;
		}
		
		while(!q.isEmpty()) {
			
			for (int i=0; i<q.size(); i++) {
				Point p = q.poll();
				for (int j=0; j<4; j++) {
					Point np = new Point(p.x+d[j][0], p.y+d[j][1]);
					if(expand(np)) {
						q.add(np); virus++; visit[np.x][np.y] = true; 
					}
				}
			}
		}
		if(answer<n*m-virus-wall-3) {
			answer = n*m-virus-wall-3;
		}
	}
	
	static boolean expand(Point p) {
		if(p.x>0 && p.x<=n && p.y>0 && p.y<=m && lab[p.x][p.y]==0 && !visit[p.x][p.y]) return true;
		else return false;
	}
	
	static void solution() {
		visit = new boolean[n+1][m+1];
		bfs();
	}
	
	static void selectThree(int num) {
		if(num==3) { solution(); return; }
		
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				if(lab[i][j]==0) {
					lab[i][j]=1; selectThree(num+1);
					lab[i][j]=0;
				}
			}
		}
	}
	
	static void showArray() {
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				System.out.print(lab[i][j]+" ");
			} System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		
		lab = new int[n+1][m+1];
		
		for (int i=1; i<=n; i++) {
			input = br.readLine().split(" ");
			for (int j=1; j<=m; j++) {
				lab[i][j] = Integer.parseInt(input[j-1]);
				if(lab[i][j]==2) {
					fq.add(new Point(i, j));
				} else if(lab[i][j]==1) wall++;
			}
		}
		selectThree(0);
		System.out.println(answer);
	}
}