import java.io.*;
import java.util.*;
import java.awt.*;

public class N15683 {
	static int n, m, ans;
	static Point[] d = {new Point(1,0), new Point(0,1), new Point(-1,0), new Point(0,-1)};
	
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n+2][m+2]; ans = m*n;
		for (int i=0; i<n+2; i++) { map[i][0] = 6; map[i][m+1] = 6; }
		for (int i=0; i<m+2; i++) { map[0][i] = 6; map[n+1][i] = 6; }
		
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<=m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(new Point(1,1), map);
		System.out.println(ans);
	}
	
	static int[][] cctv1(int[][] cctv, int dir, Point p) { // d = 0 ~ 3
		Point np = new Point(p.x+d[dir].x, p.y+d[dir].y);
		int[][] ncctv = copy(cctv);
		while(ncctv[np.x][np.y]!=6) {
			if(ncctv[np.x][np.y]==0) ncctv[np.x][np.y] = 9; 
			np.x += d[dir].x;
			np.y += d[dir].y;
		}
		return ncctv;
	}
	
	static int[][] cctv2(int[][] cctv, int dir, Point p) { // d = 0 ~ 1
		return cctv1(cctv1(cctv, dir, p), dir+2, p);
	}
	
	static int[][] cctv3(int[][] cctv, int dir, Point p) { // d = 0 ~ 3
		return cctv1(cctv1(cctv, dir, p), (dir+1)%4, p);
	}
	
	static int[][] cctv4(int[][] cctv, int dir, Point p) { // d = 0 ~ 3
		return cctv1(cctv3(cctv, dir, p), (dir+2)%4, p);
	}
	
	static int[][] cctv5(int[][] cctv, Point p) { // d = 0
		return cctv1(cctv4(cctv, 0, p), 3, p);
	}
	
	static void dfs(Point p, int[][] cctv) {
		if(p.x>n) {
			ans = Math.min(ans, invisible(cctv));
			//showArray(cctv);
			return;
		}
		if(p.y>m) {dfs(new Point(p.x+1, 1), cctv); return;}
		
		if(cctv[p.x][p.y]==1) {
			for (int i=0; i<4; i++) {
				int[][] ncctv = cctv1(cctv, i, p);
				dfs(new Point(p.x, p.y+1), ncctv);
			}
		} else if(cctv[p.x][p.y]==2) {
			for (int i=0; i<2; i++) {
				int[][] ncctv = cctv2(cctv, i, p);
				dfs(new Point(p.x, p.y+1), ncctv);
			}
		} else if(cctv[p.x][p.y]==3) {
			for (int i=0; i<4; i++) {
				int[][] ncctv = cctv3(cctv, i, p);
				dfs(new Point(p.x, p.y+1), ncctv);
			}
			
		} else if(cctv[p.x][p.y]==4) {
			for (int i=0; i<4; i++) {
				int[][] ncctv = cctv4(cctv, i, p);
				dfs(new Point(p.x, p.y+1), ncctv);
			}
			
		} else if(cctv[p.x][p.y]==5) {
			int[][] ncctv = cctv5(cctv, p);
			dfs(new Point(p.x, p.y+1), ncctv);
		} else dfs(new Point(p.x, p.y+1), cctv);
	}
	
	static int invisible(int[][] cctv) {
		int sum = 0;
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				if(cctv[i][j]==0) sum++;
			}
		}
		return sum;
	}
	
	static void showArray(int[][] cctv) {
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				System.out.print(cctv[i][j]+" ");
			} System.out.println();
		} System.out.println("-----------");
	}
	
	static int[][] copy(int[][] cctv) {
		int[][] ncctv = new int[n+2][m+2];
		for (int i=0; i<n+2; i++) {
			for (int j=0; j<m+2; j++) {
				ncctv[i][j] = cctv[i][j];
			}
		}
		return ncctv;
	}
}