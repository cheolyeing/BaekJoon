import java.io.*;
import java.util.*;
import java.awt.*;

public class N17142 {
	static int n, m, w, v, ans=Integer.MAX_VALUE;
	static int[][] map;
	static int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
	static ArrayList<Point> virus = new ArrayList<Point>();
	
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+2][n+2];
		// 0:외부, 1:벽, 2:바이러스, 3:빈칸
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) w++;
				else if(map[i][j]==2) {
					v++;
					virus.add(new Point(i, j));
				}
				else if(map[i][j]==0) map[i][j] = 3;
			}
		}
	}
	
	static void solution() {
		backTracking(new int[m], 0, 0);
		System.out.println(ans==Integer.MAX_VALUE ? -1 : ans);
	}
	
	static void bfs(int[] arr) {
		Queue<Point> q = new LinkedList<Point>();
		int[][] cmap = copiedMap();
		for(int i=0; i<m; i++) {
			Point p = virus.get(arr[i]);
			cmap[p.x][p.y] = 4;
			q.add(p);
		}
		
		int vi = v;
		int time=-1;
		
		while(!q.isEmpty()) {
			//showMap(cmap);
			if(vi==n*n-w) {
				time++;
				break;
			}
			int size = q.size();
			for(int i=0; i<size; i++) {
				Point p = q.poll();
				for(int k=0; k<4; k++) {
					Point np = new Point(p.x+d[k][0], p.y+d[k][1]);
					if(cmap[np.x][np.y]==0) continue;
					if(cmap[np.x][np.y]==2 || cmap[np.x][np.y]==3) {
						if(cmap[np.x][np.y]==3) vi++;
						cmap[np.x][np.y] = 4;
						q.add(np); 
					}
				}
			}
			time++;
		}
		//System.out.println("***** RESULT : "+time);
		if(vi==n*n-w) ans = Math.min(ans, time); 
	}
	
	static void backTracking(int[] arr, int num, int start) {
		if(num==m) {
			bfs(arr);
			return;
		}
		for(int i=start; i<v; i++) {
			arr[num] = i;
			backTracking(arr, num+1, i+1);
		}
	}
	
	static int[][] copiedMap() {
		int[][] cmap = new int[n+2][n+2];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				cmap[i][j] = map[i][j];
			}
		}
		return cmap;
	}
	
	static void showMap(int[][] map) {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				char s = ' ';
				if(map[i][j]==1) s = '-';
				if(map[i][j]==2) s = 'x';
				if(map[i][j]==3) s = ' ';
				if(map[i][j]==4) s = 'o';
				System.out.print(s);
			} System.out.println();
		} System.out.println("---------------------");
	}
}
