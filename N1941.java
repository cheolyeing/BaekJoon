import java.io.*;
import java.util.*;
import java.awt.*;

public class N1941 {
	static int ans = 0;
	static int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
	static char[][] map = new char[5][5];
	
	public static void main(String[] args) throws IOException {
		setting();
		System.out.println(ans);
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<5; i++) {
			String input = br.readLine();
			for(int j=0; j<5; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		backTracking(new int[7], -1, 0);
	}
	
	static void solution(int[] arr) {
		Point[] p = intToPoint(arr);
		if(checkS(p) && connected(p)) ans++;
	}
	
	static void backTracking(int[] arr, int num, int cnt) {
		if(cnt==7) {
			solution(arr);
			return;
		}
		for(int i=num+1; i<25; i++) {
			arr[cnt] = i;
			backTracking(arr, i, cnt+1);
		}
	}
	
	static Point[] intToPoint(int[] arr) {
		Point[] res = new Point[7];
		for(int i=0; i<7; i++) {
			int x = arr[i]/5;
			int y = arr[i]%5;
			res[i] = new Point(x, y);
		}
		return res;
	}
	
	static boolean checkS(Point[] p) {
		int y = 0;
		for(int i=0; i<7; i++) if(map[p[i].x][p[i].y]=='Y') y++;
		return y<4;
	}
	
	static boolean connected(Point[] p) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(p[0]);
		boolean[] visited = new boolean[7];
		visited[0] = true;
		
		while(!q.isEmpty()) {
			int s = q.size();
			for(int i=0; i<s; i++) {
				Point t = q.poll();
				for(int j=0; j<4; j++) {
					int nx = t.x + d[j][0];
					int ny = t.y + d[j][1];
					for(int k=0; k<7; k++) {
						if(p[k].x==nx && p[k].y==ny && !visited[k]) {
							visited[k] = true;
							q.add(p[k]);
						}
					}
				}
			}
		}
		for(int i=0; i<7; i++) if(!visited[i]) return false;
		return true;
	}
}
