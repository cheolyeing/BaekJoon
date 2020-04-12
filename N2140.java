import java.io.*;
import java.util.*;
import java.awt.*;

public class N2140 {
	static int n, map[][], answer=0;
	static boolean[][] visited;
	static int count = 0;
	static Point[] d = {new Point(1,-1), new Point(1,0), new Point(1,1), new Point(0,1), new Point(0,-1), new Point(-1,-1), new Point(-1,0), new Point(-1,1)};
	public static void main(String[] args) throws IOException {
		setting();
		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		visited = new boolean[n+1][n+1];
		
		for (int i=1; i<=n; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j=1; j<=n; j++) {
				if((int)input[j-1]-(int)'0'>=0) {
					map[i][j] = (int)input[j-1]-(int)'0';
				} else {
					map[i][j] = -1;
				}
			}
		}
		
		while(count!=4*n-4) {
			//System.out.println(count);
			for (int i=1; i<=n; i++) {
				Point p = new Point(1, i);
				find(p);
			}
			for (int i=1; i<=n; i++) {
				Point p = new Point(n, i);
				find(p);
			}
			for (int i=2; i<n; i++) {
				Point p = new Point(i, 1);
				find(p);
			}
			for (int i=2; i<n; i++) {
				Point p = new Point(i, n);
				find(p);
			}
		}
		for (int i=2; i<n; i++) {
			for (int j=2; j<n; j++) {
				if(map[i][j]==-1) answer++;
			}
		}
		System.out.println(answer);
	}
	
	static void find(Point p) {
		if(visited[p.x][p.y]) return;
		int tmp = numNext(p);
		int cand = tmp/10;
		int mine = tmp%10;
		if(map[p.x][p.y]==mine) {
			//System.out.println(p+"***");
			visited[p.x][p.y] = true; count++;
			makeSafe(p);
		}
		else if(map[p.x][p.y]==cand+mine) {
			//System.out.println(p+"***");
			candToMine(p); visited[p.x][p.y] = true; count++;
			makeSafe(p);
		}
	}
	
	static boolean inRange(Point p) {
		if(p.x>0 && p.x<=n && p.y>0 && p.y<=n) return true;
		else return false;
	}
	
	static int numNext(Point p) {
		int cand = 0;
		int mine = 0;
		for (int i=0; i<8; i++) {
			Point np = new Point(p.x+d[i].x, p.y+d[i].y);
			if(inRange(np)) {
				if(map[np.x][np.y]==-1) cand++;
				if(map[np.x][np.y]==-2) mine++;
			}
		}
		return 10*cand + mine;
		// cand : /10, mine : %10
	}
	
	static void candToMine(Point p) {
		for (int i=0; i<8; i++) {
			Point np = new Point(p.x+d[i].x, p.y+d[i].y);
			if(inRange(np)) {
				if(map[np.x][np.y]==-1) {
					//System.out.println(np);
					map[np.x][np.y]=-2; answer++;
				}
			}
		}
	}
	
	static void makeSafe(Point p) {
		for (int i=0; i<8; i++) {
			Point np = new Point(p.x+d[i].x, p.y+d[i].y);
			if(inRange(np)) {
				if(map[np.x][np.y]==-1) {
					map[np.x][np.y]=0;
				}
			}
		}
	}
}