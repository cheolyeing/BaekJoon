import java.io.*;
public class N1987 {
	
	static char[][] map;
	static int c;
	static int r;
	static int[][] d = { {1,0}, {-1,0}, {0,1}, {0,-1} };
	static boolean[] visit = new boolean[26];
	static int ans = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		r = Integer.parseInt(input[0]);
		c = Integer.parseInt(input[1]);
		map = new char[r+2][c+2];
		
		for (int i=1; i<=r; i++) {
			String s = br.readLine();
			for (int j=1; j<=c; j++) {
				map[i][j] = s.charAt(j-1);
			}
		}
		
		visit[(int)map[1][1]-65] = true;
		
		for (int i=0; i<=r+1; i++) {
			map[i][0] = map[1][1];
			map[i][c+1] = map[1][1];
		}
		for (int j=0; j<=c+1; j++) {
			map[0][j] = map[1][1];
			map[r+1][j] = map[1][1];
		}
		BackTracking(1, 1, 1);
		System.out.println(ans);
	}
	
	static void BackTracking(int x, int y, int route) {
		ans = Math.max(ans, route);
		
		for (int i=0; i<4; i++) {
			int nx = x + d[i][0];
			int ny = y + d[i][1];
			
			if(!visit[(int)map[nx][ny]-65]) {
				visit[(int)map[nx][ny]-65] = true;
				BackTracking(nx, ny, route+1);
				visit[(int)map[nx][ny]-65]= false;
			}
		}
	}
}