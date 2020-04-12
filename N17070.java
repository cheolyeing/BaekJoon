import java.io.*;
import java.util.*;
import java.util.List;
import java.awt.*;

public class N17070 {
	static int n;
	static int[][] home;
	static int status = 0; // 0 : 가로, 1 : 대각선, 2 : 세로
	static List<Point>[] next = new List[3];
	static int answer = 0;
	static Point p1 = new Point(0,1);
	static Point p2 = new Point(1,1);
	static Point p3 = new Point(1,0);
	
	public static void main(String[] args) throws IOException {
		setting();
		setPoint();
		dfs(new Point(0,1), 0);
		System.out.println(answer);
	}
	
	static void setting () throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		home = new int[n][n];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				home[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static boolean inRange(Point p, Point ap) {
		if(ap.equals(p2)) {
			if(p.x<n && p.y<n && home[p.x][p.y]==0 && home[p.x-1][p.y]==0 && home[p.x][p.y-1]==0) return true;
			else return false;
		} else {
			if(p.x<n && p.y<n && home[p.x][p.y]==0) return true;
			else return false;
		}
	}
	
	static void dfs(Point p, int status) {
		if(p.x==n-1 && p.y==n-1) {answer++; return;}
		
		for (Point ap : next[status]) {
			Point np = new Point(p.x+ap.x, p.y+ap.y);
			if(inRange(np, ap)) {
				int ns = 0;
				if(ap.equals(p1)) ns = 0;
				else if(ap.equals(p2)) ns = 1;
				else ns = 2;
				dfs(np, ns);
			}
		}
	}
	
	static void setPoint() {
		next[0] = new ArrayList<Point>();
		next[1] = new ArrayList<Point>();
		next[2] = new ArrayList<Point>();
		
		next[0].add(p1); next[0].add(p2);
		next[1].add(p1); next[1].add(p2); next[1].add(p3);
		next[2].add(p2); next[2].add(p3);
	}
}