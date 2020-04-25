import java.io.*;
import java.util.*;

public class N6593 {
	static int l, r, c;
	static char[][][] building;
	static boolean[][][] visited;
	static class Pos {
		public int x, y, z;
		public Pos(int x, int y, int z) {
			this.x = x; this.y = y; this.z = z;
		}
		public Pos nextPos(int i) {
			if(i==0) return new Pos(x+1, y, z);
			if(i==1) return new Pos(x-1, y, z);
			if(i==2) return new Pos(x, y+1, z);
			if(i==3) return new Pos(x, y-1, z);
			if(i==4) return new Pos(x, y, z+1);
			else return new Pos(x, y, z-1);
		}
		public boolean end(Pos e) {
			return this.x==e.x && this.y==e.y && this.z==e.z;
		}
	}
	static Pos start, end;
	
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			building = new char[l][r][c];
			visited = new boolean[l][r][c];
			for(int i=0; i<l; i++) {
				for(int j=0; j<r; j++) {
					String s = br.readLine();
					for(int k=0; k<c; k++) {
						building[i][j][k] = s.charAt(k);
						if(building[i][j][k]=='S') {
							start = new Pos(i, j, k);
						} else if(building[i][j][k]=='E') {
							end = new Pos(i, j, k);
						}
					}
				}
				br.readLine();
			}
			if(l==0 && r==0 && c==0) break;
			solution();
		}
	}
	
	static void solution() {
		int ans = 0;
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(start);
		visit(start);
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0; i<size; i++) {
				Pos p = q.poll();
				if(p.end(end)) {
					System.out.println("Escaped in "+ans+" minute(s).");
					return;
				}
				for(int j=0; j<6; j++) {
					Pos np = p.nextPos(j);
					if(inRange(np) && !visited(np) && status(np)!='#') {
						visit(np); q.add(np);
					}
				}
			}
			ans++;
		}
		System.out.println("Trapped!");
		return;
	}
	
	static char status(Pos p) {
		return building[p.x][p.y][p.z];
	}
	
	static void visit(Pos p) {
		visited[p.x][p.y][p.z] = true; 
	}
	
	static boolean visited(Pos p) {
		return visited[p.x][p.y][p.z];
	}
	
	static boolean inRange(Pos p) {
		return p.x>=0 && p.y>=0 && p.z>=0 && p.x<l && p.y<r && p.z<c;
	}
}
