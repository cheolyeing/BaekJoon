import java.io.*;
import java.util.*;

public class N17143 {
	static class Shark {
		int x, y, v;
		int dir, size;
		boolean eaten;
		public Shark(int x, int y, int v, int dir, int size) {
			this.x = x; this.y = y; this.v = v;
			this.dir = dir; this.size = size;
			this.eaten = false;
		}
	}
	static Shark[] shark;
	static int r, c, m, ans = 0;
	static int[][] d = {{0,0}, {-1,0}, {1,0}, {0,1}, {0,-1}};
	static int[][] map;
	static int[][] occupied;
	public static void main(String[] args) throws IOException {
		setting();
		solution();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		shark = new Shark[m+1];
		map = new int[r+1][c+1];
		occupied = new int[r+1][c+1];
		
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			shark[i] = new Shark(r, c, s, d, z);
			occupied[r][c] = i;
		}
	}
	
	static void solution() {
		for(int i=1; i<=c; i++) {
			
			for(int j=1; j<=r; j++) {
				if(occupied[j][i]!=0) {
					ans += shark[occupied[j][i]].size;
					shark[occupied[j][i]].eaten = true;
					occupied[j][i] = 0;
					break;
				}
			}
			
			for(int j=1; j<=m; j++) {
				sharkMove(j);
			}
		}
		System.out.println(ans);
	}
	
	static void sharkMove(int idx) {
		if(shark[idx].eaten) return;
		if(occupied[shark[idx].x][shark[idx].y]==idx) occupied[shark[idx].x][shark[idx].y] = 0;
		 
		int nx = shark[idx].x + d[shark[idx].dir][0] * shark[idx].v;
		int ny = shark[idx].y + d[shark[idx].dir][1] * shark[idx].v;
		if(shark[idx].x==nx) {
			if(yRange(ny)) {
				shark[idx].y = ny;
			} else {
				ny = shark[idx].y;
				int t = shark[idx].v;
				int d = shark[idx].dir==3 ? 1 : -1;
				while(t>0) {
					if((ny==1&&ny+d==0) || (ny==c&&ny+d>c)) d *= -1;
					ny += d;
					t--;
				}
				shark[idx].dir = d==1 ? 3 : 4;
				shark[idx].y = ny;
			}
		} else {
			if(xRange(nx)) {
				shark[idx].x = nx;
			} else {
				nx = shark[idx].x;
				int t = shark[idx].v;
				int d = shark[idx].dir==2 ? 1 : -1;
				while(t>0) {
					if((nx==1&&nx+d==0) || (nx==r&&nx+d>r)) d *= -1;
					nx += d;
					t--;
				}
				shark[idx].dir = d==1 ? 2 : 1;
				shark[idx].x = nx;
			}
		}
		int oc = occupied[shark[idx].x][shark[idx].y];
		if(oc!=0 && oc<idx) {
			if(shark[oc].size>shark[idx].size) shark[idx].eaten = true;
			else {
				shark[oc].eaten = true;
				occupied[shark[idx].x][shark[idx].y] = idx;
			}
		} else occupied[shark[idx].x][shark[idx].y] = idx; 
	}
	
	static boolean xRange(int x) {
		return (x>0 && x<=r);
	}
	
	static boolean yRange(int y) {
		return (y>0 && y<=c);
	}
	
	static void showArr(int[][] arr) {
		for(int i=1; i<arr.length; i++) {
			for(int j=1; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			} System.out.println();
		} System.out.println("-------------------");
	}
	
	static int changeDir(int dir) {
		return dir%2==0 ? dir-1 : dir+1;
	}
}