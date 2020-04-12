import java.io.*;

public class N4963 {
	
	static int w;
	static int h;
	static boolean[][] map;
	static int answer;
	static boolean[][] visit;
	static int[][] d = { {1,-1}, {1,0}, {1,1}, {0,1}, {0,-1}, {-1,1}, {-1,0}, {-1,-1} };
	
	
	public static void main(String[] args) throws IOException {
		setting();
		
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		while(!(s=br.readLine()).equals("0 0")) {
			String[] input = s.split(" ");
			w = Integer.parseInt(input[0]);
			h = Integer.parseInt(input[1]);
			map = new boolean[h+2][w+2];
			visit = new boolean[h+2][w+2];
			
			for (int i=0; i<h; i++) {
				String[] info = br.readLine().split(" ");
				for (int j=0; j<w; j++) {
					if(info[j].equals("1")) map[i+1][j+1] = true;
				}
			}
			
			answer = 0;
			for (int i=1; i<=h; i++) {
				for (int j=1; j<=w; j++) {
					if(map[i][j] && !visit[i][j]) {
						answer++; island(i, j);
					}
				}
			}
			System.out.println(answer);
		}
	}
	
	static void island(int x, int y) {
		visit[x][y] = true;
		
		for (int i=0; i<8; i++) {
			int nx = x + d[i][0];
			int ny = y + d[i][1];
			if(map[nx][ny] && !visit[nx][ny]) {
				island(nx, ny);
			}
		}
	}
}