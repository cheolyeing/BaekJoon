import java.io.*;

public class N14499 {
	
	static int n, m, x, y, command;
	static int[] cube = {0, 0, 0, 0, 0, 0};
	static int[][] map;
	static int[] pos = {0, 0};
	static String[] com;
	
	public static void main(String[] args) throws IOException {
		setting();
		for (int i=0; i<command; i++) {
			turn(Integer.parseInt(com[i]));
		}
	}
	
	static void turn(int direct) {
		int nx = pos[0], ny = pos[1];
		if(direct==1) { ny++; }
		if(direct==2) { ny--; }
		if(direct==3) { nx--; }
		if(direct==4) { nx++; }
		
		if(canGo(nx, ny)) {
			setCube(direct);
			if(map[nx][ny]==0) {
				map[nx][ny] = cube[2];
			} else {
				cube[2] = map[nx][ny];
				map[nx][ny] = 0;
			} System.out.println(cube[0]);
			int[] tmp = {nx, ny}; pos = tmp;
		}
		
		
	}
	
	static boolean canGo(int nx, int ny) {
		if(nx<0 || ny<0 || nx>=n || ny>=m) {
			return false;
		} else { return true; }
	}
	
	static void setting() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		x = Integer.parseInt(input[2]);
		y = Integer.parseInt(input[3]);
		command = Integer.parseInt(input[4]); 
		map = new int[n][m];
		int tmp[] = {x, y}; pos = tmp;
		
		for (int i=0; i<n; i++) {
			String[] pos = br.readLine().split(" ");
			for (int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(pos[j]);
			} 
		} com = br.readLine().split(" ");
	}
	
	static void setCube(int direct) {
		int n1 = cube[0]; int n2 = cube[1]; int n3 = cube[2];
		int n4 = cube[3]; int n5 = cube[4]; int n6 = cube[5];
		if(direct == 1) {int[] tmp = {n5, n2, n6, n4, n3, n1}; cube = tmp;}
		if(direct == 2) {int[] tmp = {n6, n2, n5, n4, n1, n3}; cube = tmp;}
		if(direct == 3) {int[] tmp = {n2, n3, n4, n1, n5, n6}; cube = tmp;}
		if(direct == 4) {int[] tmp = {n4, n1, n2, n3, n5, n6}; cube = tmp;}
	}
}