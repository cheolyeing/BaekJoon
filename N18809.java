import java.io.*;
import java.util.*;
import java.awt.*;

public class N18809 {
	static class Plant {
		int x, y;
		int type;
		public Plant(int x, int y, int type) {
			this.x=x;
			this.y=y;
			this.type=type;
		}
	}
	static Queue<Plant> q = new LinkedList<Plant>();
	static int n, m, g, r, ans=0;
	static int[][] map;
	static boolean[] visited;
	static ArrayList<Plant> seed = new ArrayList<Plant>();
	static int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
	
	static final int greenType = 3, redType = 4, flowerType = 5; 
	
	public static void main(String[] args) throws IOException {
		setting();
		backTracking(0, 0);
		System.out.println(ans);
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		map = new int[n+2][m+2];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) seed.add(new Plant(i, j, 2));
			}
		}
	}
	
	static void backTracking(int num, int idx) {
		if(num>=g) {
			backTrackingRed(0, 0);
			return;
		}
		for(int i=idx; i<seed.size(); i++) {
			seed.get(i).type = greenType;
			backTracking(num+1, i+1);
			seed.get(i).type = 2;
		}
	}
	
	static void backTrackingRed(int num, int idx) {
		if(num>=r) {
			ans = Math.max(ans, bfs(copyArr(map)));
			return;
		}
		for(int i=idx; i<seed.size(); i++) {
			if(seed.get(i).type==greenType) continue;
			seed.get(i).type = redType;
			backTrackingRed(num+1, i+1);
			seed.get(i).type = 2;
		}
	}
	
	static int[][] copyArr(int[][] map) {
		int[][] res = new int[n+2][m+2];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				res[i][j] = map[i][j];
			}
		}
		for(int i=0; i<seed.size(); i++) {
			Plant p = seed.get(i);
			res[p.x][p.y] = p.type;
			if(p.type!=2) q.add(p);
		}
		/*System.out.println("#########start###########");
		show(res);*/
		return res;
	}
	
	static int bfs(int[][] arr) {
		int flower = 0;
		int[][] dist = new int[n+2][m+2];
		
		while(!q.isEmpty()) {
			Plant p = q.poll();
			if(arr[p.x][p.y]==flowerType) continue;
			for(int i=0; i<4; i++) {
				int nx = p.x+d[i][0];
				int ny = p.y+d[i][1];
				int nt = arr[nx][ny];
				if(nt==0 || nt==p.type || nt==flowerType) continue;
				if(nt==1 || nt==2) {
					arr[nx][ny] = p.type;
					dist[nx][ny] = dist[p.x][p.y]+1;
					q.add(new Plant(nx, ny, p.type));
				} else {
					if(dist[nx][ny]==dist[p.x][p.y]+1) {
						arr[nx][ny] = flowerType;
						flower++;
					}
				}
			}
		}
		/*show(arr);
		System.out.println("("+flower+")#########end###########");
		if(flower==6)System.exit(0);*/
		return flower;
	}
	
	static void show(int[][] arr) {
		for(int i=1; i<arr.length-1; i++) {
			for(int j=1; j<arr[i].length-1; j++) {
				System.out.print(String.format("%2d", arr[i][j])+" ");
			} System.out.println();
		} System.out.println("------------------------");
	}
}