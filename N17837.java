import java.io.*;
import java.util.*;

public class N17837 {
	static int n, k, t=0;
	static int[][] map;
	static int[][] d = {{0,0}, {0,1}, {0,-1}, {-1,0}, {1,0}};
	static int[][] occupied;
	static class Mal {
		int num;
		int x, y;
		int dir;
		int up;
		int down;
		public Mal(int num, int x, int y, int dir, int up, int down) {
			this.num = num;
			this.x = x; this.y = y;
			this.dir = dir;
			this.up = up;
			this.down = down;
		}
		
		public boolean hasUp () {return this.up!=0;}
		
		public boolean hasDown() {return this.down!=0;}
		
		public void cutDown() {this.down = 0;}
		
		public void cutUp() {this.up =0;}
		
		public void changeDir() {this.dir = dir%2==0 ? dir-1 : dir+1;}
	}
	static Mal[] mal;
	public static void main(String[] args) throws IOException {
		setting();
		System.out.println(turn(1));
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		occupied = new int[n+1][n+1];
		mal = new Mal[k+1];
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<=k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			mal[i] = new Mal(i, x, y, d, 0, 0);
			occupied[x][y] = i;
		}
	}
	
	static int turn(int time) {
		//show(occupied);
		if(finish()) {
			return time;
		} else if(time>1000) {
			return -1;
		} else {
			for(int i=1; i<=k; i++) {
				int nx = mal[i].x + d[mal[i].dir][0];
				int ny = mal[i].y + d[mal[i].dir][1];
				if(inRange(nx, ny) && map[nx][ny]!=2) {
					// 움직이기 전의 밑의 말
					if(mal[i].hasDown()) {
						int d = mal[i].down;
						mal[d].cutUp();
						mal[i].cutDown();
						occupied[mal[i].x][mal[i].y] = d; 
					} else {
						occupied[mal[i].x][mal[i].y] = 0; 
					}
					
					// 위의 말들 같이 움직인다.
					int top = i;
					int rt = i;
					
					while(top!=0) {
						mal[top].x = nx;
						mal[top].y = ny;
						top = mal[top].up;
						//System.out.println(top);
						if(top!=0) rt = top;
					}
					
					// 움직이고 난 후의 색깔
					if(map[nx][ny]==1) {
						reverse(i);
						if(occupied[nx][ny]!=0) {
							connect(rt, occupied[nx][ny]);
							if(midFinish(rt)) return time;
						}
						occupied[nx][ny] = i;
					} else {
						if(occupied[nx][ny]!=0) {
							connect(i, occupied[nx][ny]);
							if(midFinish(rt)) return time;
						}
						occupied[nx][ny] = rt;
					}
				} else {
					mal[i].changeDir();
					nx = mal[i].x + d[mal[i].dir][0];
					ny = mal[i].y + d[mal[i].dir][1];
					if(inRange(nx, ny) && map[nx][ny]!=2) {
						// 움직이기 전의 밑의 말
						if(mal[i].hasDown()) {
							int d = mal[i].down;
							mal[d].cutUp();
							mal[i].cutDown();
							occupied[mal[i].x][mal[i].y] = d; 
						} else {
							occupied[mal[i].x][mal[i].y] = 0; 
						}
						
						// 위의 말들 같이 움직인다.
						int top = i;
						int rt = i;
						
						while(top!=0) {
							mal[top].x = nx;
							mal[top].y = ny;
							top = mal[top].up;
							//System.out.println(top);
							if(top!=0) rt = top;
						}
						
						// 움직이고 난 후의 색깔
						if(map[nx][ny]==1) {
							reverse(i);
							if(occupied[nx][ny]!=0) {
								connect(rt, occupied[nx][ny]);
								if(midFinish(rt)) return time;
							}
							occupied[nx][ny] = i;
						} else {
							if(occupied[nx][ny]!=0) {
								connect(i, occupied[nx][ny]);
								if(midFinish(rt)) return time;
							}
							occupied[nx][ny] = rt;
						}
					}
				}
			}
			return turn(time+1);
		}
	}
	
	static boolean finish() {
		for(int i=1; i<k; i++) {
			if(midFinish(i)) return true;
		}
		return false;
	}
	
	static boolean midFinish(int idx) {
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		tmp.add(idx);
		int u = mal[idx].up;
		while(u!=0) {
			tmp.add(0, u);
			u = mal[u].up;
		}
		
		int d = mal[idx].down;
		while(d!=0) {
			tmp.add(d);
			d = mal[d].down;
		}
		if(tmp.size()>=4) return true;
		else return false;
	}
	
	static void connect(int u, int d) {
		mal[u].down = d;
		mal[d].up = u;
	}
	
	static void reverse(int idx) {
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		tmp.add(idx);
		int u = mal[idx].up;
		while(u!=0) {
			tmp.add(0, u);
			u = mal[u].up;
		}
		
		int d = mal[idx].down;
		while(d!=0) {
			tmp.add(d);
			d = mal[d].down;
		}
		
		for(int i=0; i<tmp.size()-1; i++) {
			d = tmp.get(i);
			u = tmp.get(i+1);
			mal[d].up = u;
			mal[u].down = d;
		}
		mal[tmp.get(0)].cutDown();
		mal[tmp.get(tmp.size()-1)].cutUp();	
	}
	
	static void split(int u) {
		int d = mal[u].down;
		mal[d].up = 0;
		mal[u].down = 0;
	}
	
	static void show(int[][] arr) {
		for(int i=1; i<arr.length; i++) {
			for(int j=1; j<arr[i].length; j++) {
				System.out.print(String.format("%2d", arr[i][j])+" ");
			} System.out.println();
		} System.out.println("-----------------------");
	}
	
	static boolean inRange(int nx, int ny) {return (nx>0 && nx<=n && ny>0 && ny<=n);}
}