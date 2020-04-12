import java.io.*;
import java.util.*;

public class N2206 {
	static int n, m, ans=Integer.MAX_VALUE;
	static int[][] map, visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static class Node {
		int x;
		int y;
		int dist;
		int wall;
		
		public Node(int x, int y, int dist, int wall) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.wall = wall;
		}
	}
	
	public static void main(String[] args) throws IOException {
		setting();
	}
	
	static void setting () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new int[n][m];
		
		for (int i=0; i<n; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j=0; j<m; j++) {
				map[i][j] = (int)input[j]-(int)'0';
				visited[i][j] = Integer.MAX_VALUE;
			}
		}
		
		bfs(0, 0);
		System.out.println(ans==Integer.MAX_VALUE ? -1 : ans);
	}
	
	static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(x, y, 1, 0));
		visited[x][y] = 0;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			if(node.x==n-1 && node.y==m-1) {
				ans = node.dist; break;
			}
			
			for (int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
				if(visited[nx][ny]<=node.wall) continue;
				
				if(map[nx][ny]==0) {
					visited[nx][ny] = node.wall;
					q.add(new Node(nx, ny, node.dist+1, node.wall));
				} else {
					if(node.wall==0) {
						visited[nx][ny] = node.wall + 1;
						q.add(new Node(nx, ny, node.dist+1, node.wall+1));
					}
				}
			}
		}
	}
}