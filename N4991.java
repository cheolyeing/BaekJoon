import java.io.*;
import java.util.*;
import java.awt.*;

public class N4991 {
	static int w, h, size, ans=0;
	static int[][] dis;
	static int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
	static char[][] map;
	static boolean[] selected;
	static ArrayList<Point> dust;
	static Point start;
	
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w==0 && h==0) break;
			
			ans = 0;
			map = new char[h][w];
			dust = new ArrayList<Point>();
			for(int i=0; i<h; i++) {
				String s = br.readLine();
				for(int j=0; j<w; j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j]=='*') dust.add(new Point(i, j));
					else if(map[i][j]=='o') start = new Point(i, j);
				}
			}
			dust.add(0, start);
			
			size = dust.size();
			dis = new int[size][size];
			selected = new boolean[size];
			for(int i=0; i<size; i++) {
				if(!bfs(i)) {
					ans = -1;
					break;
				}
			}
			
			if(ans==-1) {
				System.out.println(ans);
				continue;
			} else {
				ans = Integer.MAX_VALUE;
				selected[0] = true;
				dfs(0, 0, 0);
				System.out.println(ans);
			}
		}
		
	}
	
	static void dfs(int depth, int dist, int from) {
		if(depth==size-1) {
			ans = Math.min(ans,  dist);
			return;
		}
		
		for(int to=1; to<size; ++to) {
			if(!selected[to]) {
				selected[to] = true;
				dfs(depth+1, dist+dis[from][to], to);
				selected[to] = false;
			}
		}
	}
	
	static boolean bfs(int from) {
		Queue<Point> q = new LinkedList<Point>();
		Point start = dust.get(from);
		int dist=0, num=0;
		boolean[][] visited = new boolean[h][w];
		visited[start.x][start.y] = true;
		q.add(start);
		
		while(!q.isEmpty()) {
			int s = q.size();
			for(int i=0; i<s; i++) {
				Point p = q.poll();
				if(map[p.x][p.y]=='o' || map[p.x][p.y]=='*') {
					for(int to=0; to<size; to++) {
						Point tmp = dust.get(to);
						if(tmp.x==p.x && tmp.y==p.y) {
							dis[from][to] = dist;
							dis[to][from] = dist;
							num++;
						}
					}
				}
				for(int k=0; k<4; k++) {
					Point np = new Point(p.x+d[k][0], p.y+d[k][1]);
					if(inRange(np) && !visited[np.x][np.y] && map[np.x][np.y]!='x') {
						visited[np.x][np.y] = true; 
						q.add(np);
					}
				}
			}
			dist++;
		}
		return num==size;
	}
	
	static boolean inRange(Point p) {
		return p.x>=0 && p.x<h && p.y>=0 && p.y<w;
	}
}
