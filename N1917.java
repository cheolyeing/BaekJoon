import java.io.*;
import java.util.*;

public class N1917 {
	static int[][] map;
	static int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean made;
	static Cube cube;
	static class Cube {
		public boolean U;
		public Cube L, R, F, B, T;
		
		public Cube() {
			this.U = false;
		}
		
		public void setCube() {
			this.L = new Cube();
			this.R = new Cube();
			this.F = new Cube();
			this.B = new Cube();
			this.T = new Cube();
		}
		
		public Cube moveL() {
			Cube c = this.L;
			c.L = this.T;
			c.R = this;
			c.F = this.F;
			c.B = this.B;
			c.T = this.R;
			return c;
		}
		
		public Cube moveR() {
			Cube c = this.R;
			c.L = this;
			c.R = this.T;
			c.F = this.F;
			c.B = this.B;
			c.T = this.L;
			return c;
		}
		
		public Cube moveF() {
			Cube c = this.F;
			c.L = this.L;
			c.R = this.R;
			c.F = this.T;
			c.B = this;
			c.T = this.B;
			return c;
		}
		
		public Cube moveB() {
			Cube c = this.B;
			c.L = this.L;
			c.R = this.R;
			c.F = this;
			c.B = this.T;
			c.T = this.F;
			return c;
		}
	}
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=0; t<3; t++) {
			map = new int[8][8];
			for(int i=1; i<=6; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=1; j<=6; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			solution();
		}
	}
	
	static void solution() {
		cube = new Cube();
		cube.setCube();
		made = true;
		Loop :
		for(int i=1; i<=6; i++) {
			for(int j=1; j<=6; j++) {
				if(map[i][j]==1) {
					start(i, j, cube);
					break Loop;
				}
			}
		}
		System.out.println(made ? "yes":"no");
	}
	
	static void start(int x, int y, Cube cube) {
		
		if(cube.U) {
			made = false;
		}
		cube.U = true;
		
		//System.out.println(x+","+y);
		//showCube(cube);
		map[x][y] = 0;
		if(map[x+1][y]==1) {
			start(x+1, y, cube.moveF());
		}
		if(map[x-1][y]==1) {
			start(x-1, y, cube.moveB());
		}
		if(map[x][y+1]==1) {
			start(x, y+1, cube.moveR());
		}
		if(map[x][y-1]==1) {
			start(x, y-1, cube.moveL());
		}
	}
	
	/*static void showCube(Cube cube) {
		System.out.println(cube.u.full ? " 1 " : " 0 ");
		System.out.print(cube.r.full ? "1" : "0");
		System.out.print(cube.full ? "1" : "0");
		System.out.println(cube.l.full ? "1" : "0");
		System.out.println(cube.d.full ? " 1 " : " 0 ");
		System.out.println(cube.b.full ? " 1 " : " 0 ");
	}*/
}
