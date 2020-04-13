import java.io.*;
import java.util.*;

public class N1600 {
	static int k, w, h, ans=0;
	static int[][] map;
	static int[][][] visited;
	static int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
	static int[][] horse = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
	static class Status {
		int horse;
		int x;
		int y;
		public Status(int x, int y, int horse) {
			this.x = x; this.y = y; this.horse = horse;
		}
	}
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[h][w];
		visited = new int[h][w][2];
		
		for(int i=0; i<h; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<w; j++) {
				Arrays.fill(visited[i][j], -1);
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static void solution() {
		Status start = new Status(0, 0, k);
		Queue<Status> q = new LinkedList<Status>();
		q.add(start); visited[0][0][0] = k; visited[0][0][1] = k;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0; i<size; i++) {
				Status tmp = q.poll();
				if(tmp.x==h-1&&tmp.y==w-1) {
					System.out.println(ans); System.exit(0);
				}
				if(tmp.horse>0) {
					for(int j=0; j<8; j++) {
						int nx = tmp.x + horse[j][0];
						int ny = tmp.y + horse[j][1];
						if(inRange(nx, ny)&&map[nx][ny]==0&&tmp.horse-1>visited[nx][ny][1]) {
							q.add(new Status(nx, ny, tmp.horse-1)); visited[nx][ny][1] = tmp.horse-1;
						}
					}
				}
				for(int j=0; j<4; j++) {
					int nx = tmp.x + d[j][0];
					int ny = tmp.y + d[j][1];
					if(inRange(nx, ny)&&map[nx][ny]==0&&tmp.horse>visited[nx][ny][0]) {
						q.add(new Status(nx, ny, tmp.horse)); visited[nx][ny][0] = tmp.horse;
					}
				}
			} ans++;
		}
		System.out.println(-1);
	}
	
	static boolean inRange(int x, int y) {
		return x>=0 && y>=0 && x<h && y<w;
	}
}
