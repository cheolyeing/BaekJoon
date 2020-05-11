import java.io.*;
import java.util.*;
import java.awt.*;

public class N2933 {
	static int r, c, n;
	static int[] attack;
	static int[][] map;
	static int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		setting();
		solution();
		showArr();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		for(int i=0; i<r; i++) {
			String s = br.readLine();
			for(int j=0; j<c; j++) {
				map[i][j] = s.charAt(j)=='.' ? 0 : 1;
			}
		}
		n = Integer.parseInt(br.readLine());
		attack = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) attack[i] = Integer.parseInt(st.nextToken());
	}
	
	static void solution() {
		for(int i=0; i<n; i++) {
			Attack(r-attack[i]+1, i%2==0);
		}
	}
	
	static void Attack(int h, boolean left) {
		if(left) {
			for(int i=0; i<c; i++) {
				if(map[h-1][i]!=0) {
					map[h-1][i] = 0;
					afterAttack();
					break;
				}
			}
		} else {
			for(int i=c-1; i>=0; i--) {
				if(map[h-1][i]!=0) {
					map[h-1][i] = 0;
					afterAttack();
					break;
				}
			}
		}
	}
	
	static void afterAttack() {
		visited = new boolean[r][c];
		ArrayList<Integer> list = new ArrayList<Integer>();
		int n = 1;
		for(int i=r-1; i>=0; i--) {
			for(int j=0; j<c; j++) {
				if(map[i][j]!=0 && !visited[i][j]) {
					if(!bfs(new Point(i, j), n)) {
						list.add(n);
					}
					n++;
				}
			}
		}
		for(int i=0; i<list.size(); i++) {
			moveFall(list.get(i));
		}
	}
	
	static boolean bfs(Point s, int n) {
		boolean bot = false;
		Queue<Point> q = new LinkedList<Point>();
		visited[s.x][s.y] = true;
		q.add(s);
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0; i<size; i++) {
				Point p = q.poll();
				map[p.x][p.y] = n; 
				if(p.x+1==r) bot = true;
				for(int k=0; k<4; k++) {
					Point np = new Point(p.x+d[k][0], p.y+d[k][1]);
					if(inRange(np) && map[np.x][np.y]!=0 && !visited[np.x][np.y]) {
						visited[np.x][np.y] = true; 
						q.add(np);
					}
				}
			}
		}
		
		return bot;
	}
	
	static int minFall(int n) {
		int min = r;
		for(int i=0; i<c; i++) {
			int start=0, finish=r-1;
			boolean find = false;
			boolean first = false;
			for(int j=0; j<r; j++) {
				if(map[j][i]==n) {
					start = j;
					first = true;
					find = true;
				}
				if(first) {
					if(map[j][i]==0) finish = j;
					if(map[j][i]!=0 && map[j][i]!=n) break;
				}
			}
			if(find) min = Math.min(min, finish-start);
		}
		return min;
	}
	
	static void moveFall(int n) {
		int fall = minFall(n);
		for(int y=0; y<c; y++) {
			boolean find = false;
			int s=0, e=0;
			for(int x=0; x<r; x++) {
				if(map[x][y]==n) {
					if(!find) {
						s = x;
						e = x;
						find = true;
					} else {
						e = x;
					}
				}
			}
			if(find) {
				for(int x=e+fall; x>=s+fall; x--) {
					if(map[x-fall][y]==n) {
						map[x][y] = map[x-fall][y];
						map[x-fall][y] = 0;
					}
				}
			}
		}
	}
	
	static boolean inRange(Point p) {
		return 0<=p.x && p.x<r && 0<=p.y && p.y<c;
	}
	
	static void showArr() {
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				System.out.print(map[i][j]!=0 ? "x":".");
			} System.out.println();
		}
	}
}
