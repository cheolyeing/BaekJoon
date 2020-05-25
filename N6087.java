import java.io.*;
import java.util.*;

public class N6087 {
	static int w, h, dp[][], ans=Integer.MAX_VALUE;
	static char[][] map;
	static int[][] pos = new int[2][2];
	static int[][] d = {{1,0},{0,-1},{-1,0},{0,1}};
	
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new char[h][w];
		dp = new  int[h][w];
		int start=0;
		
		for(int i=0; i<h; i++) {
			String s = br.readLine();
			for(int j=0; j<w; j++) {
				map[i][j] = s.charAt(j);
				dp[i][j] = Integer.MAX_VALUE;
				if(map[i][j]=='C') {
					pos[start][0] = i;
					pos[start][1] = j;
					start++;
				}
			}
		}
	}
	
	static void solution() {
		Queue<int[]> q = new LinkedList<int[]>();
		int sx = pos[0][0], sy = pos[0][1];
		int fx = pos[1][0], fy = pos[1][1];
		for(int k=0; k<4; k++) {
			int x = sx + d[k][0], y = sy + d[k][1];
			if(inRange(x, y) && map[x][y]!='*') {
				int[] tmp = {x, y, 0, k};
				q.add(tmp);
			}
		}
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int x = tmp[0], y = tmp[1], m = tmp[2], di = tmp[3];
			
			if(dp[x][y]<m) continue;
			dp[x][y] = m;
			if(x==fx && y==fy) {
				ans = Math.min(ans, m);
				continue;
			}
			
			int nx, ny;
			nx = x + d[di][0]; ny = y + d[di][1];
			if(inRange(nx, ny) && map[nx][ny]!='*') {
				int[] inp = {nx, ny, m, di};
				q.add(inp);
			}
			
			nx = x + d[(di+1)%4][0]; ny = y + d[(di+1)%4][1];
			if(inRange(nx, ny) && map[nx][ny]!='*') {
				int[] inp = {nx, ny, m+1, (di+1)%4};
				q.add(inp);
			}
			
			nx = x + d[(di+3)%4][0]; ny = y + d[(di+3)%4][1];
			if(inRange(nx, ny) && map[nx][ny]!='*') {
				int[] inp = {nx, ny, m+1, (di+3)%4};
				q.add(inp);
			}
		}
		System.out.println(dp[fx][fy]);
	}
	
	static boolean inRange(int x, int y) {
		return x>=0 && x<h && y>=0 && y<w;
	}
}
