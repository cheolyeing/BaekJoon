import java.io.*;

public class N1347 {
	static int[][] maze = new int[102][102];
	static int[] pos = {50, 50};
	static int n;
	static int[][] d = {{1,0},{0,-1},{-1,0},{0,1}};
	static int direct = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		char[] command = br.readLine().toCharArray();
		maze[50][50] = 1;
		for (int i=0; i<n; i++) {
			if(command[i]=='R') {
				direct = (direct+1)%4;
			} else if(command[i]=='L') {
				direct = (direct+3)%4;
			} else {
				int nx = pos[0] + d[direct][0];
				int ny = pos[1] + d[direct][1];
				int[] tmp = {nx, ny};
				pos = tmp;
				maze[nx][ny] = 1;
			}
		} showMaze();
	}
	
	static void showMaze() {
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		int sx = 102;
		int sy = 102;
		int lx = 0;
		int ly = 0;
		
		for (int i=0; i<102; i++) {
			for (int j=0; j<102; j++) {
				if(maze[i][j]==1) {
					if(sx>i) { sx = i; }
					if(sy>j) { sy = j; }
					if(lx<i) { lx = i; }
					if(ly<j) { ly = j; }
				}
			}
		}
		
		for (int i=sx; i<=lx; i++) {
			for (int j=sy; j<=ly; j++) {
				if(maze[i][j]==1) {
					sb.append(".");
				} else {
					sb.append("#");
				}
			} sb.append("\n");
		} System.out.print(sb);
	}
}