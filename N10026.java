import java.io.*;

public class N10026 {
	
	static int n;
	static int[][] delta = { {1,0}, {-1,0}, {0,1}, {0,-1} };
	static char[][] picture;
	static boolean[][] visit;
	static int RGB = 0;
	static int RB = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine()); picture = new char[n+2][n+2];
		for (int i=0; i<n; i++) {
			String s = br.readLine();
			for (int j=0; j<n; j++) {
				picture[i+1][j+1] = s.charAt(j); 
			}
		} // setting
		
		visit = new boolean[n+2][n+2];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(!visit[i][j]) { RGB++;
					dfs(i, j, picture[i][j]);
				}
			}
		}
		
		visit = new boolean[n+2][n+2];
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=n; j++) {
				if(!visit[i][j]) {
					if(picture[i][j]=='B') {
						RB++; dfs(i, j, 'B');
					} else {
						RB++; dfsRG(i, j);
					}
				}
			}
		} sb.append(RGB+" "+RB); System.out.println(sb.toString());
	}
	
	static void dfs(int x, int y, char A) {
		visit[x][y] = true;
		
		for (int i=0; i<4; i++) {
			int nx = x + delta[i][0], ny = y + delta[i][1];
			if(!visit[nx][ny] && picture[nx][ny]==A) {
				dfs(nx, ny, A);
			}
		}
	}
	
	static void dfsRG(int x, int y) {
		visit[x][y] = true;
		
		for (int i=0; i<4; i++) {
			int nx = x + delta[i][0], ny = y + delta[i][1];
			if(!visit[nx][ny] && (picture[nx][ny]=='R' || picture[nx][ny]=='G')) {
				dfsRG(nx, ny);
			}
		}
	}
}
