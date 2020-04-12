import java.io.*;
import java.util.*;
public class N17144 {
	static int r, c, t;
	static int[][] map, dmap;
	static int[][] d = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	static int[] airCleaner = new int[2];
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		map = new int[r+1][c+1];
		
		for (int i=1; i<=r; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j=1; j<=c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==-1)
				{ airCleaner[0] = i; airCleaner[1] = j; }
			}
		}
		
		for (int i=0; i<t; i++) {
			expand();
			wind();
		}
		System.out.println(sum());
	}
	
	static void expand() {
		dmap = new int[r+1][c+1];
		for (int i=1; i<=r; i++) {
			for (int j=1; j<=c; j++) {
				if(map[i][j]>0) {
					int size = map[i][j]/5;
					for (int k=0; k<4; k++) {
						int nx = i + d[k][0];
						int ny = j + d[k][1];
						if(inRange(nx,ny) && map[nx][ny]>=0) {
							dmap[nx][ny] += size; map[i][j] -= size;
						}
					}
				}
			}
		}
		for (int i=1; i<=r; i++) {
			for (int j=1; j<=c; j++) {
				map[i][j] += dmap[i][j];
			}
		}
	}
	
	static void wind() {
		// 반시계
		int x = airCleaner[0]-2, y = 1;
		while(x>1) {
			map[x][y] = map[x-1][y];
			x--;
		}
		while(y<c) {
			map[x][y] = map[x][y+1];
			y++;
		}
		while(x<airCleaner[0]-1) {
			map[x][y] = map[x+1][y];
			x++;
		}
		while(y>1) {
			map[x][y] = map[x][y-1];
			y--;
		} map[x][2] = 0;
		// 시계
		x = airCleaner[0]+1; y = 1;
		while(x<r) {
			map[x][y] = map[x+1][y];
			x++;
		}
		while(y<c) {
			map[x][y] = map[x][y+1];
			y++;
		}
		while(x>airCleaner[0]) {
			map[x][y] = map[x-1][y];
			x--;
		}
		while(y>1) {
			map[x][y] = map[x][y-1];
			y--;
		} map[x][2] = 0;
	}
	
	static boolean inRange(int x, int y) {
		if(x>=1 && x<=r && y>=1 && y<=c) return true;
		else return false;
	}
	
	static int sum() {
		int sum = 0;
		for (int i=1; i<=r; i++) {
			for (int j=1; j<=c; j++) {
				sum += map[i][j];
			}
		}
		return sum+2;
	}
	
	static void show() {
		for (int i=1; i<=r; i++) {
			for (int j=1; j<=c; j++) {
				System.out.print(map[i][j]+" ");
			} System.out.println();
		} System.out.println("---------------");
	}
}